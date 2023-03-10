﻿CREATE DATABASE QUANLYBANHANG
GO

USE QUANLYBANHANG

CREATE TABLE KHACHHANG
(
    MAKHACHHANG VARCHAR(5) PRIMARY KEY,
    HOVATENLOT NVARCHAR(50) NOT NULL,
    TEN NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(255) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    DIENTHOAI VARCHAR(10) NOT NULL
)
GO

CREATE TABLE SANPHAM
(
    MASANPHAM INT IDENTITY (1,1) PRIMARY KEY,
    TENSANPHAM NVARCHAR(50) NOT NULL,
    MOTA NVARCHAR(255) NOT NULL,
    SOLUONG INT CHECK (SOLUONG >= 0),
    DONGIA MONEY CHECK (DONGIA >= 0)
)
GO

CREATE TABLE HOADON
(
    MAHOADON INT PRIMARY KEY,
    NGAYMUAHHANG DATE NOT NULL,
    MAKHACHHANG VARCHAR(5) NOT NULL,
    TRANGTHAI NVARCHAR(30) NOT NULL,
    FOREIGN KEY (MAKHACHHANG) REFERENCES KHACHHANG
)
GO

CREATE TABLE HOADONCHITIET
(
    MAHOADONCHITIET INT IDENTITY (1,1) PRIMARY KEY,
    MAHOADON INT NOT NULL,
    MASANPHAM INT NOT NULL,
    SOLUONG INT NOT NULL,
    FOREIGN KEY (MAHOADON) REFERENCES HOADON,
    FOREIGN KEY (MASANPHAM) REFERENCES SANPHAM
)
GO

-- Bài 1 \\ LAB7
-- Nhập dữ liệu bảng khách hàng
INSERT INTO KHACHHANG
    (MAKHACHHANG, HOVATENLOT, TEN, DIACHI, EMAIL, DIENTHOAI)
VALUES
    ('KH001', N'Nguyễn Thị', N'Nga', N'15 Quang Trung, TP Đà Nẵng', 'ngant@gmail.com', '0912345670'),
    ('KH002', N'Trần Công', N'Thành', N'234 Lê Lợi, Quảng Nam', 'thanhtc@gmail.com', '0942344316'),
    ('KH003', N'Lê Hoàng', N'Nam', N'23 Trần Phú, TP Huế', 'namlt@yahoo.com', '0989354556'),
    ('KH004', N'Vũ Ngọc', N'Hiền', N'37 Nguyễn Thị Thâp, TP Đà Nẵng', 'hienvn@gmail.com', '0894545435');
GO

