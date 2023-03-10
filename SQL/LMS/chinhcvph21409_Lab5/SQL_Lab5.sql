CREATE DATABASE QUANLYBANHANG
GO

USE QUANLYBANHANG
GO

CREATE TABLE KHACHHANG
(
    MAKHACHHANG VARCHAR(5) PRIMARY KEY,
    HOVATENLOT  NVARCHAR(50)  NOT NULL,
    TEN         NVARCHAR(50)  NOT NULL,
    DIACHI      NVARCHAR(255) NOT NULL,
    EMAIL       VARCHAR(50)   NOT NULL,
    DIENTHOAI   VARCHAR(10)   NOT NULL
)
GO

CREATE TABLE SANPHAM
(
    MASANPHAM  INT IDENTITY (1,1) PRIMARY KEY,
    TENSANPHAM NVARCHAR(50)  NOT NULL,
    MOTA       NVARCHAR(255) NOT NULL,
    SOLUONG    INT CHECK (SOLUONG >= 0),
    DONGIA     MONEY CHECK (DONGIA >= 0)
)
GO

CREATE TABLE HOADON
(
    MAHOADON     INT PRIMARY KEY,
    NGAYMUAHHANG DATE         NOT NULL,
    MAKHACHHANG  VARCHAR(5)   NOT NULL,
    TRANGTHAI    NVARCHAR(30) NOT NULL,
    FOREIGN KEY (MAKHACHHANG) REFERENCES KHACHHANG
)
GO

CREATE TABLE HOADONCHITIET
(
    MAHOADONCHITIET INT IDENTITY (1,1) PRIMARY KEY,
    MAHOADON        INT NOT NULL,
    MASANPHAM       INT NOT NULL,
    SOLUONG         INT NOT NULL,
    FOREIGN KEY (MAHOADON) REFERENCES HOADON,
    FOREIGN KEY (MASANPHAM) REFERENCES SANPHAM
)
GO

-- Nhập dữ liệu bảng Khách hàng
INSERT INTO KHACHHANG(MAKHACHHANG, HOVATENLOT, TEN, DIACHI, EMAIL, DIENTHOAI)
VALUES ('KH001', N'Cao Văn', N'Chỉnh', N'Hạ Mỗ, Đan Phượng, Hà Nội', 'chinh@fpt.edu.vn', '0338878397');
INSERT INTO KHACHHANG(MAKHACHHANG, HOVATENLOT, TEN, DIACHI, EMAIL, DIENTHOAI)
VALUES ('KH002', N'Ngô Trung', N'Hiếu', N'xã Đại Hợp, huyện Kiến Thụy, TP Hải Phòng', 'hieunt@fpt.edu.vn',
        '0339731812');
INSERT INTO KHACHHANG(MAKHACHHANG, HOVATENLOT, TEN, DIACHI, EMAIL, DIENTHOAI)
VALUES ('KH003', N'Đỗ Xuân', N'Hiếu', N'Nhật Tiến, xã Trường Yên, Chương Mỹ, Hà Nội', 'hieudx@fpt.edu.vn',
        '0973967774');
INSERT INTO KHACHHANG(MAKHACHHANG, HOVATENLOT, TEN, DIACHI, EMAIL, DIENTHOAI)
VALUES ('KH004', N'Đinh Viết', N'Khang', N'xã Yên Hợp, Quỳ Hợp, Nghệ An', 'khangdv@fpt.edu.vn', '0338269641');
INSERT INTO KHACHHANG(MAKHACHHANG, HOVATENLOT, TEN, DIACHI, EMAIL, DIENTHOAI)
VALUES ('KH005', N'Hà Thị', N'Ngọc Hải', N'Hạ Đình, Thanh Xuân, Hà Nội', 'haihtn@fpt.edu.vn', '0941889768');
GO

-- Nhập dữ liệu bảng Sản phẩm
INSERT INTO SANPHAM(TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột Bakers Choice số 13 ( Bột làm bánh mỳ) - 1kg',
        N'Bột có hàm lượng protein cao 13 %, thường dùng chủ yếu để làm bảnh mì hay đế bánh pizzza', 254, 28000);
INSERT INTO SANPHAM(TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột Bakers Choice số 8 ( Bột bánh Bông lan) - 1kg',
        N'Được làm từ lúa mì có hàm lượng gluten thấp (7.5 - 9%), được dùng làm các loại bánh ngọt có độ xốp nở', 136,
        28000);
INSERT INTO SANPHAM(TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột Bakers Choice số 11 ( bột mì đa dụng ) - 1kg',
        N'Có hàm lượng protein khoảng 10-12%, được dùng để làm các loạị bánh ngọt như gato hay gatuxe...', 356, 28000);
