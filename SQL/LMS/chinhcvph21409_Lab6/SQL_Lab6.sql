CREATE DATABASE QUANLYBANHANG
GO

USE QUANLYBANHANG

CREATE TABLE KHACHHANG
(
    MAKHACHHANG varchar(5) PRIMARY KEY,
    HOVATENLOT  nvarchar(50)  NOT NULL,
    TEN         nvarchar(50)  NOT NULL,
    DIACHI      nvarchar(255) NOT NULL,
    EMAIL       varchar(50)   NOT NULL,
    DIENTHOAI   varchar(10)   NOT NULL
)
GO

CREATE TABLE SANPHAM
(
    MASANPHAM  int IDENTITY (1,1) PRIMARY KEY,
    TENSANPHAM nvarchar(50)  NOT NULL,
    MOTA       nvarchar(255) NOT NULL,
    SOLUONG    int CHECK (SOLUONG >= 0),
    DONGIA     money CHECK (DONGIA >= 0)
)
GO

CREATE TABLE HOADON
(
    MAHOADON     int PRIMARY KEY,
    NGAYMUAHHANG date         NOT NULL,
    MAKHACHHANG  varchar(5)   NOT NULL,
    TRANGTHAI    nvarchar(30) NOT NULL,
    FOREIGN KEY (MAKHACHHANG) REFERENCES KHACHHANG
)
GO

CREATE TABLE HOADONCHITIET
(
    MAHOADONCHITIET int IDENTITY (1,1) PRIMARY KEY,
    MAHOADON        int NOT NULL,
    MASANPHAM       int NOT NULL,
    SOLUONG         int NOT NULL,
    FOREIGN KEY (MAHOADON) REFERENCES HOADON,
    FOREIGN KEY (MASANPHAM) REFERENCES SANPHAM
)
GO

-- Nhập dữ liệu bảng Khách hàng
INSERT INTO KHACHHANG
    (MAKHACHHANG, HOVATENLOT, TEN, DIACHI, EMAIL, DIENTHOAI)
VALUES ('KH001', N'Cao Văn', N'Chỉnh', N'Hạ Mỗ, Đan Phượng, Hà Nội', 'chinh@fpt.edu.vn', '0338878397'),
       ('KH002', N'Ngô Trung', N'Hiếu', N'xã Đại Hợp, huyện Kiến Thụy, TP Hải Phòng', 'hieunt@fpt.edu.vn',
        '0339731812'),
       ('KH003', N'Đỗ Xuân', N'Hiếu', N'Nhật Tiến, xã Trường Yên, Chương Mỹ, Hà Nội', 'hieudx@fpt.edu.vn',
        '0973967774'),
       ('KH004', N'Đinh Viết', N'Khang', N'xã Yên Hợp, Quỳ Hợp, Nghệ An', 'khangdv@fpt.edu.vn', '0338269641'),
       ('KH005', N'Hà Thị', N'Ngọc Hải', N'Hạ Đình, Thanh Xuân, Hà Nội', 'haihtn@fpt.edu.vn', '0941889768');
GO

-- Nhập dữ liệu bảng Sản phẩm
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột Bakers Choice số 13 ( Bột làm bánh mỳ) - 1kg',
        N'Bột có hàm lượng protein cao 13 %, thường dùng chủ yếu để làm bảnh mì hay đế bánh pizzza', 254, 28000);
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột Bakers Choice số 8 ( Bột bánh Bông lan) - 1kg',
        N'Được làm từ lúa mì có hàm lượng gluten thấp (7.5 - 9%), được dùng làm các loại bánh ngọt có độ xốp nở', 136,
        28000);
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột Bakers Choice số 11 ( bột mì đa dụng ) - 1kg',
        N'Có hàm lượng protein khoảng 10-12%, được dùng để làm các loạị bánh ngọt như gato hay gatuxe...', 356, 28000);
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột mỳ Meizan 500g', N'Loại bột mì đa dụng dùng trong làm bánh cupcake hay bánh ngọt', 421, 12000);
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột mỳ hoa ngọc lan 1kg',
        N'Hàm lượng protein (10-11%), VitaminB1. Thường dùng làm các loại bánh như bánh mỳ, bánh gatom bánh Trung thu...',
        124, 22000);
