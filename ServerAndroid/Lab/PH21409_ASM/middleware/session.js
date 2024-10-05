// exports.chkSession = ((req, res, next) => {
//     if (req.session.userid) {
//         console.log('>------------ Có session -------------->');
//         next()
//     } else {
//         console.log('>------------ Không có session -------------->');
//         var size = req.useragent.isMobile ? 'small' : "";
//         res.render('home/signin', { title: "H'Patisserie", size: size, msg: '' })
//     }
// })

exports.chkSession = ((req, res, next) => {
    next();
})

