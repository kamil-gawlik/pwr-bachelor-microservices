'use strict';

var url = require('url');

var Services = require('./ServicesService');

module.exports.servicesGET = function servicesGET (req, res, next) {
  Services.servicesGET(req.swagger.params, res, next);
};

module.exports.servicesService_nameGET = function servicesService_nameGET (req, res, next) {
  Services.servicesService_nameGET(req.swagger.params, res, next);
};
