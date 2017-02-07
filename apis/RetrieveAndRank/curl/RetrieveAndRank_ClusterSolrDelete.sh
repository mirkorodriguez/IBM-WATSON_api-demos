#!/bin/bash

END_POINT="https://gateway.watsonplatform.net/retrieve-and-rank/api"
SOLR_CLUSTER_ID="sc3245e72f_1784_488d_bacf_463da985a156"

curl -X DELETE -u "e13e0935-6a1e-49e8-9264-44e1ca64dc4d:d18PaR8uv14D" \
"$END_POINT/v1/solr_clusters/$SOLR_CLUSTER_ID"
