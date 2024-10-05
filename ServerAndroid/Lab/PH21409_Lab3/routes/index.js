var express = require('express');
var router = express.Router();
var controller = require('../controller/signin')
//username and password
const username = 'chinhr164'
const password = '164@chinhR'

// a variable to save a session
var session;

/* GET home page. */

router.get('/', function (req, res, next) {
  session = req.session;
  if (session.userid) {
    res.render('index',{title:session.userid});
  } else
    next()
});
router.get('/', controller.signin)

router.post('/', (req, res, next) => {
  if (req.body.username == username && req.body.password == password) {
    session = req.session;
    session.userid = req.body.username;
    console.log(req.session)
    res.render('index',{title:req.body.username});
  }
  else {
    res.send('Invalid username or password');
  }
})
module.exports = router;
