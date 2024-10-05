var express = require('express');
var route = express.Router();
var apiCtrl = require('../controller/api/api.sach.js')

// Add routes
route.get('/sach', apiCtrl.get);
route.post('/sach', apiCtrl.post);
route.put('/sach/:id', apiCtrl.put);
route.delete('/sach/:id', apiCtrl.delete);

module.exports = route;
