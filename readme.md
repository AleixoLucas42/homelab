# ALEIXOHOME LAB

Hello everyone, this is my small homelab, I made the server from a computer that I got.

## Topology

[![topology](static/images/homelab.png)]()

## Server Specs
| KEY | VALUE |
|--------|:-----------:|
| Processor | Intel(R) Core(TM) i5-7600 |
| Brand | Custom |
| Storage 1 | 1TB |
| Storage 2 | 500GB |
| Storage 3 | 500GB |
| CPU | 4vcpu |
| RAM | 16GB |
| Net Iface | x2 Gbe |
| SYSTEM | proxmox |

<hr>

## Systems/apps running
- [OPNSENSE](virtual%20machines/opnsense/)
- [ADGUARD](virtual%20machines/fedora-server/swarm/adguard/)
- [AUDIOBOOKSHELF](virtual%20machines/fedora-server/swarm/audiobookshelf/)
- [CARDSGO](virtual%20machines/fedora-server/swarm/cardsgo/)
- [DISCORD WHATSAPP BOT](virtual%20machines/fedora-server/swarm/discord_whatsapp/)
- [DUPLICATI PROMETHEUS EXPORTER](virtual%20machines/fedora-server/swarm/duplicati-prom-exporter/)
- [GRAFANA](virtual%20machines/fedora-server/swarm/grafana/)
- [LOKI](virtual%20machines/fedora-server/swarm/loki/)
- [NGINX](virtual%20machines/fedora-server/swarm/nginx/)
- [PROXMOX PROMETHEUS EXPORTER](virtual%20machines/fedora-server/swarm/pve-exporter/)
- [SWARM PROMETHEUS STACK](virtual%20machines/fedora-server/swarm/swarm-prom-stack/)
- [HASHICORP VAULT](virtual%20machines/fedora-server/swarm/vault/)

<hr>

## Monitoring
- [Monitoring and alerts](Monitoring/)

## Backup
- Retention: Keep monthly 1
- Schedule: Monthly 1st 00:00
- Node: All
- Destination: /mnt/storage1tb/dump
- *there are a duplicati app sending the backups to google drive

## Duplicati config
- Retention: 1
- Schedule: Monthly 2'st 00:00
- Backup name: PROXMOX_ALEIXOHOME
- Destination: Google Drive Folder: DUPLICATI/PROXMOX
- Source: /mnt/storage1tb/dump

## Important things
- Configured bios password
- Configured chassis tampering alert
- Frontal USB disabled
- Back USB data blocker
- Server powered on fulltime and light energy use went up 9%
- I still need to buy a UPS

<hr>

## Userfull Links
- [Proxmox setup](https://www.proxmox.com/en/proxmox-ve/get-started)
- [Proxmox Docs](https://www.proxmox.com/en/downloads/category/documentation-pve)
- [Proxmox training](https://www.proxmox.com/en/training)