var a, b, o, x;

function nhap() {
    a = Number(prompt("Toán hạng a: "));
    b = Number(prompt("Toán hạng b: "));
    o = prompt("Toán tử: ");
    document.write("a = " + a);
    document.write("<br>b = " + b);
}

function tinhToan() {
    document.write("<b>");
    switch (o) {
        case '+':
            x = a + b;
            document.write("<br>Tổng: " + x);
            break;
        case '-':
            x = a - b;
            document.write("<br>Hiệu: " + x);
            break;
        case '*':
            x = a * b;
            document.write("<br>Tích: " + x);
            break;
        case '/':
            if (b == 0)
                document.write("<br>Không tồn tại do b = 0");
            else {
                x = a + b;
                document.write("<br>Tổng: " + x);
                break;
            }
        default: document.write(o < br > + " không phải là toán tử");
    }
    document.write("</b>");
}