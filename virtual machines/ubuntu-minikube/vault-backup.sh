#!/bin/bash

export $(cat /home/aleixohome/.env | xargs)
/home/aleixohome/.local/bin/vault-dump -o vault > vault-backupfile.sh