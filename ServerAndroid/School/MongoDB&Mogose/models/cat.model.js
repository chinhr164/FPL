const { Collection } = require('mongoose');
var db = require('./db');

const catSchema = new db.mongoose.Schema(
    //Định nghĩa cấu trúc của model
    {
        name: {
            type: String,
            required: true
        }

    }, { collection: 'category' }
);

//Định nghĩa thêm ở đây

//Tạo model
let catModel = db.mongoose.model('catModel',catSchema);

module.exports = {catModel};
