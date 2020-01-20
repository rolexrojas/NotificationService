var express = require('express');
var app = express();
var path = require('path');
var _app_folder = 'MT-Details';
//app.use(express.static(__dirname + '/dist/merchant-portal-web'));

// ---- SERVE STATIC FILES ---- //
app.get('*.*', express.static(_app_folder, {maxAge: '1y'}));

// ---- SERVE APLICATION PATHS ---- //
app.all('*', function (req, res) {
    res.status(200).sendFile("/", {root: _app_folder});
});

// ---- START UP THE NODE SERVER  ----
app.listen(8080, function () {
    console.log("Node Express server for " + app.name + " listening on http://localhost:" + 8080);
});