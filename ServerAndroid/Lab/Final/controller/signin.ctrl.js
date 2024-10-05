const model = require('../models/model')

exports.signin = async (req, res, next) => {
    //Get type of view
    let user = req.session.userid ? req.session.userid : "demo";
    let msg = ''
    if (req.method === 'POST') {
        try {
            let obj = await model.staffModel.findOne({ username: req.body.username })
            if (obj != null) {
                if (req.body.password == obj.password) {
                    req.session.userid = req.body.username;
                    console.log(req.session.userid);
                    return res.redirect('/');
                } else {
                    msg = 'Mật khẩu không đúng'
                }
            } else {
                msg = 'Tài khoản không tồn tại'
            }

        } catch (error) {
            console.log(error);
        }


        //Get type of view
        var size = req.useragent.isMobile ? 'small' : "";
        return res.render('home/signin', { title: "H'Patisserie", size: size, msg: msg })
    }
    res.render('home/dashboard', { title: "H'Patisserie", user: user });
}