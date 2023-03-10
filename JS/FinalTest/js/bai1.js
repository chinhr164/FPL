var img = [];
var stt = 1;

function load() {
    for (var i = 1; i <= 5; i++) {
        img[i] = new Image();
        img[i].src = `/img/img${i}.jpg`
    }
}

function prev() {
        if (stt > 1)
            stt--;
        else
            stt = 5;
        document.querySelector('img').src = img[stt].src;
        document.querySelector('span').innerText = `${stt}/5`
}

function next() {
    if (stt < 5)
        stt++;
    else
        stt = 1;
    document.querySelector('img').src = img[stt].src;
    document.querySelector('span').innerText = `${stt}/5`
}

setInterval("next()",1500);