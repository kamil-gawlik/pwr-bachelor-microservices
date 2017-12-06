const express = require('express');
const app = express();
const Eureka = require('eureka-js-client').Eureka
var cors = require('cors')


app.use(cors())


const client = new Eureka({
  instance: {
    app: 'frontend',
    hostName: 'https://micro-frontend.herokuapp.com',
    ipAddr: '127.0.0.1',
    statusPageUrl: 'https://micro-frontend.herokuapp.com/info',
    port: {
      '$': 443,
      '@enabled': 'true',
    },
    vipAddress: 'frontend',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
   eureka: {
   host: 'discovery-service.herokuapp.com',
   servicePath: '/eureka/apps/',
   port: '',
   ssl: true
   },
/*  eureka: {
    host: 'localhost',
    servicePath: '/eureka/apps/',
    port: 8761
  },*/
});

function getTaskApi() {
  return client.getInstancesByAppId("TASK-API")
}


client.start();


// If an incoming request uses
// a protocol other than HTTPS,
// redirect that request to the
// same url but with HTTPS
const forceSSL = function () {
  return function (req, res, next) {
    if (req.headers['x-forwarded-proto'] !== 'https') {
      return res.redirect(
        ['https://', req.get('Host'), req.url].join('')
      );
    }
    next();
  }
}
// Instruct the app
// to use the forceSSL
// middleware

app.use(forceSSL());

// Run the app by serving the static files
// in the dist directory
app.use(express.static(__dirname + '/dist'));
// Start the app by listening on the default
// Heroku port
app.listen(process.env.PORT || 8090);


app.get('/task-api', function (req, resp) {
  resp.send(getTaskApi())
})

// For all GET requests, send back index.html
// so that PathLocationStrategy can be used
app.get('/*', function (req, res) {
  res.sendFile(path.join(__dirname + '/dist/index.html'));
});
