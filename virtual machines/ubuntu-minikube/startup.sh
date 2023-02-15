#!/bin/bash

#Variables
export $(cat /home/aleixohome/.env | xargs)
MINIKUBE_IP=$(minikube ip)
MAIN_IFACE=$(hostname -I | cut -d " " -f1)

#Start Minikube
minikube status | grep \
    -e "host: Running" \
    -e "kubelet: Running" \
    -e "apiserver: Running" \
    -e "kubeconfig: Configured"
if [[ $? != 0 ]]; then
minikube start --memory 4096 --cpus 4 && \
    echo "MINIKUBE IP: $(minikube ip)" \
    || echo "Fail to start minikube"

#Sleep 30s
echo "Sleeping 30s" && sleep 30
fi

#Create iptables rule 80
sudo iptables \
    -t nat \
    -A PREROUTING \
    -p tcp \
    -d ${MAIN_IFACE} \
    --dport 80 \
    -j DNAT \
    --to ${MINIKUBE_IP}:80 || echo "Fail to create a iptables forwading 1"
sudo iptables \
    -A FORWARD \
    -p tcp \
    -d ${MINIKUBE_IP} \
    --dport 80 \
    -j ACCEPT || echo "Fail to create a iptables forwading 2"
#Create iptables rule 443
sudo iptables \
    -t nat \
    -A PREROUTING \
    -p tcp \
    -d ${MAIN_IFACE} \
    --dport 443 \
    -j DNAT \
    --to ${MINIKUBE_IP}:443 || echo "Fail to create a iptables forwading 3"
sudo iptables \
    -A FORWARD \
    -p tcp \
    -d ${MINIKUBE_IP} \
    --dport 443 \
    -j ACCEPT || echo "Fail to create a iptables forwading 4"

#Auto unseal vault "Shamir seals"
while true
do
    kubectl get pods -n vault | grep vault-0 | grep -q Running
    if [[ $? = 0 ]]; then
        sleep 60
        kubectl exec -n vault --stdin=true --tty=true vault-0 -- vault operator unseal ${VAULT_UNSEAL_KEY_1}
        kubectl exec -n vault --stdin=true --tty=true vault-0 -- vault operator unseal ${VAULT_UNSEAL_KEY_2}
        kubectl exec -n vault --stdin=true --tty=true vault-0 -- vault operator unseal ${VAULT_UNSEAL_KEY_3}
        break
    else
        sleep 15
    fi
done

# Add mapping /etc/hosts
sudo echo "$(minikube ip) vault.aleixohome.lan" >> /etc/hosts 