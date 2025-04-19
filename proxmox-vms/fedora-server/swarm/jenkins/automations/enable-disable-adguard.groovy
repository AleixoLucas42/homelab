pipeline {
    agent any
    environment {
        //GLOBAL SECRETS
        ADGUARD_USER = credentials('ADGUARD_USER')
        ADGUARD_PASSWORD = credentials('ADGUARD_PASSWORD')
    }
    stages {
        stage('run_script') {
            steps {
                script {
                    def buildScript = '''#!/bin/bash
                    script_url="https://raw.githubusercontent.com/AleixoLucas42/homelab/refs/heads/main/proxmox-vms/fedora-server/swarm/jenkins/automations/enable-disable-adguard.sh"

                    curl -sSL "$script_url" | bash
                    '''
                    sh buildScript
                }
            }
        }
    }
}
