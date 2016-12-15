import json
from os.path import join, dirname
from watson_developer_cloud import AlchemyLanguageV1

API_KEY = '905d6b2630433096e24124123450e4798d67913f'

alchemy_language = AlchemyLanguageV1(api_key=API_KEY)

url = 'https://developer.ibm.com/watson/blog/2015/11/03/price-reduction-for-watson-personality-insights/'

combined_operations = ['page-image', 'entity', 'keyword', 'title', 'author', 'taxonomy', 'concept', 'doc-emotion']
print(json.dumps(alchemy_language.combined(url=url, extract=combined_operations), indent=2))
