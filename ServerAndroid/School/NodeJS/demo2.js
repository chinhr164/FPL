var http = require('http');
var server = http.createServer((req, res) => {
    //tương tác route
    // console.log("url: " + req.url);
    switch (req.url) {
        case '/':
            home(req, res);
            break;

        case '/gioithieu.html':
            about(req, res);
            break;

        default:
            res.writeHead(404, "URL ERROR")
            res.end()
            break;
    }
});

const home = (req, res) => {
    res.writeHead(200, {
        'Content-Type': 'text/html'
    });

    res.write("<meta charset='utf-8' />  <h2>Trang home</h2>");
    res.end();
}


const about = (req, res) => {
    res.writeHead(200, {
        'Content-Type': 'text/html'
    });

    res.write("<meta charset='utf-8' />  <h2>Trang giới thiệu</h2>");
    res.end();
}

server.listen(8080, 'localhost', (err) => {
    if (err)
        console.log(err);
    else
        console.log("Server running http://localhost:8080/");
})