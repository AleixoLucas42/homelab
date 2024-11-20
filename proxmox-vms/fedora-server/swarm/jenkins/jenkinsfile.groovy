pipeline {
    agent any
    environment {
        //PIPELINE INFO
        REPOSITORY_LINK = "https://github.com/AleixoLucas42/nginx-httpe2ban"
        DOCKERHUB_REPOSITORY = "aleixolucas"
        SWARM_SERVICE = "nginx_nginx_httpe2ban"
        
        //SECRET VAULT
        DOCKERHUB_USERNAME = credentials('DOCKERHUB_USERNAME')
        DOCKERHUB_PASSWORD = credentials('DOCKERHUB_PASSWORD')
    }
    stages {
        stage('prepare_environment') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    workspace_folder=$(echo "${REPOSITORY_LINK}" | awk -F'/' '{print $NF}')
                    rm -rf .git/ .* *
                    git clone ${REPOSITORY_LINK} .
                    '''
                    sh buildScript
                }
            }
        }
        stage('docker_build') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    GIT_HASH=$(git log -1 --format="%H" | cut -c1-6 | tr -d '\n')
                    REPO_NAME=$(git remote get-url origin | sed 's#.*/##' | sed 's/.git$//')
                    DOCKERFILE=$(find . -type f -regex '.*[Dd]ockerfile')

                    echo "[*] Running: docker build --no-cache -t ${DOCKERHUB_REPOSITORY}/${REPO_NAME}:latest -f ${DOCKERFILE} . --network=host"
                    docker build --no-cache -t ${DOCKERHUB_REPOSITORY}/${REPO_NAME}:latest -f ${DOCKERFILE} . --network=host
                    '''
                    sh buildScript
                }
            }
        }
        stage('docker_push') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    GIT_HASH=$(git log -1 --format="%H" | cut -c1-6 | tr -d '\n')
                    REPO_NAME=$(git remote get-url origin | sed 's#.*/##' | sed 's/.git$//')
                    DOCKERFILE=$(find . -type f -regex '.*[Dd]ockerfile')

                    docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}

                    echo "[*] Running: docker push ${DOCKERHUB_REPOSITORY}/${REPO_NAME}:latest"
                    docker push ${DOCKERHUB_REPOSITORY}/${REPO_NAME}:latest
                    '''
                    sh buildScript
                }
            }
        }
        stage('update_swarm') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    REPO_NAME=$(git remote get-url origin | sed 's#.*/##' | sed 's/.git$//')
                    docker pull ${DOCKERHUB_REPOSITORY}/${REPO_NAME}:latest
                    DIGEST=$(docker inspect --format='{{index .RepoDigests 0}}' ${DOCKERHUB_REPOSITORY}/${REPO_NAME}:latest | cut -d@ -f2)
                    REPLICAS=$(docker service inspect cardsgo_cardsgo --format '{{.Spec.Mode.Replicated.Replicas}}')
                    echo "[+] Scalling up application for no downtime"
                    docker service scale ${SWARM_SERVICE}=$((REPLICAS + 1))
                    echo "[*] Running: docker service update --image ${DOCKERHUB_REPOSITORY}/${REPO_NAME}@${DIGEST} --force ${SWARM_SERVICE}"
                    docker service update --image ${DOCKERHUB_REPOSITORY}/${REPO_NAME}@${DIGEST} --force ${SWARM_SERVICE}
                    echo "[+] Scalling down application after update"
                    docker service scale ${SWARM_SERVICE}=$((REPLICAS))
                    '''
                    sh buildScript
                }
            }
        }
    }
}
