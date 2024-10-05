var express = require('express');
var router = express.Router();
var apiCtrl = require('../controller/api/api.user')

router.get('/users', apiCtrl.getList)                //ds        u: /api/users
router.post('/users', apiCtrl.addList)               //add       POST: /api/users
router.put('/users/:id', apiCtrl.updateList)         //update    PUT: /api/users/id
router.delete('/users/:id', apiCtrl.deleteList)      //delete    DELETE: /api/users/id

module.exports = router;
