#!/bin/bash

# {
#   "url": "https://gateway.watsonplatform.net/natural-language-understanding/api",
#   "username": "e0e84e87-221a-4513-8f82-6fe82d09a2e4",
#   "password": "CH5tQZKEqyXv"
# }

curl -X POST \
-H "Content-Type: application/json" \
-u "53c3ba41-0e28-4fc8-b308-555ac62a06ca":"pYqMSaIYQI2F" \
-d @data-text.json \
"https://gateway.watsonplatform.net/natural-language-understanding/api/v1/analyze?version=2017-02-27"
