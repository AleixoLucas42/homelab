# MINECRAFT
Just a minecraft server to play with my friends.

## Deploy Stack
> docker stack deploy -c docker-compose.yaml minecraft-server

## Run command on container
> docker exec -i $(docker container ls | grep minecraft | awk '{print $1}') rcon-cli

## Send message do server
> \/say \<message>

## Remove ground items
> /kill @e[type=item]

## Minecraft Server
> aleixohome.ddns.net:25565

## Automations
#### Clean ground items
- There is a [Jenkins pipeline](Jenkinsfile.ground-items) running every hour to clean ground items.

#### Backup
- There is a **duplicati** backup running every 3 hours, sending backup to TrueNAS. The restore is manual through Duplicati web interface. **You should restore permissions when you are restoring backup or else server container won't have permissions to read/write files restored.**

# REF
- [Github](https://github.com/itzg/docker-minecraft-server)