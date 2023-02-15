# Hashicorp vault
Secure, store and tightly control access to tokens, passwords, certificates, encryption keys for protecting secrets and other sensitive data using a UI, CLI, or HTTP API.

## Setup
```
helm repo add hashicorp https://helm.releases.hashicorp.com
kubectl create ns vault
helm install vault hashicorp/vault -n vault
kubectl exec -n vault --stdin=true --tty=true vault-0 -- vault operator init
kubectl exec -n vault --stdin=true --tty=true vault-0 -- vault operator unseal # ... Unseal Key 1
kubectl exec -n vault --stdin=true --tty=true vault-0 -- vault operator unseal # ... Unseal Key 2
kubectl exec -n vault --stdin=true --tty=true vault-0 -- vault operator unseal # ... Unseal Key 3
kubectl exec -n vault --stdin=true --tty=true vault-0 -- vault auth enable userpass
kubectl apply -f vault-in.yaml
```

## Backup/Restore
- crontab: @daily /home/aleixohome/vault-backup.sh
```
# Install
pip install vault-dump-restore

# Mandatory var
export VAULT_ADDR=https://<vault-addr>
export VAULT_TOKEN=<vault-token>

# Backup
vault-dump -o vault > vault-backup.sh

# Opcional
vault-dump -o vault | gpg --symmetric --cipher-algo AES25 > vault-backup.sh.enc

# Restore
vault secrets enable -path=secrets kv
. <(gpg -qd vault-backup.sh.enc)
bash vault-backup.sh
```

# Useful links
- [Vault on Kubernetes Deployment Guide](https://developer.hashicorp.com/vault/tutorials/kubernetes/kubernetes-raft-deployment-guide)
- [Userpass Auth Method](https://developer.hashicorp.com/vault/docs/auth/userpass)
- [Token Auth Method](https://developer.hashicorp.com/vault/docs/auth/token)
- [Seal/Unseal](https://developer.hashicorp.com/vault/docs/concepts/seal)
- [Helm Github](https://github.com/hashicorp/vault-helm)
- [Vault backup](https://developer.hashicorp.com/vault/tutorials/standard-procedures/sop-backup)
- [Vault restore](https://developer.hashicorp.com/vault/tutorials/standard-procedures/sop-restore)
- [Another backup option](https://pypi.org/project/vault-dump-restore/)