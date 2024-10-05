var express = require('express');
var router = express.Router();
var controller = require('../controller/user')

/* GET users listing. */
router.get('/', controller.getListUser)

module.exports = router;
