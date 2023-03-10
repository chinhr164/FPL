-- CSDL-QLBH <> LAB 5
CREATE DATABASE QuanLyBanHang
GO

USE QuanLyBanHang
GO

CREATE TABLE KHACH_HANG
(
    maKhachHang VARCHAR(5) PRIMARY KEY,
    hoVaTenLot  NVARCHAR(50)  NOT NULL,
    Ten         NVARCHAR(50)  NOT NULL,
    diaChi      NVARCHAR(255) NOT NULL,
    Email       VARCHAR(50)   NOT NULL,
    dienThoai   VARCHAR(10)   NOT NULL
)
GO

CREATE TABLE SAN_PHAM
(
    maSanPham INT IDENTITY (1,1) PRIMARY KEY,
    tenSP     NVARCHAR(50)  NOT NULL,
    mota      NVARCHAR(255) NOT NULL,
    soLuong   INT CHECK (soLuong >= 0),
    donGia    MONEY CHECK (donGia >= 0)
)
GO

CREATE TABLE HOA_DON
(
    maHoaDon    INT PRIMARY KEY,
    ngayMuaHang DATE         NOT NULL,
    maKhachHang VARCHAR(5)   NOT NULL,
    trangthai   NVARCHAR(30) NOT NULL,
    FOREIGN KEY (maKhachHang) REFERENCES KHACH_HANG
)
GO

CREATE TABLE HOA_DON_CHI_TIET
(
    maHoaDonChiTiet INT IDENTITY (1,1) PRIMARY KEY,
    maHoaDon        INT NOT NULL,
    maSanPham       INT NOT NULL,
    soLuong         INT NOT NULL,
    FOREIGN KEY (maHoaDon) REFERENCES HOA_DON,
    FOREIGN KEY (maSanPham) REFERENCES SAN_PHAM
)
GO

-- Nhập dữ liệu bảng Khách hàng
INSERT INTO KHACH_HANG(maKhachHang, hoVaTenLot, Ten, diaChi, Email, dienThoai)
VALUES ('KH001', N'Cao Văn', N'Chỉnh', N'Hạ Mỗ, Đan Phượng, Hà Nội', 'chinh@fpt.edu.vn', '0338878397');
INSERT INTO KHACH_HANG(maKhachHang, hoVaTenLot, Ten, diaChi, Email, dienThoai)
VALUES ('KH002', N'Ngô Trung', N'Hiếu', N'xã Đại Hợp, huyện Kiến Thụy, TP Hải Phòng', 'hieunt@fpt.edu.vn',
        '0339731812');
INSERT INTO KHACH_HANG(maKhachHang, hoVaTenLot, Ten, diaChi, Email, dienThoai)
VALUES ('KH003', N'Đỗ Xuân', N'Hiếu', N'Nhật Tiến, xã Trường Yên, Chương Mỹ, Hà Nội', 'hieudx@fpt.edu.vn',
        '0973967774');
INSERT INTO KHACH_HANG(maKhachHang, hoVaTenLot, Ten, diaChi, Email, dienThoai)
VALUES ('KH004', N'Đinh Viết', N'Khang', N'xã Yên Hợp, Quỳ Hợp, Nghệ An', 'khangdv@fpt.edu.vn', '0338269641');
INSERT INTO KHACH_HANG(maKhachHang, hoVaTenLot, Ten, diaChi, Email, dienThoai)
VALUES ('KH005', N'Hà Thị', N'Ngọc Hải', N'Hạ Đình, Thanh Xuân, Hà Nội', 'haihtn@fpt.edu.vn', '0941889768');
GO

-- Nhập dữ liệu bảng Sản phẩm
INSERT INTO SAN_PHAM(tenSP, mota, soLuong, donGia)
OUTPUT inserted.maSanPham
VALUES (N'Hộp gato giấy 26cm', N'Đựng bánh gato, mousse, chesse cake...', 280, 9000)
INSERT INTO SAN_PHAM(tenSP, mota, soLuong, donGia)
OUTPUT inserted.maSanPham
VALUES (N'Cơm dừa đặc biệt 100g', N'Dùng để trang trí bánh, thêm vào socola...', 955, 11000)
INSERT INTO SAN_PHAM(tenSP, mota, soLuong, donGia)
OUTPUT inserted.maSanPham
VALUES (N'Men bánh mì Mauri 10g', N'Làm men cho bánh mì', 3427, 3000)
INSERT INTO SAN_PHAM(tenSP, mota, soLuong, donGia)
OUTPUT inserted.maSanPham
VALUES (N'Shortening (mỡ trừu) 200g', N'Dùng trong chế biến thực phẩm', 146, 14000)
INSERT INTO SAN_PHAM(tenSP, mota, soLuong, donGia)
OUTPUT inserted.maSanPham
VALUES (N'Dụng cụ bào sợi', N'Dùng để bào nhỏ bơ, phô mai, socola thành sợi mỏng', 31, 25000)
GO

