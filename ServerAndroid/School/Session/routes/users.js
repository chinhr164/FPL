var express = require('express');
var router = express.Router();
var userCtrl = require('../controller/user.ctrl');
var chkLogin = require('../middleware/check.login')

//Middleware cho tất cả
// route.use((reg, res, next) => {
// console.log('>---------------- Đã gọi -------------->');
// })

/* GET users listing. */
router.get('/', chkLogin.ko_yeu_cau_login, function (req, res, next) {
  res.send('respond with a resource');
});

// route login
router.get('/login', userCtrl.Login);
router.post('/login', userCtrl.Login);

router.get('/reg', userCtrl.Reg);
router.post('/reg', userCtrl.Reg);

router.get('/logout', userCtrl.Logout);




module.exports = router;