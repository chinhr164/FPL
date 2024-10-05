var model = require('../../models/model')

var objReturn = {
    status: 1,
    msg: "Success connection"
}

exports.list = async (req, res, next) => {
    let list = [];
    try {
        list = await model.prodModel.find().populate('category')
        if (list.length > 0)
            objReturn.data = list;
        else {
            objReturn.status = 0;
            objReturn.msg = 'Không dữ liệu phù hợp!'
        }
    } catch (error) {
        objReturn.status = 0;
        objReturn.msg = error.msg
    }
    res.json(objReturn)
}

// exports.list = async (req, res, next) => {
//     let list = [];
//     try {
//         list = await model.prodModel.find().populate('category')
//         if (list.length > 0)
//             objReturn.data = list;
//         else {
//             objReturn.status = 0;
//             objReturn.msg = 'Không dữ liệu phù hợp!'
//         }
//     } catch (error) {
//         objReturn.status = 0;
//         objReturn.msg = error.msg
//     }
//     res.json(objReturn)
// }

exports.add = async (req, res, next) => {
    let objP = new model.prodModel({
        sku: req.body.sku,
        name: req.body.name,
        tag: req.body.tag,
        category: req.body.category,
        price: req.body.price,
        qty: req.body.qty,
        img: req.body.img,
        description: req.body.description,
    })

    try {
        await objP.save();
        objReturn.msg = 'Thêm thành công';
    } catch (error) {
        obj.msg = 'Lỗi: ' + error.message;
    }
    res.json(objReturn)
}

exports.update = async (req, res, next) => {
    let objP = {
        sku: req.body.sku,
        name: req.body.name,
        tag: req.body.tag,
        category: req.body.category,
        price: req.body.price,
        qty: req.body.qty,
        img: req.body.img,
        description: req.body.description,
    }

    try {
        await model.prodModel.findOneAndUpdate({ sku: req.params.id }, objP)
        objReturn.msg = 'Cập nhật thành công';
    } catch (error) {
        objReturn.msg = 'Lỗi: ' + error.message;
    }
    res.json(objReturn)
}

exports.delete = async (req, res, next) => {
    try {
        await model.prodModel.findOneAndDelete({ sku: req.params.id })
        objReturn.msg = 'Xóa thành công';
    } catch (error) {
        objReturn.msg = 'Lỗi: ' + error.message;
    }
    res.json(objReturn)
}

exports.detail = async (req, res, next) => {
    let list = [];
    try {
        list = await model.prodModel.find({ sku: req.params.id })
        if (list.length > 0)
            objReturn.data = list;
        else {
            objReturn.status = 0;
            objReturn.msg = 'Không dữ liệu phù hợp!'
        }
    } catch (error) {
        objReturn.status = 0;
        objReturn.msg = error.msg
    }
    res.json(objReturn)
}