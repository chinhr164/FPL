const { MongoClient } = require("mongodb");
const uri =
    "mongodb+srv://chinhr164:164%40chinhR@cluster0.frwktgp.mongodb.net/?retryWrites=true";
const client = new MongoClient(uri);

async function app() {
    await client.connect();
}
const dbs = client.db("Warehouse");

module.exports = { dbs }