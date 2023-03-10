function ptb2() {
    //Khởi tạo giá trị
    var a = Number(prompt("Nhập a"));
    var b = Number(prompt("Nhập b"));
    var c = Number(prompt("Nhập c"));

    // PTB2
    if (a == 0) {
        if (b == 0) {
            if (c == 0)
                alert("PT vô số nghiệm");
            else
                alert("PT vô nghiệm");
        } else {
            alert("PT có nghiệm x = " + (-c / b));
        }
    } else {
        var delta = Math.pow(b, 2) - 4 * a * c;
        console.log(delta);
        if (delta < 0)
            alert("PT vô nghiệm");
        else if (delta == 0)
            alert("PT có nghiệm kép x1 = x2 = " + (-b / (2 * a)));
        else {
            alert("PT có 2 nghiệm phân biệt:\nx1 = " + ((-b + Math.sqrt(delta)) / (2 * a)) + "\nx2 = " + ((-b - Math.sqrt(delta)) / (2 * a)));
        }
    }
}