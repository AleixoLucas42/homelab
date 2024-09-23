pipeline {
    agent any
    environment {
        //PIPELINE INFO
        STACK_NAME = "nginx"
    }
    stages {
        stage('restarting_nginx') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    echo "[!] restarting stack $STACK_NAME"
                    docker stack services $STACK_NAME --format "{{.Name}}" | xargs -n1 docker service update --force
                    echo "[*] done!"
                    '''
                    sh buildScript
                }
            }
        }
    }
}
