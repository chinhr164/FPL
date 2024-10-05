const express = require("express");
const router = express.Router();

const jwtControllers = require("../controllers/api/api.jwt");
router.get("/", jwtControllers.getAll);

module.exports = router;
