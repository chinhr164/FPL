var express = require('express');
var router = express.Router();
var controller = require('../controller/product')

router.get('/list', controller.getListProd);
router.get('/add', controller.addProd);

module.exports = router;