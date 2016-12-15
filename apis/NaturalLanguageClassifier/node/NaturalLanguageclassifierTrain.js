'use strict';

var NaturalLanguageClassifierV1 = require('watson-developer-cloud/natural-language-classifier/v1');
var fs     = require('fs');

var natural_language_classifier = new NaturalLanguageClassifierV1({
  username: '569206c1-3641-4e54-9438-7fbda0f146a0',
  password: 'rPYrOqVdpfBi',
  version: 'v1'
});

// Creating a classifier
var params = {
  language: 'en',
  name: 'MyTutorialClassifierNode',
  training_data: fs.createReadStream('../resources/weather_data_train.csv')
};

natural_language_classifier.create(params, function(err, response) {
  if (err)
    console.log(err);
  else
    // Print classifier_id from the response
    console.log(JSON.stringify(response, null, 2));
});
