#!/bin/python
import requests, time, os


################CHANGE HERE####################
base_url="" # Vault URL
vault_token="" # Vault Token
black_path_list=["cubbyhole/", "sys/", "identity/"]
backup_file_name="name-backup.txt"
################CHANGE HERE####################

# Common var
payload = {}
headers = {
'Authorization': f"Bearer {vault_token}"
}

def send_get(api):
    return requests.request("GET", api, headers=headers, data=payload)

def save_file_backup(path, secret):
    path=path.replace("metadata", "").replace("//", "/")
    print(f"Fazendo backup do item {path}")
    resume_bkp = open(backup_file_name, 'r').read()
    with open(backup_file_name, 'w') as bkp_file:
        bkp_file.write(f'{resume_bkp}{path} = {secret} \n\n')

def get_secret_version(value):
    time.sleep(2)
    api = f"{base_url}/v1/{value}"
    response = send_get(api)
    get_secret_data(value, response.json()['data']['current_version'])

def get_secret_data(value, version):
    time.sleep(2)
    new_value = value.replace("meta", "")
    api = f"{base_url}/v1/{new_value}?version={version}"
    response = send_get(api)
    save_file_backup(value, response.json()['data']['data'])

def get_root_paths():
    root_paths=[]
    api = f"{base_url}/v1/sys/internal/ui/mounts"
    response = send_get(api)
    data = response.json()['data']['secret']
    for key in data.keys():
        if key not in black_path_list:
            root_paths.append(key)
    return root_paths

def is_dir(value):
    return "/" in value[len(value) - 1]

def get_sub_folder(value, is_root):
    time.sleep(2)
    if is_root:
        value=value+"metadata"
    api = f"{base_url}/v1/{value}?list=true"
    response = send_get(api)
    data = response.json()['data']['keys']
    for item in data:
        if is_dir(item):
            get_sub_folder(f"{value}/{item}", False)
        else:
            get_secret_version(f"{value}/{item}")

for path in get_root_paths():
    print (f"Looking for secret in {path}")
    get_sub_folder(path, True)