#!/bin/bash

END_POINT="https://gateway.watsonplatform.net/discovery/api"
ENVIRONMENT_ID="fa4d434e-43ef-49c1-8e71-5fef01620cb2"
CONFIGURATION_ID="3cb25606-86d1-4727-9c48-fd97f6f3bd9f"
COLLECTION_ID="f60c4945-b4fc-4f6e-bdc0-3eb50ae4f4c3"
QUERY="relations.action.lemmatized:acquire&count=15&filter=entities.text:IBM&return=text"

curl \
-u "fda6d338-8bc0-4c5f-ab97-7fb236c9ead5:jB2155W0JJ4d" \
"$END_POINT/v1/environments/$ENVIRONMENT_ID/collections/$COLLECTION_ID/query?version=2016-11-07&query=$QUE"
