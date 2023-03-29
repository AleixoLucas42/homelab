# Jenkins
Jenkins is the leading open source automation server, Jenkins provides hundreds of plugins to support building, deploying and automating any project.

## Setup
```
kubectl create ns jenkins
helm repo add jenkins https://charts.jenkins.io
helm repo update
helm install jenkins-aleixohome jenkins/jenkins -n jenkins
user: admin
password: $(kubectl exec --namespace jenkins -it svc/jenkins-aleixohome -c jenkins -- /bin/cat /run/secrets/additional/chart-admin-password && echo)
kubectl apply -f jenkins-in.yaml
```

# Usefull links
- [Helm chart](https://github.com/jenkinsci/helm-charts/blob/main/charts/jenkins/README.md)
- [Site](https://www.jenkins.io/)
- [Artifact hub](https://artifacthub.io/packages/helm/jenkinsci/jenkins)
- [Docs/guides](https://www.jenkins.io/doc/)

