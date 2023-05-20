!#/bin/bash

kubectl get ingress -A | awk -F' ' '{print $2" "$1}' | grep -v "NAME" | while read line
do
    resource=$(echo $line | cut -d" " -f1)
    ns=$(echo $line | cut -d" " -f2)
    #kubectl annotate -n ${ns} ingress/${resource} "nginx.ingress.kubernetes.io/limit-connections=5"
    kubectl annotate -n ${ns} ingress/${resource} nginx.ingress.kubernetes.io/limit-connections-
done