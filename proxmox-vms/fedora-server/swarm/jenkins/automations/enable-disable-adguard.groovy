pipeline {
    agent any
    environment {
        //GLOBAL SECRETS
        ADGUARD_USER = credentials('ADGUARD_USER')
        ADGUARD_PASSWORD = credentials('ADGUARD_PASSWORD')
    }
    stages {
        stage('prepare_environment') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    auth_header=$(echo -n "${ADGUARD_USER}:${ADGUARD_PASSWORD}" | base64)
                    status=$(curl -sk --location --request GET "http://adguardhome_adguardhome/control/status" \
                        --header "Accept: application/json" \
                        --header "Content-Type: application/json" \
                        --header "Authorization: Basic $auth_header" \
                        | grep -o '"protection_enabled":[^,]*' | cut -d: -f2 | tr -d ' ')

                    echo "Proteção está atualmente: $status"

                    if [ "$status" == "true" ]; then
                        new_status=false
                    else
                        new_status=true
                    fi

                    curl -sk --location --request POST "http://adguardhome_adguardhome/control/protection" \
                        --header "Accept: application/json" \
                        --header "Content-Type: application/json" \
                        --header "Authorization: Basic $auth_header" \
                        --data "{\"enabled\":$new_status}"

                    echo -e "\nNovo status enviado: enabled = $new_status"
                    '''
                    sh buildScript
                }
            }
        }
    }
}
