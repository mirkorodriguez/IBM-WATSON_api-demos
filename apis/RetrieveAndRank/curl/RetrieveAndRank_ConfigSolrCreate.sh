#!/bin/bash

END_POINT="https://gateway.watsonplatform.net/retrieve-and-rank/api"
SOLR_CLUSTER_ID="sc35d55ed5_628a_47a7_a618_fb45e16da701"
CONFIG_NAME="mirko_config"

curl -X POST -H "Content-Type: application/zip" -u "e13e0935-6a1e-49e8-9264-44e1ca64dc4d:d18PaR8uv14D" \
"$END_POINT/v1/solr_clusters/$SOLR_CLUSTER_ID/config/$CONFIG_NAME" \
--data-binary @../resources/example_solr_config.zip
