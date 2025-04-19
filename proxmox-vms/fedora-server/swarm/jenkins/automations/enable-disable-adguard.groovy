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
                    # Obtém o status atual usando -u para autenticação
                    script_url="https://raw.githubusercontent.com/usuario/repositorio/branch/script.sh"

                    # Baixando e executando o script
                    curl -sSL "$script_url" | bash
                    '''
                    sh buildScript
                }
            }
        }
    }
}
