function GAME() {
    while (true) {
        var soNhap = Number(prompt("Nhập vào số: "));
        var SBM = Math.round(100 * Math.random());
        if (soNhap == SBM) {
            alert("Chúc mừng bạn đã đoán trúng!!!");
            document.write("Số của bạn: " + soNhap);
            document.write("<br>Sô bí mật: " + SBM);
            document.write("<br>------------------------");
            document.write("<h3>");
            if (a == x)
                document.write("Chúc mừng bạn đã đoán đúng!!");
            document.write("</h3>");
            break;
        } else if (soNhap < SBM) {
            alert("Số bạn đoán nhỏ hơn Số bí mật!!");
        } else {
            alert("Số bạn đoán lớn hơn Số bí mật!!");
        }
    }
}