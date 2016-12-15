'use strict';

var TradeoffAnalyticsV1 = require('watson-developer-cloud/tradeoff-analytics/v1');
var tradeoff_analytics = new TradeoffAnalyticsV1({
  username: 'cc35d4e3-a15b-4052-958d-fe0e4f40f9ca',
  password: 'xX62zUw36Gd4'
});

var params = require('../resources/problem.json');

tradeoff_analytics.dilemmas(params, function(error, resolution) {
  if (error)
    console.log('error:', error)
  else
    console.log(JSON.stringify(resolution, null, 2));
});