INSERT INTO SANPHAM(TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột mỳ Meizan 500g', N'Loại bột mì đa dụng dùng trong làm bánh cupcake hay bánh ngọt', 421, 12000);
INSERT INTO SANPHAM(TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT INSERTED.MASANPHAM
VALUES (N'Bột mỳ hoa ngọc lan 1kg',
        N'Hàm lượng protein (10-11%), VitaminB1. Thường dùng làm các loại bánh như bánh mỳ, bánh gatom bánh Trung thu...',
        124, 22000);
GO

-- Nhập dữ liệu bảng Hoá đơn
INSERT INTO HOADON(MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (111, '2021-11-30', 'KH001', N'Đã thanh toán');
INSERT INTO HOADON(MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (222, '2021-12-31', 'KH002', N'Đã thanh toán');
INSERT INTO HOADON(MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (333, '2022-01-09', 'KH003', N'Đã thanh toán');
INSERT INTO HOADON(MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (444, '2022-01-10', 'KH004', N'Chưa thanh toán');
INSERT INTO HOADON(MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES (555, '2022-01-11', 'KH005', N'Chưa thanh toán');
GO

-- Nhập dữ liệu bảng Hoá đơn chi tiết
INSERT INTO HOADONCHITIET(MAHOADON, MASANPHAM, SOLUONG)
OUTPUT INSERTED.MAHOADONCHITIET
VALUES (111, 1, 10);
INSERT INTO HOADONCHITIET(MAHOADON, MASANPHAM, SOLUONG)
OUTPUT INSERTED.MAHOADONCHITIET
VALUES (222, 3, 20);
INSERT INTO HOADONCHITIET(MAHOADON, MASANPHAM, SOLUONG)
OUTPUT INSERTED.MAHOADONCHITIET
VALUES (333, 2, 5);
INSERT INTO HOADONCHITIET(MAHOADON, MASANPHAM, SOLUONG)
OUTPUT INSERTED.MAHOADONCHITIET
VALUES (444, 1, 20);
INSERT INTO HOADONCHITIET(MAHOADON, MASANPHAM, SOLUONG)
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


-- <> Bài 1 LAB 5
USE QUANLYBANHANG
-- Hiển thị tất cả thông tin có trong bảng khách hàng bao gồm tất cả các cột
SELECT *
FROM KHACHHANG

-- hiển thị 10 khách hàng đầu tiên trong bảng khách hàng bao gồm các cột:
-- mã khách hàng, họ và tên, email, số điện thoại
SELECT TOP 10 MAKHACHHANG, HOVATENLOT + ' ' + TEN AS 'Họ và tên', EMAIL, DIENTHOAI
FROM KHACHHANG

-- Hiển thị thông tin từ bảng Sản phẩm gồm các cột:
-- mã sản phẩm, tên sản phẩm, tổng tiền tồn kho.
-- Với tổng tiền tồn kho = đơn giá* số lượng
SELECT MASANPHAM, TENSANPHAM, DONGIA * SOLUONG AS 'Tổng tiền tồn kho'
FROM SANPHAM

-- Hiển thị danh sách khách hàng có tên bắt đầu bởi kí tự ‘H’ gồm các cột:
-- maKhachHang, hoVaTen, diaChi. Trong đó cột hoVaTen ghép từ 2 cột hoVaTenLot và Ten
SELECT MAKHACHHANG, HOVATENLOT + ' ' + TEN AS 'Họ và tên', DIACHI
FROM KHACHHANG
WHERE TEN LIKE 'H%'

-- Hiển thị tất cả thông tin các cột của khách hàng có địa chỉ chứa chuỗi ‘Đà Nẵng'
SELECT *
FROM KHACHHANG
WHERE DIACHI LIKE N'Đà Nẵng'

-- Hiển thị các sản phẩm có số lượng nằm trong khoảng từ 100 đến 500
SELECT *
FROM SANPHAM
WHERE SOLUONG BETWEEN 100 AND 500

-- Hiển thị danh sách các hoá hơn có trạng thái là chưa thanh toán và ngày mua hàng trong năm 2016
SELECT *
FROM HOADON
WHERE TRANGTHAI LIKE N'Chưa thanh toán'
  AND YEAR(NGAYMUAHHANG) <= 2016

-- Hiển thị các hoá đơn có mã Khách hàng thuộc 1 trong 3 mã sau: KH001, KH003, KH006
SELECT *
FROM KHACHHANG
WHERE MAKHACHHANG
   OR ('KH001', 'KH003', 'KH006')


-- <> Bài 2 LAB 5
USE QUANLYBANHANG
-- Hiển thị số lượng khách hàng có trong bảng khách hàng
SELECT COUNT(*) AS 'Số lượng'
FROM KHACHHANG

-- Hiển thị đơn giá lớn nhất trong bảng SanPham
SELECT MAX(DONGIA) AS 'Đơn giá lớn nhất'
FROM SANPHAM

-- Hiển thị số lượng sản phẩm thấp nhất trong bảng sản phẩm
SELECT MIN(SOLUONG) AS 'Số lượng sản phẩm thấp nhất'
FROM SANPHAM

-- Hiển thị tổng tất cả số lượng sản phẩm có trong bảng sản phẩm
SELECT SUM(SOLUONG) AS 'Tổng số lượng'
FROM SANPHAM

-- Hiển thị số hoá đơn đã xuất trong tháng 12/2016 mà có trạng thái chưa thanh toán
SELECT COUNT(*) AS 'Số hóa đơn'
FROM HOADON
WHERE YEAR(NGAYMUAHHANG) = 2016
  AND MONTH(NGAYMUAHHANG) = 12
  AND TRANGTHAI LIKE N'Chưa thanh toán'

-- Hiển thị mã hoá đơn và số loại sản phẩm được mua trong từng hoá đơn.
SELECT MAHOADON, COUNT(*) AS 'SO LUONG'
FROM HOADONCHITIET
GROUP BY MAHOADON

-- Hiển thị mã hoá đơn và số loại sản phẩm được mua trong từng hoá đơn.
-- Yêu cầu chỉ hiển thị hàng nào có số loại sản phẩm được mua >=5.
SELECT MAHOADON, COUNT(*) AS 'SO LUONG'
FROM HOADONCHITIET
GROUP BY MAHOADON
HAVING COUNT(*) >= 5

-- Hiển thị thông tin bảng HoaDon gồm các cột
-- maHoaDon, ngayMuaHang,maKhachHang.
-- Sắp xếp theo thứ tự giảm dần của ngayMuaHang
SELECT MAHOADON, NGAYMUAHHANG, MAKHACHHANG
FROM HOADON
ORDER BY NGAYMUAHHANG DESC