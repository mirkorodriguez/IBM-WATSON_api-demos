// You should install prompt-sync using 'npm install prompt-sync'
'use strict';

// Example 2: adds user input and detects intents.

var prompt = require('prompt-sync')();
var ConversationV1 = require('watson-developer-cloud/conversation/v1');

// Set up Conversation service wrapper.
var conversation = new ConversationV1({
  username: '3d2935e7-6ef2-41c2-8f73-bd07bc0fb7aa', // replace with username from service key
  password: 'iN0b6tsoz5U6', // replace with password from service key
  path: { workspace_id: '61c262b5-48f1-47fe-968f-f4136d13ca07' }, // replace with workspace ID
  version_date: '2016-07-11'
});

// Start conversation with empty message.
conversation.message({}, processResponse);

// Process the conversation response.
function processResponse(err, response) {
  if (err) {
    console.error(err); // something went wrong
    return;
  }

  // If an intent was detected, log it out to the console.
  if (response.intents.length > 0) {
    console.log('Detected intent: #' + response.intents[0].intent);
  }

  // Display the output from dialog, if any.
  if (response.output.text.length != 0) {
      console.log(response.output.text[0]);
  }

  // Prompt for the next round of input.
  var newMessageFromUser = prompt('>> ');
  conversation.message({
    input: { text: newMessageFromUser }
    }, processResponse)
}
