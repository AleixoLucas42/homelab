# Duplicati
Duplicati is a backup client that securely stores encrypted, incremental, compressed remote backups of local files on cloud storage services and remote file servers

## Setup
- Install requirements and duplicati

```
sudo apt install apt-transport-https nano git-core software-properties-common dirmngr -y
# Download Debian .deb file from https://www.duplicati.com/download
wget https://updates.duplicati.com/beta/duplicati_[...]_all.deb
sudo apt install ./duplicati_[...]_all.deb -y
```
- sudo nano /etc/systemd/system/duplicati.service

Should look like this:
```
[Unit]
Description=Duplicati web-server
After=network.target

[Service]
Nice=19
IOSchedulingClass=idle
EnvironmentFile=-/etc/default/duplicati
ExecStart=/usr/bin/duplicati-server $DAEMON_OPTS
Restart=always

[Install]
WantedBy=multi-user.target
```
Edit the file /etc/default/duplicati and add DAEMON_OPTS options to your liking:

- sudo nano /etc/default/duplicati
```
# Defaults for duplicati initscript
# sourced by /etc/init.d/duplicati
# installed at /etc/default/duplicati by the maintainer scripts
#
# This is a POSIX shell fragment
#

# Additional options that are passed to the Daemon.
DAEMON_OPTS="--webservice-interface=any --webservice-port=8200 --portable-mode"
```
- Enable, start and check running status of the duplicati service:
```
sudo systemctl enable duplicati.service
sudo systemctl daemon-reload
sudo systemctl start duplicati.service  
sudo systemctl status duplicati.service
```
## Duplicati config
- Retention: 14 days
- Schedule: Everyday 00:00
- Backup name: VAULT_ALEIXOHOME
- Cypher: None
- Destination: Drive:DUPLICATI/VAULT
- Source: /home/aleixohome/

## Usefull links
- [Download duplicati](https://www.duplicati.com/download)
- [Duplicati site](https://www.duplicati.com/)
- [Releases](https://github.com/duplicati/duplicati/releases)
- [Docs](https://duplicati.readthedocs.io/en/latest/)