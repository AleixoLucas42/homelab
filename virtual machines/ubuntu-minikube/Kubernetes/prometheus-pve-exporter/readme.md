# Prometheus pve exporter
This is an exporter that exposes information gathered from Proxmox VE node for use by the Prometheus monitoring system.

## Setup
```
kubectl create ns prometheus-pve-exporter
kubectl apply -f .
```

## Scrap config example
```
- job_name: 'prometheus-pve-exporter'
  metrics_path: '/pve'
  scrape_interval: 30s
  scrape_timeout: 20s
  static_configs:
  - targets:
    - prometheus-pve-exporter-svc.prometheus-pve-exporter.svc.cluster.local:9221
  params:
    target: [10.11.12.253]
```

## Access metrics
- http://{your_ingress}/pve?target={your_proxmox_ip}

## Usefull links
- https://github.com/prometheus-pve/prometheus-pve-exporter
- https://grafana.com/grafana/dashboards/10347-proxmox-via-prometheus/