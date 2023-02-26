#!/bin/bash

export $(cat /home/aleixohome/.env | xargs)
python3 vault-backup.py