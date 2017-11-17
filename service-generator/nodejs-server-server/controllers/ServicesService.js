'use strict';

exports.servicesGET = function(args, res, next) {
  /**
   * Returns api specyfication
   * Returns all informations about how to run calculations on microservice
   *
   * returns ServiceInformation
   **/
  var examples = {};
  examples['application/json'] = {
  "endpoints" : [ {
    "output" : [ {
        "additional_description" : "some desc",
        "name" : "val",
        "type" : "string",
        "required" : true
    } ],
    "path" : "aeiou",
    "input" : [ {
      "additional_description" : "some desc",
      "name" : "val",
      "type" : "string",
      "required" : true
    } ],
    "method" : "GET",
    "name" : "sqrt",
    "produces" : "application/json",
    "consumes" : "application/json"
  } ]
};
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

exports.servicesService_nameGET = function(args, res, next) {
  /**
   * Find specyfication of concrete endpoint
   * Returns a single function description
   *
   * service_name String ID of func to return
   * returns SingleEndpointConfiguration
   **/
  var examples = {};
  examples['application/json'] = {
  "output" : [ "" ],
  "path" : "aeiou",
  "input" : [ {
    "additional_description" : "aeiou",
    "name" : "aeiou",
    "type" : "string",
    "required" : true
  } ],
  "method" : "GET",
  "name" : "aeiou",
  "produces" : "aeiou",
  "consumes" : "aeiou"
};
  if (Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  } else {
    res.end();
  }
}

