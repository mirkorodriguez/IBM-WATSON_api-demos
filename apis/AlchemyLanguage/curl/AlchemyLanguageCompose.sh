#!/bin/bash

API_KEY="905d6b2630433096e24124123450e4798d67913f"
URL="https://www.washingtonpost.com/opinions/trump-is-playing-a-risky-spy-game/2016/12/13/1c262bbc-c17c-11e6-9578-0054287507db_story.html"
SERVICE_URL="https://gateway-a.watsonplatform.net/calls/url"
#http://access.alchemyapi.com/calls/info/GetAPIKeyInfo?apikey=$API_KEY
TIMER="sleep 5s"


# URLGetAuthors
# Get author names from a webapage
END_POINT="URLGetAuthors"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetRankedConcepts
# Extract concepts from a web page
END_POINT="URLGetRankedConcepts"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLExtractDates
# Extract dates from a web page
END_POINT="URLExtractDates"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetEmotion
# Detect emotions implied in the text on a webpage.
END_POINT="URLGetEmotion"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetRankedNamedEntities
END_POINT="URLGetRankedNamedEntities"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetFeedLinks
END_POINT="URLGetFeedLinks"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetRankedKeywords
END_POINT="URLGetRankedKeywords"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetLanguage
END_POINT="URLGetLanguage"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetMicroformatData
END_POINT="URLGetMicroformatData"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetPubDate
END_POINT="URLGetPubDate"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetRelations
END_POINT="URLGetRelations"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetTypedRelations
END_POINT="URLGetTypedRelations"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetTextSentiment
END_POINT="URLGetTextSentiment"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetTargetedSentiment
END_POINT="URLGetTargetedSentiment"
# Targeted Emotion searches your content for up to 20 targets, and uses context to analyze emotions associated with each phrase.
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "targets=Clinton|Trump" -d "url=$URL" "$SERVICE_URL/URLGetTargetedEmotion?apikey=%$API_KEY%"


# URLGetRankedTaxonomy
END_POINT="URLGetRankedTaxonomy"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetText
END_POINT="URLGetText"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetRawText
END_POINT="URLGetRawText"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"


# URLGetTitle
END_POINT="URLGetTitle"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "url=$URL" "$SERVICE_URL/$END_POINT?apikey=%$API_KEY%"

# URLGetTitle
END_POINT="/info/models"
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X GET -d "outputMode=json" "https://gateway-a.watsonplatform.net/calls/$END_POINT?apikey=%API_KEY%"


# URLGetTargetedEmotion
END_POINT="URLGetTargetedEmotion"
# Targeted Emotion searches your content for up to 20 targets, and uses context to analyze emotions associated with each phrase.
echo -e "\n$END_POINT ..."
`$TIMER`
curl -X POST -d "outputMode=json" -d "targets=Clinton|Trump" -d "url=$URL" "$SERVICE_URL/URLGetTargetedEmotion?apikey=%$API_KEY%"
