var hoTen, diem;
function nhap() {
    hoTen = String(prompt("Họ tên của bạn"));
    diem = Number(prompt("Điểm của bạn: "));    
}

function danhGia() {
    document.write("Họ tên: " + hoTen);
    document.write("<br>Điểm: " + diem);
    document.write("<br>------------------");
    document.write("<h3>");
    document.write("> Kết quả: ");
    if (diem < 5)
        document.write("Rớt");
    else
        document.write("Đậu");
}