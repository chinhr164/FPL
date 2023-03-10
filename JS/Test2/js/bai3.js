var img = [];
var stt = 1;
var interval = null;

function load() {
    for (var i = 1; i <= 5; i++) {
        img[i] = new Image();
        img[i].src = `/img/img${i}.jpg`
    }
}

function next() {
    if (stt < 5)
        stt++;
    else
        stt = 1;
    document.querySelector('img').src = img[stt].src;
    document.querySelector('span').innerText = `${stt}/5`
}

function prev() {
    if (stt > 1)
        stt--;
    else
        stt = 5;
    document.querySelector('img').src = img[stt].src;
    document.querySelector('span').innerText = `${stt}/5`
}

function start() {
    interval = setInterval("next()", 2000);
}

function stop() {
    clearInterval(interval);
    interval = null;
}