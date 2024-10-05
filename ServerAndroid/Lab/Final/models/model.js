const { Collection } = require('mongoose');
var db = require('./db');

/* Staff */
const staffSchema = new db.mongoose.Schema(
    //Định nghĩa cấu trúc của model
    {
        staffID: {
            type: String,
            required: true
        },
        fullname: {
            type: String,
            required: true
        },
        username: {
            type: String,
            required: true
        },
        password: {
            type: String,
            required: true
        },
        role: {
            type: String,
            required: true
        },
        outlet: {
            type: db.mongoose.Schema.Types.ObjectId, ref: 'outModel',
            required: true
        },
        tel: {
            type: String,
        },
        email: {
            type: String,
            required: true
        }
    }, { collection: 'staff' }
);


/* Outlet */
const outSchema = new db.mongoose.Schema(
    //Định nghĩa cấu trúc của model
    {
        outletID: {
            type: String,
            required: true
        },
        name: {
            type: String,
            required: true
        },
        openingDate: {
            type: String,
            required: true
        },
        tel: {
            type: String,
            required: true
        },
        address: {
            type: String,
            required: true
        }
    }, { collection: 'outlet' }
);


/* Role */
const roleSchema = new db.mongoose.Schema(
    //Định nghĩa cấu trúc của model
    {
        name: {
            type: String,
            required: true
        },
        creationDate: {
            type: String,
            required: true
        }
    }, { collection: 'role' }
);

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
            type: db.mongoose.Schema.Types.ObjectId, ref: 'catModel',
            required: true
        },
        price: {
            type: Number,
            required: true
        },
        qty: {
            type: Number,
            required: true
        },
        img: {
            type: String,
            required: true
        },
        description: {
            type: String,
            required: true
        }
    }, { collection: 'product' }
);

const catSchema = new db.mongoose.Schema(
    //Định nghĩa cấu trúc của model
    {
        name: {
            type: String,
            required: true
        },
        creationDate: {
            type: String,
            required: true
        }
    }, { collection: 'category' }
);
const testSchema = new db.mongoose.Schema(
    //Định nghĩa cấu trúc của model
    {
        name: {
            type: String
        },
        age: {
            type: Number
        }
    }, { collection: 'test' }
);

//Tạo model
let staffModel = db.mongoose.model('staffModel', staffSchema);
let outModel = db.mongoose.model('outModel', outSchema);
let roleModel = db.mongoose.model('roleModel', roleSchema);
let prodModel = db.mongoose.model('prodModel', prodSchema);
let catModel = db.mongoose.model('catModel', catSchema);
let testModel = db.mongoose.model('testModel', testSchema);


module.exports = { staffModel, outModel, roleModel, prodModel, catModel, testModel };
