#!/bin/bash

# {
#   "url": "https://gateway.watsonplatform.net/natural-language-understanding/api",
#   "username": "e0e84e87-221a-4513-8f82-6fe82d09a2e4",
#   "password": "CH5tQZKEqyXv"
# }

curl -X POST \
-H "Content-Type: application/json" \
-u "e0e84e87-221a-4513-8f82-6fe82d09a2e4":"CH5tQZKEqyXv" \
-d @data-url.json \
"https://gateway.watsonplatform.net/natural-language-understanding/api/v1/analyze?version=2017-02-27"
