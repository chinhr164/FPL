var express = require('express');
var router = express.Router();
var controller = require('../controller/home.ctrl')

/* GET home page. */
router.get('/', controller.index);

module.exports = router;
