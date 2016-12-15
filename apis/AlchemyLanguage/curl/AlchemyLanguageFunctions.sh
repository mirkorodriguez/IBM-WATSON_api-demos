#!/bin/bash

API_KEY="905d6b2630433096e24124123450e4798d67913f"
URL="https://www.washingtonpost.com/opinions/trump-is-playing-a-risky-spy-game/2016/12/13/1c262bbc-c17c-11e6-9578-0054287507db_story.html"
FUNCTIONS="authors,concepts,entities,keywords,doc-sentiment,taxonomy,title"
# FUNCTIONS="authors,concepts,dates,doc-emotion,entities,feeds,keywords,pub-date,relations,typed-rels,doc-sentiment,taxonomy,title"

curl -X POST -d "outputMode=json" -d "extract=$FUNCTIONS" -d "sentiment=1" -d "maxRetrieve=1" -d "url=$URL" \
"https://gateway-a.watsonplatform.net/calls/url/URLGetCombinedData?apikey=$API_KEY"
