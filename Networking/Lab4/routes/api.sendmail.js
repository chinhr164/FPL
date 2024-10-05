const express = require("express");
const router = express.Router();

const sendMailControllers = require("../controllers/api/api.sendmail");
router.post("/", sendMailControllers.create);

module.exports = router;
