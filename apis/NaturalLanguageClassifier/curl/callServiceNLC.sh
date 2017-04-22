# {
#   "url": "https://gateway.watsonplatform.net/natural-language-classifier/api",
#   "username": "a9034323-f4d9-44ab-9825-a6645b3b098c",
#   "password": "e2gOzu4S3LC5"
# }

# Created Apr 22, 2017 3:57:32 PM
# Classifier ID: 90e7b7x198-nlc-46442

# SPAM "Obtenga plata ahora mismo"
curl -G -u "a9034323-f4d9-44ab-9825-a6645b3b098c":"e2gOzu4S3LC5" \
"https://gateway.watsonplatform.net/natural-language-classifier/api/v1/classifiers/90e7b7x198-nlc-46442/classify?text=Obtenga%20plata%20ahora%20mismo"


# CORREO (NO SPAM) "Presentación final BCP"
curl -X POST -u "a9034323-f4d9-44ab-9825-a6645b3b098c":"e2gOzu4S3LC5" \
-H "Content-Type:application/json" \
-d "{\"text\":\"Presentación final BCP\"}" \
"https://gateway.watsonplatform.net/natural-language-classifier/api/v1/classifiers/90e7b7x198-nlc-46442/classify"
