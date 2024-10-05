exports.getListProd = (req, res, next) => {
    let title = "Đây là trang sản phẩm"
    res.render('product/list', { title: title })
}

exports.addProd = (req, res, next) => {
    res.render('product/add')
}

exports.updateProd = (req, res, next) => {

}

exports.deleteProd = (req, res, next) => {

}