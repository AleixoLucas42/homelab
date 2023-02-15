# ALEIXOHOME LAB

Hello everyone, this is my small homelab, I decide to start with a very cheap hardware, actually is a 2008 PC; but for sure it will grow up if everything going okay.

## Topology

[![topology](static/images/homelab.png)]()

<hr>

## Server Specs
| KEY | VALUE |
|--------|:-----------:|
| Processor | Intel core2quad |
| Brand | HP |
| Storage 1 | 1TB |
| Storage 2 | 500GB |
| CPU | 4vcpu |
| RAM | 8GB |
| Net Iface | x2 Gbe |
| SYSTEM | proxmox |

<hr>

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
- Cypher: None
- Destination: Drive:DUPLICATI/PROXMOX
- Source: /mnt/storage1tb/dump

## Important things
- Configured bios password
- Configured chassis tampering alert
- Frontal USB disabled
- Back USB data blocker

<hr>

## Userfull Links
- [Proxmox setup](https://www.proxmox.com/en/proxmox-ve/get-started)
- [Proxmox Docs](https://www.proxmox.com/en/downloads/category/documentation-pve)
- [Proxmox training](https://www.proxmox.com/en/training)