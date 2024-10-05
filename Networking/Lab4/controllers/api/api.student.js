var model = require("../../models/student.model");

var objReturn = {
  //mẫu đối tượng trả về
  msg: "OK",
};

exports.create = async (req, res, next) => {
  const params = req.body;

  let objS = new model.stuModel({
    id: params.id,
    name: params.name,
    mark: params.mark,
  });

  try {
    if ((await model.stuModel.find({ id: params.id })).length > 0) {
      objReturn.msg = "Mã sinh viên đã tồn tại";
      delete objReturn.data;
    } else {
      await objS.save();
      objReturn.msg = "Thêm thành công";

      list = await model.stuModel.find();
      objReturn.data = list;
    }
  } catch (error) {
    console.log(error)
    objReturn.msg = "Lỗi: " + error.msg;
  }

  res.json(objReturn);
};

exports.get = async (req, res, next) => {
  const { id } = req.params;

  if ((await model.stuModel.find({ id })).length === 0) {
    objReturn.msg = "Mã sinh viên không tồn tại";
    delete objReturn.data;
  } else {
    objReturn.msg = "Tìm thành công";

    list = await model.stuModel.find({ id });
    objReturn.data = list;
  }

  res.json(objReturn);
};

exports.edit = async (req, res, next) => {
  const { id } = req.params;
  const params = req.body;

  res.json(objReturn);
};

exports.delete = async (req, res, next) => {
  const { id } = req.params;

  try {
    if ((await model.stuModel.find({ id })).length === 0) {
      objReturn.msg = "Mã sinh viên không tồn tại";
      delete objReturn.data;
    } else {
      await model.stuModel.findOneAndDelete({ id: req.params.id });
      objReturn.msg = "Xóa thành công";

      list = await model.stuModel.find();
      if (list.length > 0) objReturn.data = list;
      else {
        objReturn.msg = "Không dữ liệu phù hợp";
      }
    }
  } catch (error) {
    objReturn.msg = "Lỗi: " + error.msg;
  }

  res.json(objReturn);
};

exports.getAll = async (req, res, next) => {
  res.json(objReturn);
};

exports.getByPage = async (req, res, next) => {
  const { page, limit } = req.params;

  res.json(objReturn);
};
