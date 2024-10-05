exports.yeu_cau_login = ((req, res, next) => {
    if (req.session.id){ 
        next()}
})
exports.ko_yeu_cau_login = ((req, res, next) => {
    if(!req.session.id){
        next();
    }else{
        return res.redirect
    }
    
}) 