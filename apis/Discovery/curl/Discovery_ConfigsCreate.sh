#!/bin/bash

END_POINT="https://gateway.watsonplatform.net/discovery/api"
ENVIRONMENT_ID="fa4d434e-43ef-49c1-8e71-5fef01620cb2"

curl -X POST \
-u "fda6d338-8bc0-4c5f-ab97-7fb236c9ead5:jB2155W0JJ4d" \
-H "Content-Type: application/json" \
--data-ascii @../resources/configurations.json \
"$END_POINT/v1/environments/$ENVIRONMENT_ID/configurations?version=2016-12-01"
