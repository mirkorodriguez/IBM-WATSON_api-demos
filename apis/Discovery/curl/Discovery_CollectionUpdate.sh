#!/bin/bash

END_POINT="https://gateway.watsonplatform.net/discovery/api"
ENVIRONMENT_ID="fa4d434e-43ef-49c1-8e71-5fef01620cb2"
CONFIGURATION_ID="3cb25606-86d1-4727-9c48-fd97f6f3bd9f"
COLLECTION_ID="f60c4945-b4fc-4f6e-bdc0-3eb50ae4f4c3"

curl -X PUT \
-u "fda6d338-8bc0-4c5f-ab97-7fb236c9ead5:jB2155W0JJ4d" \
-H "Content-Type: application/json" \
-d '{
  "name": "test_collection",
  "description": "My test collection updated",
  "configuration_id": "'$CONFIGURATION_ID'"
}' \
"$END_POINT/v1/environments/$ENVIRONMENT_ID/collections/$COLLECTION_ID?version=2016-12-01"
