const http = require("http");
const fs = require("fs");
const { join } = require("path");
server = http.createServer((req, res) => {
  console.log(req.url);
  if (req.url == "/") {
    // Load file index.html
    fs.readFile(req.url.substring(1) + "index.html", (err, data) => {
      if (err) {
        res.writeHead(404, { "Content-type": "text/css" });
        return res.end();
      }

      if (req.url.indexOf(".css") > 0)
        res.writeHead(200, "OK", { "Content-type": "text/css" });
      else res.writeHead(200, "OK", { "Content-type": "text/html" });
      res.write(data.toString("utf8"));
      return res.end();
    });
  } else {
    // đọc file bất kỳ theo tên file được truyền trên url
    // console.log(req.url);
    // đọc file.VD:  url =  /a.html ==> req.url.substring(1) --> lấy tên file từ ký tự thứ 1 đến hết
    // if (req.url.indexOf("index.html") > 0){
    //     console.log(123);
    //     fs.readFile("index.html", (err, data) => {
    //         if (err) {
    //           res.writeHead(404, { "Content-type": "text/css" });
    //           return res.end();
    //         }
      
    //         if (req.url.indexOf(".css") > 0)
    //           res.writeHead(200, "OK", { "Content-type": "text/css" });
    //         else res.writeHead(200, "OK", { "Content-type": "text/html" });
    //         res.write(data.toString("utf8"));
    //         return res.end();
    //       });
    // }
    let file = req.url.substring(1)
    fs.readFile(file, (err, data) => {
      if (err) {
        res.writeHead(404, { "Content-type": "text/html" });
        return res.end();
      }

      if (req.url.indexOf(".css") > 0)
        res.writeHead(200, "OK", { "Content-type": "text/css" });
      else res.writeHead(200, "OK", { "Content-type": "text/html" });
      res.write(data.toString("utf8"));
      return res.end();
    });
  }
});

server.listen(8080, "localhost", (err) => {
  if (err) console.log(err);
  else console.log("Server running http://localhost:8080");
});
