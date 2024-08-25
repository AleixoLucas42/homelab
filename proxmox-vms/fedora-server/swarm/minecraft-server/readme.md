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

# REF
- [Github](https://github.com/itzg/docker-minecraft-server)