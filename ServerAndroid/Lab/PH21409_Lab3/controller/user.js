exports.getListUser = (req, res, next) => {
    res.render('user/users',{title:req.session.userid})
}