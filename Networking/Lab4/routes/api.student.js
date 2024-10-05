const express = require("express");
const router = express.Router();

const apiControllers = require("../controllers/api/api.student");
router.post("/", apiControllers.create);
router.get("/:id", apiControllers.get);
router.delete("/:id", apiControllers.delete);
router.get("/", apiControllers.getAll);

module.exports = router;
