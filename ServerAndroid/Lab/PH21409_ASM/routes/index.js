var express = require('express');
var router = express.Router();
var midW = require('../middleware/session')
var controller = require('../controller/signin.ctrl')

/* GET home page. */
router.get('/', midW.chkSession, controller.signin)

router.post('/', controller.signin)

router.get('/signin', (req, res, next) => {
    //Get type of view
    var size = req.useragent.isMobile ? 'small' : "";

    //Destroy session
    req.session.destroy();
    res.render('home/signin', { title: "H'Patisserie", size: size, msg: '' })
})

module.exports = router;
