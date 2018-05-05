var watson = require('watson-developer-cloud');
var fs = require('fs');
var visual_recognition = watson.visual_recognition({
 api_key: '<api_key>',
 version: 'v3',
 version_date: '2016-05-20'
});
var params = {
 images_file: fs.createReadStream('C:/Users/mirko/Desktop/tmp2/ibm-watson/apis/VisualRecognition/resources/images/dogs.jpg'),
 classifier_ids: ["<custom_classifer_id", "default"]
};
visual_recognition.classify(params, function(err, res) {
 if (err)
 console.log(err);
 else
 console.log(JSON.stringify(res, null, 2));
});
