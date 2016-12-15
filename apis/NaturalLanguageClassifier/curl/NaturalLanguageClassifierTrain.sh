#!/bin/bash

curl -i -u "569206c1-3641-4e54-9438-7fbda0f146a0":"rPYrOqVdpfBi" \
-F training_data=@../resources/weather_data_train.csv \
-F training_metadata="{\"language\":\"en\",\"name\":\"TutorialClassifier\"}" \
"https://gateway.watsonplatform.net/natural-language-classifier/api/v1/classifiers"
