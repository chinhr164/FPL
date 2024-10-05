var express = require('express');
var router = express.Router();
var controller = require('../controller/product.ctrl')
var midW = require('../middleware/session')

router.all('/',midW.chkSession, controller.category)

module.exports = router;
