var fs = require("fs");
const path = require("path");

exports.getALL = async (req, res, next) => {
  fs.readdir("public/images/uploads", (err, file) => {
    if (err) {
      console.log("Lỗi: " + err);
      return;
    }
    res.render("upload", { image: file });
  });
};

exports.upload = async (req, res, next) => {
  if ((req.body.type = "add")) {
    try {
      fs.rename(
        req.file.path,
        "public/images/uploads/" +
          "upload-" +
          Date.now() +
          "." +
          req.file.originalname.split(".").pop(),
        (error) => {
          console.log(error);
        }
      );
    } catch (error) {
      console.log("Lỗi: Chưa có file ảnh");
    }
    res.redirect("/upload");
  }
};
