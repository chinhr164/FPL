var model = require("../../model/sach.model");

var objReturn = {
  //mẫu đối tượng trả về
};

exports.get = async (req, res, next) => {
  //các thao tác xử lý ở đây
  let list = [];
  try {
    list = await model.sachModel.find();
    objReturn = list;
  } catch (error) {
    console.log(error);
  }
  res.json(objReturn);
};

exports.post = async (req, res, next) => {
  const params = req.body;

  let objS = new model.sachModel({
    ma_sach_ph21409: params.ma_sach_ph21409,
    tieu_de_ph21409: params.tieu_de_ph21409,
    tac_gia_ph21409: params.tac_gia_ph21409,
    nam_xuat_ban_ph21409: params.nam_xuat_ban_ph21409,
    so_trang_ph21409: params.so_trang_ph21409,
    the_loai_ph21409: params.the_loai_ph21409,
    So_luong_ph21409: params.So_luong_ph21409,
    hinh_anh_ph21409: params.hinh_anh_ph21409,
    don_gia_ph21409: params.don_gia_ph21409,
  });
  try {
    if ((await model.sachModel.find({ ma_sach_ph21409: params.id })).length > 0) {
      objReturn = {};
    } else {
      await objS.save();
      objReturn = await model.sachModel.find();
    }
  } catch (err) {
    console.log("Lỗi: " + err);
  }
  res.json(objReturn);
};

exports.put = async (req, res, next) => {
  const params = req.body;
  console.log(req.params.id);
  let objS = {
    ma_sach_ph21409: params.ma_sach_ph21409,
    tieu_de_ph21409: params.tieu_de_ph21409,
    tac_gia_ph21409: params.tac_gia_ph21409,
    nam_xuat_ban_ph21409: params.nam_xuat_ban_ph21409,
    so_trang_ph21409: params.so_trang_ph21409,
    the_loai_ph21409: params.the_loai_ph21409,
    So_luong_ph21409: params.So_luong_ph21409,
    hinh_anh_ph21409: params.hinh_anh_ph21409,
    don_gia_ph21409: params.don_gia_ph21409,
  };
  try {
    await model.sachModel.findOneAndUpdate({ ma_sach_ph21409: req.params.id }, objS);
    objReturn = await model.sachModel.find();
  } catch (err) {
    console.log("Lỗi: " + err);
  }

  res.json(objReturn);
};

exports.delete = async (req, res, next) => {
  try {
    await model.sachModel.findOneAndDelete({ ma_sach_ph21409: req.params.id });
    objReturn = await model.sachModel.find();
  } catch (err) {
    console.log("Lỗi: " + err);
  }
  res.json(objReturn);
};
