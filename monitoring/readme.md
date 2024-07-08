# Monitoring and Alerts

[![topology](../static/images/images.gif)]()

## Critical operation
There are some operation that can not stop, otherwise it will stop operation and production wokloads.

| Tecnology | Workload |
|--------|:-----------:|
| Host System (Proxmox) | This is where all systems are running |
| opnSENSE Virtual Machine | Control all the internet traffic |
| ubuntu-minikube Virtual machine | Where's running the primary dns server and kubernetes |
| Nginx Security | Nginx is exposed to internet so must have some monitoring and alerting due security stuff |

## Postmortem documentations
All postmortem docs are stored on bookstack system, wich is running inside kubernetes.
- [Bookstack](../virtual%20machines/ubuntu-minikube/Kubernetes/bookstack/)
- In desaster case, the backup of bookstack is beeing done to google drive.

## Monitoring system
The core of monitoring is Grafana, wich is running inside kubernetes. All the systems who need to be monitored, should deliver data to Grafana somehow
- [Grafana](../virtual%20machines/ubuntu-minikube/Kubernetes/grafana/)
- Kubernetes logs is also in Grafana through Loki datasource.
- Some of datasource uses Prometheus in Grafana.
- There are a folder in Grafana for each system monitored. There are also a dashboard image reference in some markdown documentations.
- In desaster case, the backup of bookstack is beeing done to google drive.

## Jaeger
- [Jaeger](../virtual%20machines/ubuntu-minikube/Kubernetes/jaeger/)
- There are Jaeger configured in a minimal way to see requests on all nginx ingress

## Alerting
All alert should be deliver by Grafana, using Telegram as contact point.
| Alert | Threshold |
|--------|:-----------:|
| Adguard resolver latency | > 900ms |
| opnSENSE CPU | > 50% [5min] |
| opnSENSE RAM | > 80% [5min] |
| Nginx access outside Brazil| > 1 [Conn] |
| Nginx 4xx status | > 10 [5min] |
| Nginx SQL INJECTION | > 1 [5min] |
| Nginx success rate | < 80% [5min] |
| Proxmox CPU | > 80% [5min] |

## Grafana Dashboards
- opnSENSE
- Adguard
- Proxmox
- Nginx
- Loki Nginx
- Kubescape
- Kubernetes