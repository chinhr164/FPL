var model = require('../../models/model')

var objReturn = {
    status: 1,
    msg: "Success connection"
}

exports.list = async (req, res, next) => {
    let list = [];
    try {
        list = await model.catModel.find()
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

exports.add = async (req, res, next) => {
    let objC = new model.catModel({
        name: req.body.name,
        creationDate: req.body.creationDate
    })

    try {
        await objC.save();
        objReturn.msg = 'Thêm thành công';
    } catch (error) {
        objReturn.msg = 'Lỗi: ' + error.message;
    }
    res.json(objReturn)
}

exports.update = async (req, res, next) => {
    let objC = {
        name: req.body.name,
        creationDate: req.body.creationDate
    }

    try {
        await model.catModel.findOneAndUpdate({ _id: req.params.id }, objC)
        objReturn.msg = 'Cập nhật thành công';
    } catch (error) {
        objReturn.msg = 'Lỗi: ' + error.message;
    }
    res.json(objReturn)
}

exports.delete = async (req, res, next) => {
    try {
        await model.catModel.findOneAndDelete({ _id: req.params.id })
        objReturn.msg = 'Xóa thành công';
    } catch (error) {
        objReturn.msg = 'Lỗi: ' + error.message;
    }
    res.json(objReturn)
}

// exports.detail = async (req, res, next) => {
//     let list = [];
//     try {
//         list = await model.staffModel.find({ sku: req.params.id })
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