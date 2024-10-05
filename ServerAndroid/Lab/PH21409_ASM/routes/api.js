var express = require('express');
var router = express.Router();
var apiProd = require('../controller/api/api-product')
var apiCat = require('../controller/api/api-cat')
var apiStaff = require('../controller/api/api-staff')

router.get('/product', apiProd.list)
// router.get('/product/:id', apiProd.find)
router.post('/product', apiProd.add)
router.put('/product/:id', apiProd.update)
router.delete('/product/:id', apiProd.delete)

router.get('/categories', apiCat.list)
router.post('/categories/add/', apiCat.add)
router.put('/categories/update/:id', apiCat.update)
router.delete('/categories/delete/:id', apiCat.delete)

router.get('/staffs', apiStaff.list)
router.post('/staffs', apiStaff.add)
router.put('/staffs/:id', apiStaff.update)
router.delete('/staffs/:id', apiStaff.delete)

// router.get('/staffs/login', apiStaff.list)
// router.get('/staffs/logout', apiStaff.list)

module.exports = router;