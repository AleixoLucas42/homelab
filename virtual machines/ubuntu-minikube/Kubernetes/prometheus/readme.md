# Prometheus
An open-source monitoring system with a dimensional data model, flexible query language, efficient time series database and modern alerting approach.

## Setup

```
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update
kubectl create namespace prometheus
helm install -n prometheus kube-prometheus-stack prometheus-community/kube-prometheus-stack --set prometheus.prometheusSpec.podMonitorSelectorNilUsesHelmValues=false,prometheus.prometheusSpec.serviceMonitorSelectorNilUsesHelmValues=false
```
```
kubectl apply -f prometheus-in.yaml
```

## Monitoring nginx with prometheus

```
kubectl annotate deployment -n ingress-nginx ingress-nginx-controller prometheus.io/port=10254
kubectl annotate deployment -n ingress-nginx ingress-nginx-controller prometheus.io/scrape=true

kubectl annotate service -n ingress-nginx ingress-nginx-controller prometheus.io/port=10254
kubectl annotate service -n ingress-nginx ingress-nginx-controller-admission prometheus.io/scrape=true
```
- Configure ports on services and deployments as [docs](https://kubernetes.github.io/ingress-nginx/user-guide/monitoring/).

Service:
```
kubectl -n ingress-nginx patch service ingress-nginx-controller -p '{ "spec": { "ports": [ { "name": "prometheus", "port": 10254, "targetPort": "prometheus" }]}}'

kubectl -n ingress-nginx patch service ingress-nginx-controller-admission -p '{ "spec": { "ports": [ { "name": "prometheus", "port": 10254, "targetPort": "prometheus" }]}}'
```
Deployment:
```
kubectl -n ingress-nginx patch deploy ingress-nginx-controller -p='[{"op": "add", "path": "/spec/template/spec/containers/0/ports/-", "value": {"containerPort": 10254, "name": prometheus, "protocol": "TCP"}}]' --type json
```
- Create prometheus-additional.yaml with scrape additional like:
```
- job_name: 'nginx-controller'
  metrics_path: '/metrics'
  scrape_interval: 5m
  scrape_timeout: 1m
  static_configs:
  - targets:
    - ingress-nginx-controller.ingress-nginx.svc.cluster.local:10254
    - ingress-nginx-controller-admission.ingress-nginx.svc.cluster.local:10254
```
- Create a secret based on prometheus-additional.yaml file like:

(The value of key prometheus-additional.yaml is the file on base64)
```
echo "apiVersion: v1
data:
  prometheus-additional.yaml: LSBqb2JfbmFtZTogJ25naW54LWNvbnRyb2xsZXInCiAgbWV0cmljc19wYXRoOiAnL21ldHJpY3MnCiAgc2NyYXBlX2ludGVydmFsOiAzMHMKICBzY3JhcGVfdGltZW91dDogMjBzCiAgc3RhdGljX2NvbmZpZ3M6CiAgLSB0YXJnZXRzOgogICAgLSBpbmdyZXNzLW5naW54LWNvbnRyb2xsZXIuaW5ncmVzcy1uZ2lueC5zdmMuY2x1c3Rlci5sb2NhbDoxMDI1NAogICAgLSBpbmdyZXNzLW5naW54LWNvbnRyb2xsZXItYWRtaXNzaW9uLmluZ3Jlc3Mtbmdpbnguc3ZjLmNsdXN0ZXIubG9jYWw6MTAyNTQKLSBqb2JfbmFtZTogJ29wbnNlbnNlLW5hdGl2ZScKICBtZXRyaWNzX3BhdGg6ICcvbWV0cmljcycKICBzY3JhcGVfaW50ZXJ2YWw6IDMwcwogIHNjcmFwZV90aW1lb3V0OiAyMHMKICBzdGF0aWNfY29uZmlnczoKICAtIHRhcmdldHM6CiAgICAtIDEwLjExLjEyLjI1NDo5MTAwCi0gam9iX25hbWU6ICdwcm9tZXRoZXVzLXB2ZS1leHBvcnRlcicKICBtZXRyaWNzX3BhdGg6ICcvcHZlJwogIHNjcmFwZV9pbnRlcnZhbDogMzBzCiAgc2NyYXBlX3RpbWVvdXQ6IDIwcwogIHN0YXRpY19jb25maWdzOgogIC0gdGFyZ2V0czoKICAgIC0gcHJvbWV0aGV1cy1wdmUtZXhwb3J0ZXItc3ZjLnByb21ldGhldXMtcHZlLWV4cG9ydGVyLnN2Yy5jbHVzdGVyLmxvY2FsOjkyMjEKICBwYXJhbXM6CiAgICB0YXJnZXQ6IFsxMC4xMS4xMi4yNTNdCi0gam9iX25hbWU6ICdhZGd1YXJkLWV4cG9ydGVyJwogIHN0YXRpY19jb25maWdzOgogIC0gdGFyZ2V0czogWydhZGd1YXJkLWV4cG9ydGVyLXN2Yy5hZGd1YXJkLWV4cG9ydGVyLnN2Yy5jbHVzdGVyLmxvY2FsOjk2MTcnXQotIGpvYl9uYW1lOiAnamFlZ2VyLWt1YmVybmV0ZXMnCiAgbWV0cmljc19wYXRoOiAnL21ldHJpY3MnCiAgc3RhdGljX2NvbmZpZ3M6CiAgLSB0YXJnZXRzOiBbJ2phZWdlci1hbGwtaW4tb25lLmphZWdlci5zdmMuY2x1c3Rlci5sb2NhbDoxNDI2OSdd
kind: Secret
metadata:
  namespace: prometheus
  name: additional-scrape-configs" | kubectl apply -f -
```
- Configure prometheus runtime:
```
kubectl -n prometheus patch prometheus kube-prometheus-stack-prometheus -p '{"spec": {"additionalScrapeConfigs": {"name":"additional-scrape-configs","key":"prometheus-additional.yaml"}}}' --type merge
```

- Grafana dashboard to import is: 14314

## Monitoring kubescape risk score grafana
- add helm repository
```
helm repo add armo https://armosec.github.io/armo-helm/
helm repo update
```
- Install kubescape
```
helm upgrade --install armo  armo/armo-cluster-components -n armo-system --create-namespace --set clusterName=`kubectl config current-context` --set armoKubescape.serviceMonitor.enabled=true --set armoKubescape.submit=false --set armoKubescape.enableHostScan=false --set armoKubescape.downloadArtifacts=false
```

# Useful links
- [Prometheus getting started](https://prometheus.io/docs/prometheus/latest/getting_started/)
- [Best pratices](https://prometheus.io/docs/practices/naming/)
- [Kubescape grafana](https://hub.armosec.io/docs/prometheus-exporter)