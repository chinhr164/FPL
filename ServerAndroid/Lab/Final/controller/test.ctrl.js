const db = require('../models/db');

exports.test = async (req, res, next) => {
    const coll = db.dbs.collection("test"); //Trỏ đến collection mà chúng ta tương tác

    const demoDATA = {
        name: "Hiếu",
        age: 21
    }

    try {
        await coll.insertOne(demoDATA);
    } catch (err) {
        console.error(err);
    }

    try {
        const listT = await coll.find();
        await listT.forEach(data => {
            console.log(`${data.name} - ${data.age}`);
        });
    } catch (error) {
        console.error(error);
    }

    res.render('test')
}


