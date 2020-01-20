var express = require('express');
var app = express();
var path = require('path');
var _app_folder = 'Boletas';
//app.use(express.static(__dirname + '/dist/merchant-portal-web'));

// ---- SERVE STATIC FILES ---- //
// ---- QA ----- //
// app.use('/',express.static(path.join(__dirname, 'Boletas')));
//
// app.get('/', (req, res) => {
//     res.sendFile(path.join(__dirname + '/Boletas/index.html'));
// });

// ---- Desarrollo ----- //
app.use('/portalpelota',express.static(path.join(__dirname, 'Boletas')));

app.get('/portalpelota', (req, res) => {
    res.sendFile(path.join(__dirname + '/Boletas/index.html'));
});

// ---- START UP THE NODE SERVER  ----
app.listen(8080, function () {
    console.log("Node Express server for " + app.name + " listening on http://localhost:" + 8080);
});