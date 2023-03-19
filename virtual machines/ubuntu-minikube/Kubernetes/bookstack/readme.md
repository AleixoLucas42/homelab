# Bookstack
BookStack is free and open source wiki software built on a simple, self-hosted, easy-to-use platform. Based on Laravel, a PHP framework, BookStack is released under the MIT license. It uses ideas from books to organize pages and store information. (I know use database as container isn't good pratice, but it was my only option for now).

## Setup
```
kubectl create ns bookstack
kubectl apply -f mysql/
kubectl apply -f bookstack/
kubectl apply -f bookstack-in.yaml
```

## Initial credentials
- admin@admin.com
- password

## Backup
There is a backup running inside a kubernetes cronjob on mysql namespace. The backup is up to google drive

## Important
- You need to have a mysql to use bookstack
- Make sure that the user and password for mysq is the same to mysql and bookstack secret
- I had to kubectl exec on mysql pod and create database "bookstack"
- Fill the APP_URL and DB_HOST from env vars on deployment