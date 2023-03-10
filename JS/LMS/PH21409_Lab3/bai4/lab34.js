var a = null, b = null, o = null, c = "", dem=0;

function toanHang(x) {
    if (o == null)
        a = a * 10 + x;
    else
        b = b * 10 + x;
    hienThi(x);
}

function toanTu(x) {
    o = x;
    dem++;
    hienThi(x);
}

function lamLai() {
    a = null, b = null, o = null, c = "";
}

function hienThi(x) {
    if ((x != null) && (x != "ok"))
        if (x == '+' || x == '-' || x == ':' || x == 'x')
            c += " " + x + " ";
        else
            c += x;
    document.getElementById("hienthi").value = c;
}

function tinhToan() {
    switch (o) {
        case '+':
            c = a + b;
            break;

        case '-':
            c = a - b;
            break;

        case 'x':
            c = a * b;
            break;

        case ':':
            c = a / b;
            break;
    }
    hienThi("ok");
    lamLai();
}