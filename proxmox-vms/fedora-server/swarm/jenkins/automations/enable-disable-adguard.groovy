pipeline {
    agent any
    environment {
        // GLOBAL SECRETS
        ADGUARD_USER = credentials('ADGUARD_USER')
        ADGUARD_PASSWORD = credentials('ADGUARD_PASSWORD')
    }
    stages {
        stage('prepare_environment') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    # Monta o cabeçalho de autenticação
                    auth_header=$(echo -n "${ADGUARD_USER}:${ADGUARD_PASSWORD}" | base64)

                    # Consulta o status atual da proteção
                    status=$(curl -sk --location --request GET "http://adguardhome_adguardhome/control/status" \\
                        --header "Accept: application/json" \\
                        --header "Content-Type: application/json" \\
                        --header "Authorization: Basic $auth_header" \\
                        | grep -o '"protection_enabled":[^,]*' | cut -d: -f2 | tr -d ' ')

                    echo "Proteção está atualmente: $status"

                    # Define o novo status com base no atual
                    if [ "$status" == "true" ]; then
                        new_status=false
                    else
                        new_status=true
                    fi

                    # Monta o payload JSON corretamente
                    json_payload="{\\"enabled\\":$new_status}"

                    # Envia a requisição para alterar o status
                    curl -sk --location --request POST "http://adguardhome_adguardhome/control/protection" \\
                        --header "Accept: application/json" \\
                        --header "Content-Type: application/json" \\
                        --header "Authorization: Basic $auth_header" \\
                        --data "$json_payload"

                    echo -e "\\nNovo status enviado: $json_payload"
                    '''
                    sh buildScript
                }
            }
        }
    }
}