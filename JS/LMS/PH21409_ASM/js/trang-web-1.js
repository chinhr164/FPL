var anhR = [];
var STT = 0;

function loadAnh() {
    for (var i = 0; i < 20; i++) {
        anhR[i] = new Image();
        anhR[i].src = "../img/img" + i + ".jpg";
    }
    document.getElementById("scroll").innerText ="Ảnh  "+ (STT + 1) +"/20";
}

function back() {
    if (STT > 0)
        STT--;
    else
        STT = 19;
    document.getElementById("anh").src = anhR[STT].src;
    document.getElementById("scroll").innerText ="Ảnh  "+ (STT + 1) +"/20";
}

function next() {
    if (STT < 19)
        STT++;
    else
        STT = 0;
    document.getElementById("anh").src = anhR[STT].src;
    document.getElementById("scroll").innerText ="Ảnh  "+ (STT + 1) +"/20";
}

setInterval("next()",2000);
