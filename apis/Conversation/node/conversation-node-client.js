// You should install prompt-sync using 'npm install prompt-sync'

var prompt = require('prompt-sync')();
var ConversationV1 = require('watson-developer-cloud/conversation/v1');

// Set up Conversation service.
var conversation = new ConversationV1({
  username: '05317deb-618f-4060-822c-5f29006c1135', // replace with username from service key
  password: 'OW1Nr2Q6M77x', // replace with password from service key
  path: { workspace_id: '5b14049e-b5fe-4abc-a532-773293225a6c' }, // replace with workspace ID
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

  var endConversation = false;

  // Display the output from dialog, if any.
  if (response.output.text.length != 0) {
      // console.log(" Output: " + JSON.stringify(response));
      console.log(response.output.text[0]  + "\n");
  }

  // If we're not done, prompt for the next round of input.
  if (!endConversation) {
    var newMessageFromUser = prompt('>> ');
    conversation.message({
      input: { text: newMessageFromUser },
      // Send back the context to maintain state.
      context : response.context,
    }, processResponse)
  }
}
