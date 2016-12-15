'use strict';

var NaturalLanguageClassifierV1 = require('watson-developer-cloud/natural-language-classifier/v1');
var fs     = require('fs');

var natural_language_classifier = new NaturalLanguageClassifierV1({
  username: '569206c1-3641-4e54-9438-7fbda0f146a0',
  password: 'rPYrOqVdpfBi',
  version: 'v1'
});

//List classifier IDs previously created
natural_language_classifier.list({},
  function(err, response) {
    if (err)
        console.log('error:', err);
      else
        console.log(JSON.stringify(response, null, 2));
});
