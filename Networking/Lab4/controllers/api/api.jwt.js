const jwt = require("jsonwebtoken");

var objReturn = {
  //mẫu đối tượng trả về
  msg: "OK",
};

const accessTokenSecret = "291296";
const refressTokenSecret = "291296";

const users = [
  {
    id: 1,
    username: "hinn926",
    password: "hinn926",
  },
];

function generateAcessToken(user) {
  return jwt.sign(user, accessTokenSecret, { expiresIn: "15m" });
}

function generateRefressToken(user) {
  return jwt.sign(user, refressTokenSecret, { expiresIn: "7d" });
}

exports.getAll = async (req, res, next) => {
  const { username, password } = req.body;

  const user = users.find(
    (u) => u.username === username && u.password === password
  );

  if (!user) {
    console.log("user, pass khong dung");
    return;
  }

  objReturn.accessToken = generateAcessToken({
    id: user.id,
    username: user.username,
  });
  objReturn.refessToken = generateRefressToken({
    id: user.id,
    username: user.username,
  });

  res.json(objReturn);
};
