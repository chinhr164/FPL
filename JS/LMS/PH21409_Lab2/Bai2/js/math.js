// Khởi tạo giá trị
var x = prompt("Giá trị của bạn: ");

// Kiểm tra giá trị
if (isNaN(x) == false) {
    alert(x + " là một số");
    // Tính toán giá trị
    var a = Math.sqrt(x);
    var b = Math.pow(x, 2);
    var c = Math.round(x);
    document.write("Giá trị của bạn: " + x);
    document.write("<br>");
    document.write("<br><h3> > Giá trị căn bậc 2: ");
    if (x <= 0)
        document.write("Không tồn tại căn bậc 2.");
    else
        document.write(a);
    document.write("<br> > Giá trị bình phương: " + b);
    document.write("<br> > Giá trị làm tròn: " + c);
    document.write("</h3>");
} else {
    alert(x + " không phải là một số");
}