#!/bin/bash

# IAM Authentication
#curl -X POST -u "apikey:{apikey}" \
curl -X POST -u "apikey:rDHqx0Qk99MzXApbWYrPa5KSBxCdCxjvxzYmU3uVMJSj" \
--header "Content-Type: text/plain;charset=utf-8" \
--header "Accept: application/json" \
--header "Content-Language:es" \
--header "Accept-Language:es" \
--data-binary @../resources/sample.es.txt \
"https://gateway.watsonplatform.net/personality-insights/api/v3/profile?version=2017-10-13"
