var sModel = require("../model/student.model");

exports.getList = async (req, res, next) => {
  var list = await sModel.stuModel.find();

  console.log(list);

  res.render("student", { listStudent: list });
};
