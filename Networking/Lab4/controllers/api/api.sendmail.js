const nodemailer = require("nodemailer");

var objReturn = {};

exports.create = async (req, res, next) => {
  const transporter = nodemailer.createTransport({
    service: "gmail",
    auth: {
      user: "chinhr.164@gmail.com",
      pass: "lhke qlkb ztjz kyur",
    },
  });
  let mailOption = {
    from: '"Chinh Roronoa " <chinhr.164@gmail.com>',
    to: "chinhr.197@gmail.com",
    subject: "Hello!!",
    text: "Gửi mail bằng Nodemailer",
  };
  await transporter.sendMail(mailOption, (err, info) => {
    if (err) {
      console.log(err);
      objReturn.msg = err;
    } else {
      console.log("Thành công: " + info.messageId);
      objReturn = "Thành công: " + info.messageId;
    }
    res.json(objReturn);
  });
};