GO
-- Nhập dữ liệu bảng Hoá đơn
INSERT INTO HOADON
    (MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (111, '2021-11-30', 'KH001', N'Đã thanh toán');
INSERT INTO HOADON
    (MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (222, '2021-12-31', 'KH002', N'Đã thanh toán');
INSERT INTO HOADON
    (MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (333, '2022-01-09', 'KH003', N'Đã thanh toán');
INSERT INTO HOADON
    (MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (444, '2022-01-10', 'KH004', N'Chưa thanh toán');
INSERT INTO HOADON
    (MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (555, '2022-01-11', 'KH005', N'Chưa thanh toán');
GO

-- Nhập dữ liệu bảng Hoá đơn chi tiết
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT INSERTED.MAHOADONCHITIET
VALUES (111, 1, 10);
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT INSERTED.MAHOADONCHITIET
VALUES (222, 3, 20);
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT INSERTED.MAHOADONCHITIET
VALUES (333, 2, 5);
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT INSERTED.MAHOADONCHITIET
VALUES (444, 1, 20);
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT INSERTED.MAHOADONCHITIET
VALUES (555, 5, 15);
GO

SELECT *
FROM KHACHHANG
SELECT *
FROM SANPHAM
SELECT *
FROM HOADON
SELECT *
FROM HOADONCHITIET


-- <> Bài 1 LAB 6
USE QUANLYBANHANG
-- Hiển thị tất cả thông tin có trong 2 bảng Hoá đơn và Hoá đơn chi tiết gồm các cột sau:
-- maHoaDon, maKhachHang, trangThai, maSanPham, soLuong, ngayMua
SELECT A.MAHOADON, MAKHACHHANG, TRANGTHAI, MASANPHAM, SOLUONG, NGAYMUAHHANG
FROM HOADON A
         INNER JOIN HOADONCHITIET B ON A.MAHOADON = B.MAHOADON

-- Hiển thị tất cả thông tin có trong 2 bảng Hoá đơn và Hoá đơn chi tiết gồm các cột sau:
-- maHoaDon, maKhachHang, trangThai, maSanPham, soLuong, ngayMua với điều kiện maKhachHang = ‘KH001’
SELECT A.MAHOADON, MAKHACHHANG, TRANGTHAI, MASANPHAM, SOLUONG, NGAYMUAHHANG
FROM HOADON A
         INNER JOIN HOADONCHITIET B ON A.MAHOADON = B.MAHOADON
WHERE MAKHACHHANG = 'KH001'

-- Hiển thị thông tin từ 3 bảng Hoá đơn, Hoá đơn chi tiết và Sản phẩm gồm các cột sau:
-- maHoaDon, ngayMua, tenSP, donGia, soLuong mua trong hoá đơn, thành tiền. Với thành tiền= donGia* soLuong
SELECT A.MAHOADON, NGAYMUAHHANG, TENSANPHAM, DONGIA, S.SOLUONG, DONGIA * A.SOLUONG AS 'Thành tiền'
FROM HOADONCHITIET A
         INNER JOIN HOADON B ON A.MAHOADON = B.MAHOADON
         INNER JOIN SANPHAM S ON S.MASANPHAM = A.MASANPHAM
;

-- Hiển thị thông tin từ bảng khách hàng, bảng hoá đơn, hoá đơn chi tiết gồm các cột:
-- họ và tên khách hàng, email, điện thoại, mã hoá đơn, trạng thái hoá đơn và tổng tiền đã mua trong hoá đơn.
-- Chỉ hiển thị thông tin các hoá đơn chưa thanh toán.
SELECT HOVATENLOT + ' ' + TEN              AS 'Họ và tên', EMAIL, DIENTHOAI, HOADON.MAHOADON, TRANGTHAI,
       SUM(DONGIA * HOADONCHITIET.SOLUONG) AS 'Tổng tiền'
FROM HOADON
         INNER JOIN KHACHHANG ON KHACHHANG.MAKHACHHANG = HOADON.MAKHACHHANG
         INNER JOIN HOADONCHITIET ON HOADON.MAHOADON = HOADONCHITIET.MAHOADON
         INNER JOIN SANPHAM ON SANPHAM.MASANPHAM = HOADONCHITIET.MASANPHAM
GROUP BY HOVATENLOT, TEN, EMAIL, DIENTHOAI, TRANGTHAI, HOADON.MAHOADON
HAVING TRANGTHAI LIKE N'Chưa thanh toán'


-- Hiển thị maHoaDon, ngàyMuahang, tổng số tiền đã mua trong từng hoá đơn.
-- Chỉ hiển thị những hóa đơn có tổng số tiền >=500.000
-- và sắp xếp theo thứ tự giảm dần của cột tổng tiền
SELECT HOADONCHITIET.MAHOADON, NGAYMUAHHANG, SUM(DONGIA * HOADONCHITIET.SOLUONG) AS 'Tổng tiền'
FROM HOADONCHITIET
         INNER JOIN HOADON ON HOADON.MAHOADON = HOADONCHITIET.MAHOADON
         INNER JOIN SANPHAM ON HOADONCHITIET.MASANPHAM = SANPHAM.MASANPHAM
GROUP BY HOADONCHITIET.MAHOADON, NGAYMUAHHANG
HAVING SUM(DONGIA * HOADONCHITIET.SOLUONG) >= 500000
ORDER BY SUM(DONGIA * HOADONCHITIET.SOLUONG) DESC


-- <> Bài 2 LAB 6
USE QUANLYBANHANG
-- Hiển thị danh sách các khách hàng chưa mua hàng lần nào kể từ tháng 1/1/2016
SELECT *
FROM KHACHHANG
WHERE MAKHACHHANG NOT IN
      (SELECT MAKHACHHANG
       FROM HOADON
       WHERE NGAYMUAHHANG >= '2016-1-1')

-- Hiển thị mã sản phẩm, tên sản phẩm có lượt mua nhiều nhất trong tháng 12/2016
SELECT TOP 1 HOADONCHITIET.MASANPHAM, TENSANPHAM, COUNT(HOADONCHITIET.MASANPHAM) AS 'Số lượt mua'
FROM HOADONCHITIET
         INNER JOIN HOADON ON HOADON.MAHOADON = HOADONCHITIET.MAHOADON
         INNER JOIN SANPHAM ON SANPHAM.MASANPHAM = HOADONCHITIET.MASANPHAM
WHERE YEAR(HOADON.NGAYMUAHHANG) = 2016
  AND MONTH(HOADON.NGAYMUAHHANG) = 12
GROUP BY HOADONCHITIET.MASANPHAM, SANPHAM.TENSANPHAM
ORDER BY COUNT(HOADONCHITIET.MASANPHAM) DESC

-- Hiển thị top 5 khách hàng có tổng số tiền mua hàng nhiều nhất trong năm 2016
SELECT TOP 5 MAKHACHHANG, SUM(HOADONCHITIET.SOLUONG * DONGIA) AS 'Tổng tiền'
FROM HOADONCHITIET
         INNER JOIN HOADON ON HOADON.MAHOADON = HOADONCHITIET.MAHOADON
         INNER JOIN SANPHAM ON SANPHAM.MASANPHAM = HOADONCHITIET.MASANPHAM
WHERE YEAR(NGAYMUAHHANG) = 2016
GROUP BY MAKHACHHANG
ORDER BY SUM(HOADONCHITIET.SOLUONG * DONGIA) DESC

-- Hiển thị thông tin các khách hàng sống ở ‘Đà Nẵng’ có mua sản phẩm có tên “Iphone 7 32GB” trong tháng 12/2016
SELECT *
FROM KHACHHANG
WHERE DIACHI LIKE N'%Đà Nẵng%'
  AND MAKHACHHANG IN
      (SELECT MAKHACHHANG
       FROM HOADONCHITIET
                INNER JOIN HOADON ON HOADONCHITIET.MAHOADON = HOADON.MAHOADON
                INNER JOIN SANPHAM ON SANPHAM.MASANPHAM = HOADONCHITIET.MASANPHAM
       WHERE TENSANPHAM LIKE N'%Iphone 7 32GB%'
         AND YEAR(NGAYMUAHHANG) = 2016
         AND MONTH(NGAYMUAHHANG) = 12);

-- Hiển thị tên sản phẩm có lượt đặt mua nhỏ hơn lượt mua trung bình các các sản phẩm.
SELECT TENSANPHAM
FROM SANPHAM
WHERE MASANPHAM IN
      (SELECT MASANPHAM
       FROM HOADONCHITIET
       GROUP BY HOADONCHITIET.MASANPHAM
       HAVING COUNT(HOADONCHITIET.MASANPHAM) < (SELECT AVG(temp.luotmua)
                                                FROM (SELECT COUNT(HOADONCHITIET.MASANPHAM) AS 'luotmua'
                                                      FROM HOADONCHITIET
                                                      GROUP BY HOADONCHITIET.MASANPHAM) temp));
