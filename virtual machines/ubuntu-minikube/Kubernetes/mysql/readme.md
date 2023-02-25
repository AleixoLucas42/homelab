# Mysql
MySQL is a database management system that uses the SQL language as an interface.

## Setup
```
kubectl create ns mysql
kubectl create -f .
```

## Backup
There are a cronjob backup who send the dump to [ubuntu-minikube](../../../ubuntu-minikube/) then send the backup to google drive via Duplicati

# Usefull links
- [Mysql Site](https://www.mysql.com/)
- [Download](https://dev.mysql.com/downloads/mysql/)
- [Docs/guides](https://dev.mysql.com/doc/)