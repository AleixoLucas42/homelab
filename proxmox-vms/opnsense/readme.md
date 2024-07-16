# OPNSENSE

OPNSense is a BSD-licensed firewall based on FreeBSD and developed by Decisio, a Dutch company that builds hardware and sells embedded OPNsense packages. It is a fork of pfSense, and this one is also a fork of m0n0wall, and all of these are based on FreeBSD. It was released in January 2015.

[![grafana](../../static/images/opnsense-monitoring.png)]()

## General Info:
| KEY   |      VALUE      |
|----------|:-------------:|
| CPU | 2vcpu |
| RAM |    2GB   |
| IP | 10.11.12.254 |
| SCSI DISK | 32GB |
| Net Iface | x2 vtIO GBe |
| Auth | LDAP (zentyal) |
| WEB PORT | 8443 |

## Running
- ZeroTier
- DNS Unbound
- DD CLINET
- Suricata
- Nginx (cardsgo WAF)
- CrowdSec

## Virtual Machine Backup
- VM Backup is beeing done with proxmox backup.
  - There's a duplicati on proxmox to backup vms to Google Drive
## opnSENSE Backup
- There are configured opnSENSE backup to send configuration to Google Drive
- Backup count: 5


## CrowdSec integration with NAXSI error logs on  NGINX
#### /usr/local/etc/crowdsec/parsers/s01-parse/opnsense_naxsi_logs.yaml
```yaml
name: aleixohome/opnsense_naxsi_logs
description: "Parse NAXSI error logs on OPNSense firewall"
filter: "evt.Parsed.program == 'nginx'"
onsuccess: next_stage
nodes:
 - grok:
     pattern: '%{DATESTAMP:timestamp} \[error] %{NUMBER}\#%{NUMBER}: \*%{NUMBER} NAXSI_FMT: ip=%{IPORHOST}&server=%{IPORHOST:serverip}&uri=%{URIPATHPARAM:server_uri}&config=block&rid=%{DATA:rid}&cscore0=%{DATA:cscore0}&score0=%{NUMBER:score}&zone0=%{DATA:zone0}&id0=%{NUMBER:rule_id}&var_name0=%{DATA:var_name0}, client: %{IPORHOST:source_ip}, server: %{IPORHOST:server_hostname}, request: "%{DATA:request}", host: "%{DATA:host}"'
     apply_on: message
statics:
 - meta: log_type
   value: waf_attack_event
 - target: evt.StrTime
   expression: evt.Parsed.timestamp
 - meta: source_ip
   expression: evt.Parsed.source_ip
 - meta: http_request
   expression: evt.Parsed.request
 - meta: service
   value: nginx
```

#### /usr/local/etc/crowdsec/scenarios/detect_naxsi.yaml
```
type: trigger
name: aleixohome/opnsense_naxsi_waf_event
description: "Detects if NAXSI has triggered a security event in accordance with its WAF policies"
filter: evt.Meta.log_type == 'waf_attack_event'
groupby: evt.Meta.source_ip
labels:
  service: nginx
  type: waf_security_event
  remediation: true
scope:
  type: Ip
  expression: evt.Meta.source_ip
```

#### /usr/local/etc/crowdsec/profile.yaml
```
name: default_ip_remediation
debug: true
filters:
 - Alert.Remediation == true && Alert.GetScope() == "Ip"
decisions:
 - type: ban
   duration: 5m #duration of the ban set to 5 min, default is 4 hours, changed this for lab purposes.
on_success: break
```