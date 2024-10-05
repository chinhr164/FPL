var fs = require('fs');
var pModel = require('../models/prod.model')
var cModel = require('../models/cat.model')

exports.getList = async (req, res, next) => {
    //Thêm chức năng lọc dữ liệu
    let condition = null;

    //Ví dụ lọc theo giá
    if (typeof (req.query.price) != 'undefined') {
        condition = { price: req.query.price }
    }

    var list = await pModel.prodModel.find(condition)
        .populate('category');

    console.log(list);

    res.render('product/listProd', { listProd: list });
}

exports.addProd = async (req, res, next) => {
    let msg = '';

    //Lấy danh sách thể loại
    var list = await cModel.catModel.find();


    if (req.method == 'POST') {
        //Kiểm tra hợp lệ

        //Tạo đối tượng
        let objProd = new pModel.prodModel({
            sku: req.body.sku,
            name: req.body.name,
            tag: req.body.tag,
            category: req.body.category,
            price: req.body.price,
            qty: req.body.qty
        });
        //Thêm vào database
        try {
            let prod = await objProd.save();
            console.log(prod);
            msg = 'Thêm thành công';
        } catch (error) {
            msg = 'Lỗi: ' + error.message;
            console.log(error);
        }
    }

    res.render('product/addProd', { msg: msg, listCat: list })
}

exports.editProd = async (req, res, next) => {
    let msg = '';
    let id = req.params.sku;

    //Lấy thông tin sản phẩm để hiển thị lên giao diện
    try {
        var objProd = await pModel.prodModel.find({sku:id});
        var listCat  = await cModel.catModel.find();
    } catch (error) {
        msg = 'Lỗi:' + error.message;
        console.log(error);
    }
    console.log(objProd);

     
    res.render('product/editProd', { msg: msg, objProd: objProd, listCat : listCat  })
}