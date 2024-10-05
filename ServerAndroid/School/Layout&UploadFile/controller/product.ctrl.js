var fs = require('fs');

exports.getList = (req, res, next) => {
    res.render('product/listProd');
}

exports.addProd = (req, res, next) => {
    
    console.log('-----');
    console.log(req.file, req.body)
    console.log('-----');

    if (req.method === 'POST') {
        //xử lý file upload
        //di chuyển file từ tmp đến thư mục public
        //fs.rename

        fs.rename(req.file.path, './public/temp/' + req.file.originalname, (err) => {
            if (err)
                console.log(err);
            else
                console.log('http://localhost:3000/uploads/' + req.file.originalname);
        })
    }
    res.render('product/addProd')
}