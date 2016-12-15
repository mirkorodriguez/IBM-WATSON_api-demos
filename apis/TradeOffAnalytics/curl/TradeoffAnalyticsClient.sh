#!/bin/bash

USER="cc35d4e3-a15b-4052-958d-fe0e4f40f9ca"
PASS="xX62zUw36Gd4"
SERVICE_URL="https://gateway.watsonplatform.net/tradeoff-analytics/api"
GENERATE_VISUAL="false"

curl -X POST -u "$USER:$PASS" \
--header "Content-Type: application/json" \
--data @../resources/problem.json \
"$SERVICE_URL/v1/dilemmas?generate_visualization=$GENERATE_VISUAL"
