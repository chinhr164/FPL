-- Bài 1 <> LAB 5
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


-- Bài 2 <> LAB5
USE QuanLyBanHang
-- Hiển thị tất cả thông tin có trong bảng khách hàng bao gồm tất cả các cột
SELECT *
FROM KHACH_HANG

-- hiển thị 10 khách hàng đầu tiên trong bảng khách hàng bao gồm các cột:
-- mã khách hàng, họ và tên, email, số điện thoại
SELECT TOP 10 maKhachHang, hoVaTenLot + ' ' + Ten 'Họ và tên', Email, dienThoai
FROM KHACH_HANG

-- Hiển thị thông tin từ bảng Sản phẩm gồm các cột:
-- mã sản phẩm, tên sản phẩm, tổng tiền tồn kho.
-- Với tổng tiền tồn kho = đơn giá* số lượng
SELECT maSanPham, tenSP, donGia * soLuong 'Tổng tiền tồn kho'
FROM SAN_PHAM

-- Hiển thị danh sách khách hàng có tên bắt đầu bởi kí tự ‘H’ gồm các cột:
-- maKhachHang, hoVaTen, diaChi. Trong đó cột hoVaTen ghép từ 2 cột hoVaTenLot và Ten
SELECT maKhachHang, hoVaTenLot + ' ' + Ten 'Họ và tên', diaChi
FROM KHACH_HANG
WHERE Ten LIKE 'H%'

-- Hiển thị tất cả thông tin các cột của khách hàng có địa chỉ chứa chuỗi ‘Đà Nẵng'
SELECT *
FROM KHACH_HANG
WHERE diaChi LIKE N'%Đà Nẵng%'

-- Hiển thị các sản phẩm có số lượng nằm trong khoảng từ 100 đến 500
SELECT *
FROM SAN_PHAM
WHERE soLuong BETWEEN 100 AND 500

-- Hiển thị danh sách các hoá hơn có trạng thái là chưa thanh toán và ngày mua hàng trong năm 2016
SELECT *
FROM HOA_DON
WHERE HOA_DON.trangthai LIKE N'Chưa thanh toán'
  AND YEAR(ngayMuaHang) = 2016

-- Hiển thị các hoá đơn có mã Khách hàng thuộc 1 trong 3 mã sau: KH001, KH003, KH006
SELECT *
FROM KHACH_HANG
WHERE maKhachHang
          IN ('KH001', 'KH003', 'KH006')


--  Bài 3 <> LAB 5
USE QUANLYBANHANG
-- Hiển thị số lượng khách hàng có trong bảng khách hàng
SELECT COUNT(*) 'Số lượng khách hàng'
FROM KHACH_HANG

-- Hiển thị đơn giá lớn nhất trong bảng SanPham
SELECT MAX(donGia) 'Đơn giá lớn nhất'
FROM SAN_PHAM

-- Hiển thị số lượng sản phẩm thấp nhất trong bảng sản phẩm
SELECT MIN(soLuong) 'Số lượng sản phẩm thấp nhất'
FROM SAN_PHAM

-- Hiển thị tổng tất cả số lượng sản phẩm có trong bảng sản phẩm
SELECT SUM(soLuong) 'Tổng số lượng'
FROM SAN_PHAM

-- Hiển thị số hoá đơn đã xuất trong tháng 12/2016 mà có trạng thái chưa thanh toán
SELECT COUNT(*) 'Số hóa đơn'
FROM HOA_DON
WHERE YEAR(ngayMuaHang) = 2016
  AND MONTH(ngayMuaHang) = 12
  AND TRANGTHAI LIKE N'Chưa thanh toán'

-- Hiển thị mã hoá đơn và số loại sản phẩm được mua trong từng hoá đơn.
SELECT maHoaDon, COUNT(*) 'Số loại sản phẩm'
FROM HOA_DON_CHI_TIET
GROUP BY maHoaDon

-- Hiển thị mã hoá đơn và số loại sản phẩm được mua trong từng hoá đơn.
-- Yêu cầu chỉ hiển thị hàng nào có số loại sản phẩm được mua >=5.
SELECT maHoaDon, COUNT(*) 'Số loại sản phẩm'
FROM HOA_DON_CHI_TIET
GROUP BY maHoaDon
HAVING COUNT(*) >= 5

-- Hiển thị thông tin bảng HoaDon gồm các cột
-- maHoaDon, ngayMuaHang,maKhachHang.
-- Sắp xếp theo thứ tự giảm dần của ngayMuaHang
SELECT maHoaDon, ngayMuaHang, maKhachHang
FROM HOA_DON
ORDER BY ngayMuaHang DESC