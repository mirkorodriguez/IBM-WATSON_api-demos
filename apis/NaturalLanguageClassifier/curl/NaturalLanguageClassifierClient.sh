#!/bin/bash

# classifier_id=d67c64x140-nlc-257

TEXT="How hot will it be today?"

curl -G -u "569206c1-3641-4e54-9438-7fbda0f146a0":"rPYrOqVdpfBi" \
"https://gateway.watsonplatform.net/natural-language-classifier/api/v1/classifiers/d67c64x140-nlc-257/classify" \
--data-urlencode "text=$TEXT"
