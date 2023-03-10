var sv = new Object();
sv.hoTen, sv.diem;

function nhap() {
    sv.hoTen = prompt("Họ tên sinh viên");
    sv.diem = Number(prompt("Điểm"));

    document.write("Họ tên: " + sv.hoTen);
    document.write("<br>Điểm: " + sv.diem);
}

sv.hienthi = function () {
    if (this.diem >= 5)
        this.hocLuc = "Đậu";
    else
        this.hocLuc = "Rớt";
    document.write("<h4>THÔNG TIN SINH VIÊN</h4>");
    document.write("Họ tên: " + this.hoTen);
    document.write("<br>Điểm: " + this.diem);
    document.write("<br><br><b>Học lực: "+this.hocLuc);
    document.write("</b>");
}


