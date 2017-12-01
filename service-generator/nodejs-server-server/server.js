const express = require('express');
const app = express();
const Eureka = require('eureka-js-client').Eureka
var cors = require('cors')
var bodyParser = require('body-parser')


app.use(cors())

const client = new Eureka({
    instance: {
        app: 'fibo',
        hostName: 'https://micro-fib.herokuapp.com/',
        ipAddr: '127.0.0.1',
        statusPageUrl: 'https://micro-fib.herokuapp.com//info',
        port: {
            '$': 8080,
            '@enabled': 'true',
        },
        vipAddress: 'fib',
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
/*    eureka: {
        host: 'localhost',
        servicePath: '/eureka/apps/',
        port: 8761
    },*/
});


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
var jsonParser = bodyParser.json();
app.listen(process.env.PORT || 8080);


var fibEndpoint = {
    "name": "N Fibonacci numbers",
    "path": "/fib",
    "method": "POST",
    "input": [{
        "additional_description": "Number of Fibonacci numbers.",
        "name": "n",
        "type": "int",
        "required": true
    }],
    "output": [{
        "name": "res",
        "type": "int",
        "required": true
    }],
};

const allServices = {"enpoints": [fibEndpoint]};

app.get('/services', function (req, resp) {
    resp.send(JSON.stringify(allServices))

});

app.get('/services/*', function (req, resp) {
    resp.send(JSON.stringify(fibEndpoint))
});


var fibString = function (n) {
    var i;
    var fib = []; // Initialize array!

    fib[0] = 1;
    fib[1] = 1;
    for (i = 2; i < n; i++) {
        fib[i] = fib[i - 2] + fib[i - 1];
    }
    return fib.join(" ");
}

app.post('/fib', jsonParser, function (req, res) {
    if (!req.body) {
        return res.sendStatus(400)
    }
    res.send({"res": fibString(req.body.n)});
});
