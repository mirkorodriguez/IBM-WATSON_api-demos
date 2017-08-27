#!/bin/bash

# curl -X POST -u "5c488cfd-d8b6-4a03-b8e0-e263736d0ce5":"jxwLcSnSiVBy" \
# --header "Content-Type: audio/wav" \
# --data-binary "@../audio/holaybienvenidos.wav" \
# "https://stream.watsonplatform.net/speech-to-text/api/v1/recognize?continuous=true&model=es-ES_BroadbandModel"

# curl -X POST \
# -u "a90f5a6c-e559-4c57-8924-51e6b3eb5759":"keqzvod76NjP" \
# —-header "Content-Type:application/json" \
# --data "{\"input\": {\"text\": \"Hola\"}, \"context\": {\"conversation_id\": \"1b7b67c0-90ed-45dc-8508-9488bc483d5b\", \"system\": {\"dialog_stack\":[{\"dialog_node\":\"root\"}], \"dialog_turn_counter\": 1, \"dialog_request_counter\": 1}}}" \
# "https://gateway.watsonplatform.net/conversation/api/v1/workspaces/f255e40a-0ba6-4480-951d-0d941e92e317/message?version=2017-05-26"

curl -X POST \
-u "55597953-f02f-4914-99cf-06571df6beb1":"dtOIOt0lTRzD" \
--header "Content-Type:application/json" \
--data "{\"input\": {\"text\": \"Hola\"}}" \
"https://gateway.watsonplatform.net/conversation/api/v1/workspaces/f9cc190a-5f01-47e4-a8d4-38a3cf4211f7/message?version=2017-05-26"
