var db = require("./db");
const { collection } = require("mongoose");

const stuSchema = new db.mongoose.Schema(
  {
    id: {
      type: String,
      require: true,
    },
    name: {
      type: String,
      require: true,
    },
    mark: {
      type: Number,
      require: true,
    },
  },
  { collection: "student" }
);
let stuModel = db.mongoose.model("stuModel", stuSchema);

module.exports = {stuModel};
