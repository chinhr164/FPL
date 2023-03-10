function tinhtoan(a,b){
    var c = a + b;
    var h = a - b;
    var i = a * b;

    document.write("a = "+a);
    document.write("<br>");
    document.write("b = "+b);
    document.write("<br>--------------------");
    document.write("<h3>");
    document.write("<br>> Tổng: " + c);
    document.write("<br>> Hiệu: " + h);
    document.write("<br>> Tích: " + i);
    if(b!=0){
        var n = a/b;
        document.write("<br>> Thương: " + n);
    }else{
        document.write("<br>> Thương: Không tồn tại do b = 0");
    }
    document.write("</h3>");
}


