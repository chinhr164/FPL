// $('head').append('<meta charset="UTF-8">');

const http = require('http');
const fs = require('fs');

var server = http.createServer((req, res) => {
    res.writeHead(200, "Connect successful!",
        {
            'Content-Type': 'text/html',
            'abc': 'xyz'
        })
    //chỉnh sử code
    switch (req.url) {
        case '/logo.png':
            //đọc file ở đây
            fs.readFile('./poly.png'), (err, data) => {
                if (err)
                    throw err;
                console.log(data);
                res.writeHead(200, "Connect successful!",
                    {
                        'Content-Type': 'image/png',
                    })
                return res.end(data)
            }
            break;

        default:
            res.writeHead(200, "Connect successful!",
                {
                    'Content-Type': 'text/html',
                    'abc': 'xyz'
                })
            res.write('Content Website');
            res.end();
            break;
    }

    res.end();
});

server.listen(8080, 'localhost', (err) => {
    if (err)
        console.log(err);
    else
        console.log("Server running http://localhost:8080");
})
