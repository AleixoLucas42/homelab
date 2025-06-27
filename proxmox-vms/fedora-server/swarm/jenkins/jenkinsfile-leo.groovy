pipeline {
    agent any
    environment {
        //PIPELINE INFO
        GIT_REPOSITORY = "git@github.com:AleixoLeonardo/planit-api.git"
        DOCKERHUB_REPOSITORY = "aleixoleonardo"
        SWARM_SERVICE = "leo-planit-api_planit-api"
        REPO_FOLDER = "planit-api"
        
        //SECRET VAULT
        GITHUB_SSH_KEY = credentials('GITHUB_SSH_KEY')
    }
    stages {
        stage('prepare_environment') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    rm -rf ./${REPO_FOLDER}
                    echo ${GITHUB_SSH_KEY} | base64 -d > git-private-key
                    chmod 600 git-private-key
                    mkdir -p ~/.ssh
                    ssh-keyscan -H github.com >> ~/.ssh/known_hosts 2>/dev/null || echo "[!] ERRO AO ATUALIZAR A CHAVE DO REPOSITORIO"
                    GIT_SSH_COMMAND="ssh -i ./git-private-key -o IdentitiesOnly=yes" git clone ${GIT_REPOSITORY}  || echo "[!] ERRO AO CLONAR O REPOSITORIO"
                    '''
                    sh buildScript
                }
            }
        }
        stage('docker_build') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    cd $REPO_FOLDER
                    GIT_HASH=$(git log -1 --format="%H" | cut -c1-6 | tr -d '\n')
                    REPO_NAME=$(git remote get-url origin | sed 's#.*/##' | sed 's/.git$//')
                    DOCKERFILE=$(find . -type f -regex '.*[Dd]ockerfile')
                    HASH=$(shuf -i 10000000-99999999 -n 1)
                    echo "$HASH" > hash.txt

                    echo "[*] Running: docker build --no-cache -t ${DOCKERHUB_REPOSITORY}/${REPO_NAME}:${HASH} -f ${DOCKERFILE} . --network=host"
                    docker build --no-cache -t ${DOCKERHUB_REPOSITORY}/${REPO_NAME}:${HASH} -f ${DOCKERFILE} . --network=host
                    '''
                    sh buildScript
                }
            }
        }
        stage('update_swarm') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    cd $REPO_FOLDER
                    REPO_NAME=$(git remote get-url origin | sed 's#.*/##' | sed 's/.git$//')
                    HASH=$(cat hash.txt)
                    REPLICAS=$(docker service inspect $SWARM_SERVICE --format '{{.Spec.Mode.Replicated.Replicas}}')
                    echo "[+] Scalling up application for no downtime"
                    docker service scale ${SWARM_SERVICE}=$((REPLICAS + 1))
                    echo "[*] Running: docker service update --image ${DOCKERHUB_REPOSITORY}/${REPO_NAME}@${HASH} --force ${SWARM_SERVICE}"
                    docker service update --image ${DOCKERHUB_REPOSITORY}/${REPO_NAME}@${DIGEST} --force ${SWARM_SERVICE}
                    echo "[+] Scalling down application after update"
                    docker service scale ${SWARM_SERVICE}=$((REPLICAS))
                    echo "[+] Removing old containers"
                    docker rmi $(docker image ls -q) || echo "OK"
                    '''
                    sh buildScript
                }
            }
        }
    }
}
