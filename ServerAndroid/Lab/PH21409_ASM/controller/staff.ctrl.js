/* General */
var model = require('../models/model')

/* Staff */
exports.staff = async (req, res, next) => {
    //Get session
    let user = req.session.userid ? req.session.userid : "demo";
    let msg = '';
    var listO = await model.outModel.find()
    var listS = await model.staffModel.find().populate('outlet')
    var listR = await model.roleModel.find()

    if (req.method == 'POST') {
        //Add DATA
        if (req.body.type == 'add') {
            //Kiểm tra hợp lệ

            //Tạo đối tượng
            var role = '';
            if ((Array.isArray(req.body.role))) { //Kiểm tra có nhiều hay 1 nhiệm vụ
                role = req.body.role.join(", ") //nhiều nhiệm vụ thì ghép thành 1 chuỗi
            } else {
                role = req.body.role   //chỉ có 1 nhiệm vụ thì gán luôn
            }
            let objS = new model.staffModel({
                staffID: req.body.id,
                fullname: req.body.fullname,
                username: req.body.username,
                password: req.body.password,
                email: req.body.email,
                outlet: req.body.outlet,
                role: role,
                tel: req.body.tel,
            });
            //Thêm vào database
            try {
                await objS.save();
                msg = 'Thêm thành công';
            } catch (error) {
                msg = 'Lỗi: ' + error.message;
                console.log(error);
            }
            res.redirect('/staffs')
        }

        //Update DATA
        if (req.body.type == 'update') {
            let sID = req.body.sID;

            //Kiểm tra hợp lệ

            //Tạo đối tượng
            console.log(req.body.role);
            var role = '';
            if ((Array.isArray(req.body.role))) {
                role = req.body.role.join(", ")
            } else {
                role = req.body.role
            }
            //Ghép chuỗi các nhiệm vụ
            let objS = new model.staffModel({
                fullname: req.body.fullname,
                username: req.body.username,
                password: req.body.password,
                email: req.body.email,
                outlet: req.body.outlet,
                role: role,
                tel: req.body.tel,
            });
            //Thực hiện cập nhật dữ liệU
            objS._id = req.body.id;
            try {
                await model.staffModel.findOneAndUpdate({ staffID: sID }, objS)
            } catch (error) {
                msg = 'Lỗi: ' + error.message;
                console.log(error);
            }
            res.redirect('/staffs')
        }

        //Delete DATA
        if (req.body.type == 'delete') {
            let sID = req.body.sID;
            await model.staffModel.findOneAndDelete({ staffID: sID });
            res.redirect('/staffs')
        }
    }

    res.render('staff/staffs', { title: "List Staffs", listS: listS, listO: listO, listR: listR, user: user })
}

/* Outlet */
exports.outlet = async (req, res, next) => {
    //Get session
    let user = req.session.userid ? req.session.userid : "demo";

    let msg = '';
    var list = await model.outModel.find()

    if (req.method == 'POST') {

        //Add data
        if (req.body.type == "add") {
            //Kiểm tra hợp lệ

            //Tạo đối tượng
            let objO = new model.outModel({
                outletID: req.body.id,
                name: req.body.name,
                openingDate: req.body.date,
                tel: req.body.tel,
                address: req.body.address
            });
            //Thêm vào database
            try {
                await objO.save();
                msg = 'Thêm thành công';
            } catch (error) {
                msg = 'Lỗi: ' + error.message;
                console.log(error);
            }
            res.redirect('/outlets')
        }

        //Update data
        if (req.body.type == "update") {
            let oID = req.body.oID;
            console.log(req.body);

            // kiểm tra hợp lệ dữ liệu ở đây

            // tạo đối tượng model và gán dữ liệu
            let objO = new model.outModel();
            objO.name = req.body.name;
            objO.openingDate = req.body.date;
            objO.tel = req.body.tel;
            objO.address = req.body.address
            // thực hiện Ghi vào CSDL
            objO._id = req.body.id;
            try {
                await model.outModel.findOneAndUpdate({ outletID: oID }, objO);
            } catch (error) {
                console.log(error);
            }
            res.redirect('/outlets')
        }

        //Delete data
        if (req.body.type == "delete") {
            let oID = req.body.oID;
            await model.outModel.findOneAndDelete({ outletID: oID });
            res.redirect('/outlets')
        }
    }

    res.render('staff/outlets', { title: "List Outlets", listO: list, user: user })

}

exports.role = async (req, res, next) => {
    //Get session
    let user = req.session.userid ? req.session.userid : "demo";
    let msg = '';
    var listR = await model.roleModel.find()

    if (req.method == 'POST') {

        //Add DATA
        if (req.body.type == 'add') {
            //Kiểm tra hợp lệ
            var date = new Date();
            var d = date.getDate() > 9 ? date.getDate() : '0' + String(date.getDate());
            var m = date.getMonth() > 9 ? date.getMonth() : '0' + String(date.getMonth());
            var y = date.getFullYear();

            // Tạo đối tượng
            let objR = new model.roleModel({
                name: req.body.name,
                creationDate: d + '/' + m + '/' + y
            });
            //Thêm vào database
            try {
                await objR.save();
                msg = 'Thêm thành công';
            } catch (error) {
                msg = 'Lỗi: ' + error.message;
                console.log(error);
            }
            res.redirect('/roles')
        }

        //Delete DATA
        if (req.body.type == 'delete') {
            let name = req.body.name;
            await model.roleModel.findOneAndDelete({ name: name });
            res.redirect('/roles')
        }

    }

    res.render('staff/roles', { title: "List Roles", listR: listR, user: user })
}