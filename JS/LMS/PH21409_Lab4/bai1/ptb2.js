var ptb2 = new Object();
ptb2.a, ptb2.b, ptb2.c;

function nhap() {
    ptb2.a = Number(prompt("Hệ số a"));
    ptb2.b = Number(prompt("Hệ số b"));
    ptb2.c = Number(prompt("Hệ số c"));

    document.write("a = " + ptb2.a);
    document.write("<br>b = " + ptb2.b);
    document.write("<br>c = " + ptb2.c);
    document.write("<br>");
}


ptb2.giai = function () {
    document.write("a = " + ptb2.a);
    document.write("<br>b = " + ptb2.b);
    document.write("<br>c = " + ptb2.c);
    document.write("<br><b>");
    if (ptb2.a == 0) {
        if (ptb2.b == 0) {
            if (ptb2.c == 0)
                document.write("<br>PT vô số nghiệm");
            else
                document.write("<br>PT vô nghiệm");
        } else {
            document.write("<br>PT có nghiệm x = " + (-ptb2.c / ptb2.b));
        }
    } else {
        var delta = Math.pow(ptb2.b, 2) - 4 * ptb2.a * ptb2.c;
        console.log(delta);
        if (delta < 0)
            document.write("<br>PT vô nghiệm");
        else if (delta == 0)
            document.write("<br>PT có nghiệm kép x1 = x2 = " + (-ptb2.b / (2 * ptb2.a)));
        else {
            document.write("<br>PT có 2 nghiệm phân biệt:x1 = " + ((-ptb2.b + Math.sqrt(delta)) / (2 * ptb2.a)) + " ; x2 = " + ((-ptb2.b - Math.sqrt(delta)) / (2 * ptb2.a)));
        }
    }
    document.write("</b>");
}