// Example 1: sets up service wrapper, sends initial message, and
// receives response.
'use strict';

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

  // Display the output from dialog, if any.
  if (response.output.text.length != 0) {
      console.log(response.output.text[0]);
  }
}
