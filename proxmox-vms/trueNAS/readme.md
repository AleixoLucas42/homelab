## [TRUENAS](https://www.truenas.com/docs/)
TrueNAS is the branding for a family of network-attached storage (NAS) products produced by iXsystems. They include both free and open-source and commercial offerings, based on the OpenZFS file system and either FreeBSD or Linux. It is licensed under the terms of the BSD License and runs on both commodity x86-64 hardware and turnkey appliances offered by iXsystems. 

[![grafana](../../static/images/)]()


## Server Specs
| KEY | VALUE |
|--------|:-----------:|
| CPU | 2vcpu |
| RAM | 3GB |
| SCSI DISK | 32GB |
| SATA CONTROLLER | HD 500GB |
| IP | 10.11.12.247 |
| NETWORK | net0, vmbr1 bridge |
| SYSTEM | TrueNAS |
| AUTH | LDAP (zentyal) |

## File Share
- There are an smb share (500gb) that allow only an specific group of AD to access.
- The file share disk are idependent from proxmox, trueNAS have the sata controller of the host to manipulate this specific HDD.

## Virtual Machine Backup
- VM Backup is beeing done with proxmox backup.
  - There's a duplicati on proxmox to backup vms to Google Drive