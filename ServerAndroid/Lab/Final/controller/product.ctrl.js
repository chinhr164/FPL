/* General */
var model = require('../models/model')
var fs = require('fs');

exports.product = async (req, res, next) => {
    //Get session
    let user = req.session.userid ? req.session.userid : "demo";
    var listC = await model.catModel.find()
    var listP = await model.prodModel.find().populate('category')

    if (req.method == "POST") {

        //Add DATA
        if (req.body.type == 'add') {
            //Xử lý ảnh
            fs.rename(req.file.path, './public/images/uploads/' + req.file.originalname, (err) => {
                if (err)
                    console.log(err);
                else
                    console.log('http://localhost:3000/uploads/' + req.file.originalname);
            })
            var img = 'http://localhost:3000/images/uploads/' + req.file.originalname;

            let objP = new model.prodModel({
                sku: req.body.sku,
                name: req.body.name,
                tag: req.body.tag,
                category: req.body.cat,
                price: req.body.price,
                qty: req.body.qty,
                img: img,
                description: req.body.description
            });
            //Thêm vào database
            try {
                await objP.save();
                msg = 'Thêm thành công';
            } catch (error) {
                msg = 'Lỗi: ' + error.message;
                console.log(error);
            }
            res.redirect('/products')
        }

        //Update DATA
        if (req.body.type == 'update') {
            let sku = req.body.sku;
            //Kiểm tra hợp lệ

            //Tạo đối tượng
            let objP = {
                sku: req.body.sku,
                name: req.body.name,
                tag: req.body.tag,
                category: req.body.cat,
                price: req.body.price,  
                qty: req.body.qty,
                description: req.body.description,
                _id : req.body.id
            }
            //Thực hiện cập nhật dữ liệU
            

            try {
                fs.rename(req.file.path, './public/images/uploads/' + req.file.originalname, (err) => {
                    if (err)
                        console.log(err);
                    else
                        console.log('http://localhost:3000/uploads/' + req.file.originalname);
                })
                objP.img = 'http://localhost:3000/images/uploads/' + req.file.originalname;
                await model.prodModel.findOneAndUpdate({ sku: sku }, objP)
            } catch (error) {
                await model.prodModel.findOneAndUpdate({ sku: sku }, objP)
            }
                
            

            // try {
            //      await model.prodModel.findOneAndUpdate({ sku: sku }, objP)
            //     // console.log(objP);
            // } catch (error) {
            //     msg = 'Lỗi: ' + error.message;
            //     console.log(error);
            // }
            res.redirect('/products')
        }

        //Delete DATA
        if (req.body.type == 'delete') {
            let pID = req.body.pID;
            await model.prodModel.findOneAndDelete({ sku: pID });
            res.redirect('/products')
        }
    }

    res.render('product/products', { title: "List Products", listP: listP, listC: listC, user: user })
}

exports.category = async (req, res, next) => {
    //Get session
    let user = req.session.userid ? req.session.userid : "demo";
    let msg = '';
    var listC = await model.catModel.find()

    if (req.method == 'POST') {
        console.log(12312312321312);

        //Add DATA
        if (req.body.type == 'add') {
            //Kiểm tra hợp lệ
            var date = new Date();
            var d = date.getDate() > 9 ? date.getDate() : '0' + String(date.getDate());
            var m = date.getMonth() > 9 ? date.getMonth() : '0' + String(date.getMonth());
            var y = date.getFullYear();

            // Tạo đối tượng
            let objC = new model.catModel({
                name: req.body.name,
                creationDate: d + '/' + m + '/' + y
            });
            //Thêm vào database
            try {
                await objC.save();
                msg = 'Thêm thành công';
            } catch (error) {
                msg = 'Lỗi: ' + error.message;
                console.log(error);
            }
            res.redirect('/categories')
        }

        //Delete DATA
        if (req.body.type == 'delete') {
            let name = req.body.name;
            await model.catModel.findOneAndDelete({ name: name });
            res.redirect('/categories')
        }

    }

    res.render('product/categories', { title: "List Categories", listC: listC, user: user })
}
