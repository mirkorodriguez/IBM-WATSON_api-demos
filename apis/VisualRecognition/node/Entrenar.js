var watson = require('watson-developer-cloud');

var fs = require('fs');

var visual_recognition = watson.visual_recognition({
 api_key: '{api_key}',
 version: 'v3',
 version_date: '2016-05-19'
});

var params = {
  name: 'dog',
  beagle_positive_examples: fs.createReadStream('C:/Users/mirko/Downloads/beagle.zip'),
  husky_positive_examples: fs.createReadStream('C:/Users/mirko/Downloads/husky.zip'),
  golden_retriever_positive_examples: fs.createReadStream('C:/Users/mirko/Downloads/golden-retriever.zip'),
  negative_examples: fs.createReadStream('C:/Users/mirko/Downloads/cats.zip')
};

visual_recognition.createClassifier(params,
  function(err, response) {
   if (err)
    console.log(err);
   else
    console.log(JSON.stringify(response, null, 2));
});
