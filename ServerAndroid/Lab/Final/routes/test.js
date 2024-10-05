var express = require('express');
var router = express.Router();
var controller = require('../controller/test.ctrl')

router.all('/', controller.test)

module.exports = router;
