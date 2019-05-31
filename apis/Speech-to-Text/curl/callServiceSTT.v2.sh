#!/bin/bash

curl -X POST -u "apikey:OVlrlq24KUcuX0avsxwtSbApuMZ-u-ZZoykYHPpyGbEB" \
--header "Content-Type: audio/wav" \
--data-binary @../audio/holaybienvenidos.wav \
"https://stream.watsonplatform.net/speech-to-text/api/v1/recognize?model=es-ES_NarrowbandModel"
