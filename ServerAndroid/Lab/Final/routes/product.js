var express = require('express');
var router = express.Router();
var controller = require('../controller/product.ctrl')
var midW = require('../middleware/session')
const multer = require('multer')

const upload = multer({ dest: './tmp' })
router.all('/', midW.chkSession, upload.single('img'), controller.product)

module.exports = router;
