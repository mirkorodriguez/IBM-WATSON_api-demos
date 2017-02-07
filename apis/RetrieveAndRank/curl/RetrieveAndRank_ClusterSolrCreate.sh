#!/bin/bash

END_POINT="https://gateway.watsonplatform.net/retrieve-and-rank/api"

curl -H "Content-Type: application/json" -X POST -u "e13e0935-6a1e-49e8-9264-44e1ca64dc4d:d18PaR8uv14D" \
-d "{\"cluster_size\":\"1\",\"cluster_name\":\"MirkoTestCluster\"}" \
"$END_POINT/v1/solr_clusters"
