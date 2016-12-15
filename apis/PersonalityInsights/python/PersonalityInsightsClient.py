import sys
import operator
import requests
import json
import twitter

from watson_developer_cloud import PersonalityInsightsV3 as PersonalityInsights

#The Twitter API credentials
twitter_consumer_key ='0caDuYhS4qCuFrj2nHlJhObDB'
twitter_consumer_secret = 'sBwB1Cao575cpSjA68IA5sHfBw9f9nM68HJ68AwFjxBC0s86DZ'
twitter_access_token = '801184453540331520-ypyvOBU5S0qNotktmbKJsc0OFBem1VP'
twitter_access_secret = 'J9IrvQPM7cCgbdTBja52ZMZ5eDBJKxvyUxyiWnV0OKjAA'

#Invoking the Twitter API
twitter_api = twitter.Api(consumer_key=twitter_consumer_key,
                          consumer_secret=twitter_consumer_secret,
                          access_token_key=twitter_access_token,
                          access_token_secret=twitter_access_secret)

#Elon musk twitter
#handle = "@elonmusk"
handle = str(sys.argv[1])
print ("User to analyze: ", handle)

statuses = twitter_api.GetUserTimeline(screen_name=handle, count=100, include_rts=False)

# This var will store all twits from user
twitter_text = ""

for status in statuses:
    if (status.lang =='en'): #English tweets
        tmp_text = str((status.text.encode('utf-8')))
        #print (tmp_text)
        twitter_text += tmp_text

# Final string
# print (twitter_text)

#The IBM Bluemix credentials for Personality Insights!
pi_username = '842a005c-8baa-4e4e-a2f2-a915e89fd185'
pi_password = 'zLSpcxCsfAqk'

personality_insights = PersonalityInsights(username=pi_username, password=pi_password)

# Load twitter as text to Personality Insights engine
result_as_json = personality_insights.profile(text=twitter_text,content_language='en',accept_language='es')

#print (result_as_json)
print(json.dumps(result_as_json, indent=2))
