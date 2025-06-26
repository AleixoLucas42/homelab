pipeline {
    agent any
    environment {
        // GLOBAL SECRETS
        MAC = "b0:25:aa:5d:a0:cb"
        COMPUTER = "AVELL"
    }
    stages {
        stage('wol') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    echo "[+] Sending wol to computer $COMPUTER on $MAC"
                    docker run \
                      --rm \
                      --net=host \
                      -e mac='b0:25:aa:5d:a0:cb' \
                      jazzdd/wol
                    '''
                    sh buildScript
                }
            }
        }
    }
}
