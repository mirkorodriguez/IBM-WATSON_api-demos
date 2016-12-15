'use strict';

var NaturalLanguageClassifierV1 = require('watson-developer-cloud/natural-language-classifier/v1');
var fs     = require('fs');

var natural_language_classifier = new NaturalLanguageClassifierV1({
  username: '569206c1-3641-4e54-9438-7fbda0f146a0',
  password: 'rPYrOqVdpfBi',
  version: 'v1'
});

var classifierId = 'e4c202x150-nlc-10';
var sentenceToClassify = 'How hot will it be today?';

//Get the classification of a sentence after evaluate with API
natural_language_classifier.classify({
  text: sentenceToClassify ,
  classifier_id: classifierId },
  function(err, response) {
    if (err)
      console.log('error:', err);
    else
      console.log(JSON.stringify(response, null, 2));
});
