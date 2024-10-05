var express = require('express');
var router = express.Router();
var controller = require('../controller/product.ctrl')

router.get('/', controller.getList);
router.get('/add', controller.addProd);

const multer  = require('multer')
const upload = multer({ dest: './tmp' })
router.post('/add', upload.single('img'),controller.addProd);
router.get('/edit/:sku', controller.editProd);
router.post('/edit/:sku', controller.editProd);


module.exports = router;