-- Nhập dữ liệu bảng Hóa đơn
INSERT INTO HOA_DON(maHoaDon, ngayMuaHang, maKhachHang, trangthai)
VALUES (512, '2016-09-22', 'KH004', N'Đã thanh toán')
INSERT INTO HOA_DON(maHoaDon, ngayMuaHang, maKhachHang, trangthai)
VALUES (733, '2016-05-16', 'KH001', N'Chưa thanh toán')
INSERT INTO HOA_DON(maHoaDon, ngayMuaHang, maKhachHang, trangthai)
VALUES (449, '2017-05-04', 'KH002', N'Chưa thanh toán')
INSERT INTO HOA_DON(maHoaDon, ngayMuaHang, maKhachHang, trangthai)
VALUES (991, '2017-01-18', 'KH005', N'Đã thanh toán')
INSERT INTO HOA_DON(maHoaDon, ngayMuaHang, maKhachHang, trangthai)
VALUES (931, '2017-09-21', 'KH001', N'Đã thanh toán')
GO

-- Nhập dữ liệu bảng Hóa đơn chi tiết
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (512, 3, 10)
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (512, 4, 2)
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (733, 1, 5)
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (733, 2, 3)
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (449, 3, 5)
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (449, 2, 1)
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (991, 1, 3)
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (991, 5, 2)
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (931, 4, 5)
INSERT INTO HOA_DON_CHI_TIET(maHoaDon, maSanPham, soLuong)
OUTPUT inserted.maHoaDonChiTiet
VALUES (931, 5, 1)
GO


-- Bài 1 <> LAB 6
USE QuanLyBanHang
-- Hiển thị tất cả thông tin có trong 2 bảng Hoá đơn và Hoá đơn chi tiết gồm các cột sau:
-- maHoaDon, maKhachHang, trangThai, maSanPham, soLuong, ngayMua
SELECT HD.maHoaDon, maKhachHang, trangthai, maSanPham, soLuong, ngayMuaHang
FROM HOA_DON HD
     INNER JOIN HOA_DON_CHI_TIET HDCT ON HD.maHoaDon = HDCT.maHoaDon

-- Hiển thị tất cả thông tin có trong 2 bảng Hoá đơn và Hoá đơn chi tiết gồm các cột sau:
-- maHoaDon, maKhachHang, trangThai, maSanPham, soLuong, ngayMua với điều kiện maKhachHang = ‘KH001’
SELECT HD.maHoaDon, maKhachHang, trangthai, maSanPham, soLuong, ngayMuaHang
FROM HOA_DON HD
     INNER JOIN HOA_DON_CHI_TIET HDCT ON HD.maHoaDon = HDCT.maHoaDon
WHERE maKhachHang LIKE 'KH001'

-- Hiển thị thông tin từ 3 bảng Hoá đơn, Hoá đơn chi tiết và Sản phẩm gồm các cột sau:
-- maHoaDon, ngayMua, tenSP, donGia, soLuong mua trong hoá đơn, thành tiền. Với thành tiền= donGia* soLuong
SELECT HD.maHoaDon, ngayMuaHang, tenSP, donGia, HDCT.soLuong, HDCT.soLuong * donGia 'Thành tiền'
FROM HOA_DON_CHI_TIET HDCT
     INNER JOIN HOA_DON HD ON HD.maHoaDon = HDCT.maHoaDon
     INNER JOIN SAN_PHAM SP ON SP.maSanPham = HDCT.maSanPham

-- Hiển thị thông tin từ bảng khách hàng, bảng hoá đơn, hoá đơn chi tiết gồm các cột:
-- họ và tên khách hàng, email, điện thoại, mã hoá đơn, trạng thái hoá đơn và tổng tiền đã mua trong hoá đơn.
-- Chỉ hiển thị thông tin các hoá đơn chưa thanh toán.
SELECT hoVaTenLot + ' ' + Ten     'Họ tên khách hàng',
       Email,
       dienThoai,
       HD.maHoaDon,
       trangthai,
       SUM(donGia * HDCT.soLuong) 'Tổng tiền'
FROM HOA_DON HD
     INNER JOIN KHACH_HANG KH ON HD.maKhachHang = KH.maKhachHang
     INNER JOIN HOA_DON_CHI_TIET HDCT ON HD.maHoaDon = HDCT.maHoaDon
     INNER JOIN SAN_PHAM SP ON SP.maSanPham = HDCT.maSanPham
