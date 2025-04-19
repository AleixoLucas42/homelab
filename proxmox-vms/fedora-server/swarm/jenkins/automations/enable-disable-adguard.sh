#!/bin/bash

echo "creds $ADGUARD_USER:$ADGUARD_PASSWORD"
status=$(curl -sk --location --request GET "https://adguard.aleixohome.lan/control/status" \
    -u "$ADGUARD_USER:$ADGUARD_PASSWORD" \
    --header "Accept: application/json" \
    --header "Content-Type: application/json" \
    | grep -o '"protection_enabled":[^,]*' | cut -d: -f2 | tr -d ' ')

echo "Proteção está atualmente: $status"

if [ "$status" == "true" ]; then
    new_status=false
else
    new_status=true
fi

# Envia o novo status usando -u para autenticação
curl -sk --location --request POST "https://adguard.aleixohome.lan/control/protection" \
    -u "$ADGUARD_USER:$ADGUARD_PASSWORD" \
    --header "Accept: application/json" \
    --header "Content-Type: application/json" \
    --data "{\"enabled\":$new_status}"

echo -e "\\nNovo status enviado: enabled = $new_status"