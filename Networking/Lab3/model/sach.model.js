const { Collection } = require("mongoose");
var db = require("./db");

const sachSchema = new db.mongoose.Schema(
  {
    ma_sach_ph21409: {
      type: String,
      required: true,
    },
    tieu_de_ph21409: {
      type: String,
      required: true,
    },
    tac_gia_ph21409: {
      type: String,
      required: true,
    },
    nam_xuat_ban_ph21409: {
      type: Number,
      required: true,
    },
    so_trang_ph21409: {
      type: Number,
      required: true,
    },
    the_loai_ph21409: {
      type: String,
      required: true,
    },
    So_luong_ph21409: {
      type: Number,
      required: true,
    },
    hinh_anh_ph21409: {
      type: String,
      required: true,
    },
    don_gia_ph21409: {
      type: Number,
      required: true,
    },
  },
  { collection: "Sach" }
);

let sachModel = db.mongoose.model("sachModel", sachSchema);

module.exports = { sachModel };