GROUP BY hoVaTenLot + ' ' + Ten, Email, dienThoai, HD.maHoaDon, trangthai
HAVING trangthai LIKE N'Chưa thanh toán'


-- Hiển thị maHoaDon, ngàyMuahang, tổng số tiền đã mua trong từng hoá đơn.
-- Chỉ hiển thị những hóa đơn có tổng số tiền >=500.000
-- và sắp xếp theo thứ tự giảm dần của cột tổng tiền
SELECT HD.maHoaDon, ngayMuaHang, SUM(donGia * HDCT.soLuong) 'Tổng tiền'
FROM HOA_DON_CHI_TIET HDCT
     INNER JOIN HOA_DON HD ON HD.maHoaDon = HDCT.maHoaDon
     INNER JOIN SAN_PHAM SP ON SP.maSanPham = HDCT.maSanPham
GROUP BY HD.maHoaDon, ngayMuaHang
HAVING SUM(donGia * HDCT.soLuong) >= 500000
ORDER BY SUM(donGia * HDCT.soLuong) DESC

-- <> Bài 2 LAB 6
USE QUANLYBANHANG
-- Hiển thị danh sách các khách hàng chưa mua hàng lần nào kể từ tháng 1/1/2016
SELECT *
FROM KHACH_HANG
WHERE maKhachHang NOT IN
      (
          SELECT HOA_DON.maKhachHang
          FROM HOA_DON
          WHERE ngayMuaHang >= '2016-1-1'
      )

-- Hiển thị mã sản phẩm, tên sản phẩm có lượt mua nhiều nhất trong tháng 12/2016
SELECT TOP 1 HDCT.maSanPham, tenSP
FROM HOA_DON_CHI_TIET HDCT
     INNER JOIN HOA_DON HD ON HD.maHoaDon = HDCT.maHoaDon
     INNER JOIN SAN_PHAM SP ON SP.maSanPham = HDCT.maSanPham
WHERE YEAR(ngayMuaHang) = 2016
  AND MONTH(ngayMuaHang) = 12
GROUP BY HDCT.maSanPham, tenSP
ORDER BY COUNT(HDCT.maSanPham) DESC

-- Hiển thị top 5 khách hàng có tổng số tiền mua hàng nhiều nhất trong năm 2016
SELECT TOP 5 HD.maKhachHang, hoVaTenLot + ' ' + Ten 'Họ tên khách hàng', SUM(donGia * HDCT.soLuong) 'Tổng tiền'
FROM HOA_DON_CHI_TIET HDCT
     INNER JOIN SAN_PHAM SP ON SP.maSanPham = HDCT.maSanPham
     INNER JOIN HOA_DON HD ON HD.maHoaDon = HDCT.maHoaDon
     INNER JOIN dbo.KHACH_HANG KH ON HD.maKhachHang = KH.maKhachHang
WHERE YEAR(ngayMuaHang) = 2016
GROUP BY HD.maKhachHang, hoVaTenLot + ' ' + Ten
ORDER BY SUM(donGia * HDCT.soLuong) DESC

-- Hiển thị thông tin các khách hàng sống ở ‘Đà Nẵng’ có mua sản phẩm có tên “Iphone 7 32GB” trong tháng 12/2016
SELECT *
FROM KHACH_HANG
WHERE diaChi LIKE N'%Đà Nẵng%'
  AND maKhachHang IN
      (SELECT maKhachHang
      FROM HOA_DON_CHI_TIET HDCT
           INNER JOIN HOA_DON HD ON HD.maHoaDon = HDCT.maHoaDon
           INNER JOIN SAN_PHAM SP ON SP.maSanPham = HDCT.maSanPham
      WHERE tenSP LIKE N'%Iphone 7 32GB%'
        AND YEAR(ngayMuaHang) = 2016
        AND MONTH(ngayMuaHang) = 12
      )

-- Hiển thị tên sản phẩm có lượt đặt mua nhỏ hơn lượt mua trung bình các các sản phẩm.
SELECT tenSP 'Tên sản phẩm'
FROM SAN_PHAM
WHERE maSanPham IN
      (SELECT maSanPham
      FROM HOA_DON_CHI_TIET HDCT
      GROUP BY HDCT.maSanPham
      HAVING COUNT(HDCT.maSanPham) < (
          SELECT AVG(temp.luotmua)
          FROM (
                   SELECT COUNT(HDCT.maSanPham) 'luotmua'
                   FROM HOA_DON_CHI_TIET HDCT
                   GROUP BY HDCT.maSanPham
               ) AS temp)
          )