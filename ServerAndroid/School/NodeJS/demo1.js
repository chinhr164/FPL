// $('head').append('<meta charset="UTF-8">');

const http = require('http');

var server = http.createServer((req, res) => {
    res.writeHead(200, "Connect successful!",
        {
            'Content-Type': 'text/html',
            'abc': 'xyz'
        })
    res.write("Xin chào <br> Chinhr")
});

server.listen(8080, 'localhost', (err) => {
    if (err)
        console.log(err);
    else
        console.log("Server running http://localhost:8080");
})
