const express = require("express");
const router = express.Router();
const multer = require("multer");

const upload = multer({ dest: "./tmp" });

const uploadControllers = require("../controllers/upload.controllers");

router.get("/", uploadControllers.getALL);
router.post("/", upload.single("img"), uploadControllers.upload);

module.exports = router;
