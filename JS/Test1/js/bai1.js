var img = [];
var stt = 1;
var interval = null;


function load() {
    for (var i = 1; i <= 5; i++) {
        img[i] = new Image();
        img[i].src = `/img/img${i}.jpg`;
    }
}

function start() {
    interval = setInterval(function () {
        if (stt < 5)
            stt++;
        else
            stt = 1;
        document.querySelector('.container img').src = img[stt].src;
        document.querySelector('span').innerText = `${stt}/5`;

    }, 2000);
}

function stop() {
    clearInterval(interval);
}
