#!/bin/bash

#https://www.ibm.com/watson/developercloud/doc/discovery/getting-started.shtml#gettingstarted

END_POINT="https://gateway.watsonplatform.net/discovery/api"

curl -X POST \
-u "fda6d338-8bc0-4c5f-ab97-7fb236c9ead5:jB2155W0JJ4d" \
-H "Content-Type: application/json" \
-d '{
     "name": "mirko_environment",
     "description": "Mirko environment",
     "size": 0
   }' "$END_POINT/v1/environments?version=2016-12-15"
