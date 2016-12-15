import sys
import operator
import requests
import json
import twitter

from watson_developer_cloud import NaturalLanguageClassifierV1 as NaturalLanguageClassifier

#The IBM Bluemix credentials
nlc_username = '569206c1-3641-4e54-9438-7fbda0f146a0'
nlc_password = 'rPYrOqVdpfBi'

natural_language_classifier = NaturalLanguageClassifier(
  username=nlc_username, password=nlc_password)

with open('../resources/weather_data_train.csv', 'rb') as training_data:
    classifier = natural_language_classifier.create(
    training_data=training_data,
    name='MySampleClassifierPython',
    language='en'
  )

#print
print(json.dumps(classifier, indent=2))
