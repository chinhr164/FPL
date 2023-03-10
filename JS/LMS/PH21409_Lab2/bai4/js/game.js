var x, a;

// Sinh số bí mật ngẫu nhiên
function soBiMat() {
    x = 10 + Math.round(5 * Math.random());
}

function kiemTra() {
    a = Number(prompt("Nhập số: "));
    if (a == x)
        alert("Chúc mừng bạn đã đoán đúng!!");
    else if (a > x)
        alert("Số của bạn lớn hơn số bí mật\nChúc bạn may mắn lần sau!!");
    else
        alert("Số của bạn nhỏ hơn số bí mật\nChúc bạn may mắn lần sau!!");
}

function inPhieu() {
    document.write("Số của bạn: " + a);
    document.write("<br>Sô bí mật: " + x);
    document.write("<br>------------------------");
    document.write("<h3>");
    if (a == x)
        document.write("Chúc mừng bạn đã đoán đúng!!");
    else
        document.write("Chúc bạn may mắn lần sau!!");
    document.write("</h3>");
}