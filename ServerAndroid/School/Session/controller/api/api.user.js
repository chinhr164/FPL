var model = require('../../models/user.model')

var objReturn = {//mẫu đối tượng trả về
    status: 1,
    msg: "Ok"
}

exports.getList = async (req, res, next) => {
    //các thao tác xử lý ở đây
    let list = [];
    try {
        list = await model.userModel.find();
        if (list.length > 0)
            objReturn.data = list;
        else {
            objReturn.status = 0;
            objReturn.msg = 'Không dữ liệu phù hợp'
        }

    } catch (error) {
        objReturn.status = 0;
        objReturn.msg = error.msg
    }
    res.json(objReturn)
}

exports.addList = ((req, res, next) => {
    //các thao tác xử lý ở đây
    objReturn.msg = "Thêm thành công"
    res.json(objReturn)
})

exports.updateList = ((req, res, next) => {
    //các thao tác xử lý ở đây

    res.json(objReturn)
})

exports.deleteList = ((req, res, next) => {
    //các thao tác xử lý ở đây

    res.json(objReturn)
})