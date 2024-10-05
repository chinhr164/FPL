var express = require('express');
var router = express.Router();
var midW = require('../middleware/session')
var controller = require('../controller/staff.ctrl')

router.all('/', midW.chkSession, controller.staff)

module.exports = router;
