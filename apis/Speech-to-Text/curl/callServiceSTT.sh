#!/bin/bash

# {
#   "url": "https://stream.watsonplatform.net/speech-to-text/api",
#   "username": "5c488cfd-d8b6-4a03-b8e0-e263736d0ce5",
#   "password": "jxwLcSnSiVBy"
# }

curl -X POST -u "5c488cfd-d8b6-4a03-b8e0-e263736d0ce5":"jxwLcSnSiVBy" \
--header "Content-Type: audio/wav" \
--data-binary "@../audio/holaybienvenidos.wav" \
"https://stream.watsonplatform.net/speech-to-text/api/v1/recognize?continuous=true&model=es-ES_BroadbandModel"
