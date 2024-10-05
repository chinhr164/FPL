var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', { title: 'Express' });
});

// router.get('/sanpham/:id?', (req, res, next) => {
//   //lấy dữ liệu theo params
//   //thêm ? để tạo optional
//   console.log(req.query()); // các tham số nằm trong đối tượng query
//   res.send('Trang Sản Phẩm ' + req.params.id)
// })

router.post('/sanpham/:id?', (req, res, next) => {
  console.log("Dữ liệu post");
  console.log(req.body()); 
  res.send(req.body)
})


module.exports = router;
