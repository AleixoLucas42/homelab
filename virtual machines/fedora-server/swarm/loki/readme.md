# [Loki docker swarm](https://github.com/swarmstack/loki)

> docker plugin install grafana/loki-docker-driver:latest --alias loki --grant-all-permissions

```json
# /etc/docker/daemon.json
{
  "debug" : false,
  "log-driver": "loki",
  "log-opts": {
      "loki-url": "http://127.0.0.1:3100/loki/api/v1/push"
  }
}
```

> docker node ls

> docker node update --availability drain yxfnb84xz3yp9km865rbrt948 

> systemctl restart docker

> docker node update --availability active yxfnb84xz3yp9km865rbrt948

> git clone https://github.com/swarmstack/loki.git

> docker stack deploy -c docker-compose-swarmstack.yml loki