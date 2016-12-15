#!/bin/bash

# curl -X POST -u "{username}:{password}" \
curl -X POST -u "842a005c-8baa-4e4e-a2f2-a915e89fd185:zLSpcxCsfAqk" \
--header "Content-Type: text/plain" \
--header "Content-Language=en" \
--header "Accept-Language:es" \
--data-binary @../resources/sample.en.txt \
"https://gateway.watsonplatform.net/personality-insights/api/v3/profile?version=2016-10-20&raw_scores=false" | python -m json.tool
