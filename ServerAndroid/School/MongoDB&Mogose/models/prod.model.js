const { Collection } = require('mongoose');
var db = require('./db');
let catModel = require('./cat.model');

const prodSchema = new db.mongoose.Schema(
    //Định nghĩa cấu trúc của model
    {
        sku: {
            type: String,
            required: true
        },
        name: {
            type: String,
            required: true
        },
        tag: {
            type: String,
        },
        category: {
            type: db.mongoose.Schema.Types.ObjectId, ref: 'catModel'
        },
        price: {
            type: Number,
            required: true
        },
        qty: {
            type: Number,
            required: true,
        }

    }, { collection: 'product' }
);

//Tạo model
let prodModel = db.mongoose.model('prodModel', prodSchema);

module.exports = { prodModel, catModel };
