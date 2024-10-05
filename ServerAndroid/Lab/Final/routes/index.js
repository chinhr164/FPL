var express = require('express');
var router = express.Router();
var controller = require('../controller/signin.ctrl')

/* GET home page. */
router.get('/', controller.signin)

router.post('/', controller.signin)

module.exports = router;
