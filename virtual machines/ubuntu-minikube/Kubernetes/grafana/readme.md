# Grafana
Grafana is a cross-platform open source analytics and interactive web visualization web application. It delivers charts, graphs and alerts to the web when connected to supported data sources. It is expandable through a plug-in system.

## Setup
```
helm repo add bitnami https://charts.bitnami.com/bitnami
kubectl create ns grafana
helm install grafana-aleixohome bitnami/grafana -n grafana
kubectl get secret grafana-aleixohome-admin --namespace grafana -o jsonpath="{.data.GF_SECURITY_ADMIN_PASSWORD}" | base64 -d
kubectl apply -f grafana-in.yaml
```

# Useful links
- [Download Grafana](https://grafana.com/grafana/download)
- [Grafana Docs](https://grafana.com/docs/)
- [Why use Grafana?](https://grafana.com/grafana/)