-- Nhập dữ liệu bảng sản phẩm
DBCC CHECKIDENT(SANPHAM, RESEED, 0)
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT
Inserted.MASANPHAM
VALUES(N'Samsung Galaxy J7 Pro', N'Samsung Galaxy J7 Pro là một chiếc smartphone phù hợp với những người yêu thích một sản phẩm pin tốt,
thích hệ điều hành mới cùng những tính năng đi kèm độc quyền', 800, 6600000);
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT
Inserted.MASANPHAM
VALUES(N'iPhone 6 32GB', N'iPhone 6 là một trong những smartphone được yêu thích nhất. 
Lắng nghe nhu cầu về thiết kế, khả năng lưu trữ và giá cả, 
iPhone 6 32GB được chính thức phân phối chính hãng tại Việt Nam 
hứa hẹn sẽ là một sản phẩm rất "Hot"', 500, 8990000);
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT
Inserted.MASANPHAM
VALUES(N'Laptop Dell Inspiron 3467', N'Dell Inspiron 3467 i3 7100U/4GB/1TB/Win10/(M20NR21)', 507, 11290000);
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT
Inserted.MASANPHAM
VALUES(N'Pin sạc dự phòng', N'Pin sạc dự phòng Polymer 5.000 mAh eSaver JP85', 600, 200000);
INSERT INTO SANPHAM
    (TENSANPHAM, MOTA, SOLUONG, DONGIA)
OUTPUT
Inserted.MASANPHAM
VALUES(N'Nokia 3100', N'Nokia 3100 phù hợp với SINH VIÊN', 100, 700000);
GO

-- Nhập dữ liệu bảng hóa đơn
INSERT INTO HOADON
    (MAHOADON, NGAYMUAHHANG, MAKHACHHANG, TRANGTHAI)
VALUES
    (120954, '2016-03-23', 'KH001', N'Đã thanh toán'),
    (120955, '2016-04-02', 'KH002', N'Đã thanh toán'),
    (120956, '2016-07-12', 'KH003', N'chưa thanh toán'),
    (125957, '2016-12-04', 'KH004', N'chưa thanh toán')
GO

-- Nhập dữ liệu bảng Hóa đơn chi tiết
DBCC CHECKIDENT(HOADONCHITIET, RESEED, 0)
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT
Inserted.MAHOADONCHITIET
VALUES(120954, 3, 40)
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT
Inserted.MAHOADONCHITIET
VALUES(120954, 1, 20)
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT
Inserted.MAHOADONCHITIET
VALUES(120955, 2, 100)
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT
Inserted.MAHOADONCHITIET
VALUES(120956, 4, 6)
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT
Inserted.MAHOADONCHITIET
VALUES(120956, 2, 60)
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT
Inserted.MAHOADONCHITIET
VALUES(120956, 1, 10)
INSERT INTO HOADONCHITIET
    (MAHOADON, MASANPHAM, SOLUONG)
OUTPUT
Inserted.MAHOADONCHITIET
VALUES(125957, 2, 50)
GO

SELECT *
FROM KHACHHANG
SELECT *
FROM SANPHAM
SELECT *
FROM HOADON
SELECT *
FROM HOADONCHITIET

-- Tạo 1 bảng có tên KhachHang_daNang chứa thông tin tin đầy đủ về các khách hàng đến từ Đà Nẵng (sử dụng SELECT INTO)
SELECT *
INTO Khachhang_daNang
FROM KHACHHANG
WHERE DIACHI LIKE N'%Đà Nẵng%'

SELECT *
FROM Khachhang_daNang


-- Bài 2 \\ LAB 7 
-- Cập nhật lại thông tin số điện thoại của khách hàng có mã ‘KH002’ có giá trị mới là ‘16267788989’
UPDATE KHACHHANG
SET DIENTHOAI = '16267788989'
WHERE MAKHACHHANG = 'KH002'

-- Tăng số lượng mặt hàng có mã ‘3’ lên thêm ‘200’ đơn vị
UPDATE SANPHAM
SET SOLUONG = SOLUONG + 200
WHERE MASANPHAM = 3

-- Giảm giá cho tất cả sản phẩm giảm 5%
UPDATE SANPHAM
SET DONGIA = DONGIA * 0.95

-- Tăng số lượng của mặt hàng bán chạy nhất trong tháng 12/2016 lên 100 đơn vị
UPDATE SANPHAM
SET SOLUONG = SOLUONG + 100
WHERE MASANPHAM = (
    SELECT TOP 1
    MASANPHAM
FROM HOADONCHITIET
    INNER JOIN HOADON H ON H.MAHOADON = HOADONCHITIET.MAHOADON
WHERE YEAR(NGAYMUAHHANG) = 2016
    AND MONTH(NGAYMUAHHANG) = 12
ORDER BY HOADONCHITIET.SOLUONG DESC
)

-- Giảm giá 10% cho 2 sản phẩm bán ít nhất trong năm 2016
UPDATE SANPHAM
SET DONGIA = DONGIA * 0.9
WHERE MASANPHAM = (
    SELECT TOP 2
    MASANPHAM
FROM HOADONCHITIET
    INNER JOIN HOADON H ON H.MAHOADON = HOADONCHITIET.MAHOADON
WHERE YEAR(NGAYMUAHHANG) = 2016
ORDER BY HOADONCHITIET.SOLUONG
)

-- Cập nhật lại trạng thái “đã thanh toán” cho hoá đơn có mã 120956
UPDATE HOADON
SET TRANGTHAI = N'Đã thanh toán'
WHERE MAHOADON = 120956

-- Xoá mặt hàng có mã sản phẩm là ‘2’ ra khỏi hoá đơn ‘120956’ và trạng thái là chưa thanh toán.
DELETE
FROM HOADONCHITIET
WHERE MASANPHAM = 2
    AND MAHOADON = (
    SELECT MAHOADON
    FROM HOADON
    WHERE HOADON.MAHOADON = 120956
        AND TRANGTHAI LIKE N'chưa thanh toán'
)

-- Xoá khách hàng chưa từng mua hàng kể từ ngày “1-1-2016”
DELETE
FROM KHACHHANG
WHERE MAKHACHHANG NOT IN (
    SELECT MAKHACHHANG
FROM HOADON
WHERE NGAYMUAHHANG >= '2016-1-1'
)