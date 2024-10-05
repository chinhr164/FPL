var model = require('../../models/model')

var objReturn = {
    status: 1,
    msg: "Success connection"
}

exports.list = async (req, res, next) => {
    let list = [];
    try {
        list = await model.staffModel.find()
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
    let objS = new model.staffModel({
        staffID: req.body.staffID,
        fullname: req.body.fullname,
        username: req.body.username,
        password: req.body.password,
        role: req.body.role,
        outlet: req.body.outlet,
        tel: req.body.tel,
        email: req.body.email
    })

    try {
        await objS.save();
        objReturn.msg = 'Thêm thành công';
    } catch (error) {
        objReturn.msg = 'Lỗi: ' + error.message;
    }
    res.json(objReturn)
}

exports.update = async (req, res, next) => {
    let objS = {
        staffID: req.body.staffID,
        fullname: req.body.fullname,
        username: req.body.username,
        password: req.body.password,
        role: req.body.role,
        outlet: req.body.outlet,
        tel: req.body.tel,
        email: req.body.email
    }

    try {
        await model.staffModel.findOneAndUpdate({ staffID: req.body.staffID }, objS)
        objReturn.msg = 'Cập nhật thành công';
    } catch (error) {
        objReturn.msg = 'Lỗi: ' + error.message;
    }
    res.json(objReturn)
}

exports.delete = async (req, res, next) => {
    try {
        await model.staffModel.findOneAndDelete({ staffID: req.body.staffID })
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