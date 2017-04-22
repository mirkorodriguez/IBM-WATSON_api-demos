#!/bin/bash

USERNAME=$1
PASSWORD=$2

TEXT=$3

# curl -X POST -u "fa51a9fd-2fd9-4bb3-8f96-ed63678e9338":"fBEgtEydZCiK" \
curl -X POST -u "$USERNAME":"$PASSWORD" \
--header "Content-Type: application/json" \
--header "Accept: audio/wav" \
--data "{\"text\":\"$TEXT\"}" \
--output hola_spanish_enrique9.wav \
"https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?voice=es-ES_EnriqueVoice"
