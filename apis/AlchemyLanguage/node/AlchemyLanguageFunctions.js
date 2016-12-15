'use strict';

var watson = require('watson-developer-cloud');
var alchemy_language = watson.alchemy_language({
  api_key: '905d6b2630433096e24124123450e4798d67913f'
})

var parameters = {
  extract: 'authors,concepts,entities,keywords,doc-sentiment,taxonomy,title',
  sentiment: 1,
  maxRetrieve: 1,
  url: 'https://www.washingtonpost.com/opinions/trump-is-playing-a-risky-spy-game/2016/12/13/1c262bbc-c17c-11e6-9578-0054287507db_story.html'
};

alchemy_language.combined(parameters, function (err, response) {
  if (err)
    console.log('error:', err);
  else
    console.log(JSON.stringify(response, null, 2));
});
