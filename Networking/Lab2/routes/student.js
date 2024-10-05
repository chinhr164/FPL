var express = require('express');
var router = express.Router();
var controller = require('../controller/student.ctrl')

/* GET users listing. */
router.get('/', controller.getList);

module.exports = router;
