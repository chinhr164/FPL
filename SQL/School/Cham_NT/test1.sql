-- ĐÈ THI THỪ (9h30 – 10h30)
-- Câu 1: Tạo và nhập dữ liệu cho CSDL QLKH: (4 điểm)
-- MATHANG ('MSMH', TENHANG, DONGIA, DONVITINH)
-- KHACHHANG ('MAKH', TENKH, DCHI)
-- PHIEUNHAP ('SOPN', NGAYLAP,'MAKH', KHOHANG)
-- CTNHAP ('SOPN', 'MSMH', SOLUONG)

CREATE DATABASE QLKH
GO

USE QLKH
GO

CREATE TABLE MatHang
(
    MSMH VARCHAR(7) PRIMARY KEY,
    TenHang NVARCHAR(50),
    DonGia INT,
    DonViTinh NVARCHAR(50)
)
GO

CREATE TABLE KhachHang
(
    MAKH VARCHAR(7) PRIMARY KEY,
    TenKH NVARCHAR(50),
    Dchi NVARCHAR(100)
)
GO

CREATE TABLE PhieuNhap
(
    SoPN VARCHAR(3) PRIMARY KEY,
    NgayLap DATE,
    MAKH VARCHAR(7) NOT NULL,
    KhoHang NVARCHAR(100),
    FOREIGN KEY (MAKH) REFERENCES KhachHang(MAKH)
)
GO

CREATE TABLE CTnhap
(
    SoPN VARCHAR(3) NOT NULL,
    MSMH VARCHAR(7) NOT NULL,
    SoLuong int,
    PRIMARY KEY(SoPN, MSMH),
    FOREIGN KEY (SoPN) REFERENCES PhieuNhap(SoPN),
    FOREIGN KEY (MSMH) REFERENCES MatHang(MSMH)
)
GO

-- Yêu cầu: Nhập dữ liệu cho 4 bảng mỗi bảng 3 dòng. Bảng khách hàng là có khách hàng
-- đầu tiên là thông tin của sinh viên làm bài test.

-- Nhập dữ liệu bảng Mặt hàng
INSERT INTO MatHang
    (MSMH,TenHang,DonGia,DonViTinh)
VALUES
    ('MH01', N'Khăn lau bàn', 12000, N'Chiếc'),
    ('MH02', N'Nước rửa chén', 35000, N'Chai'),
    ('MH03', N'Chổi lau nhà', 120000, N'Cây');
GO

-- Nhập dữ liệu bảng Khách hàng
INSERT INTO KhachHang
    (MAKH,TenKH,Dchi)
VALUES
    ('KH001', N'Cao Văn Chỉnh', N'Đan Phượng, Hà Nội'),
    ('KH002', N'Ngô Anh Thư', N'Hoài Đức, Hà Nội'),
    ('KH003', N'Nguyễn Anh Tài', N'Hòa Bình');
GO

-- Nhập dữ liệu bảng Phiếu Nhập
INSERT INTO PhieuNhap
    (SoPN,NgayLap,MAKH,KhoHang)
VALUES
    ('1', '2006-02-25', 'KH002', N'Trần Quóc Hoàn, Cầu Giấy,Hà Nội'),
    ('2', '2005-12-25', 'KH001', N'Trần Thái Tông, Cầu Giấy, Hà Nội'),
    ('3', '2005-05-21', 'KH003', N'Lê Đức Thọ, Nam Từ Liêm, Hà Nội');
GO

-- Nhập dữ liệu bảng CT Nhập
INSERT INTO CTnhap
    (SoPN,MSMH,SoLuong)
VALUES
    ('1', 'MH02', 10),
    ('1', 'MH01', 20),
    ('1', 'MH03', 10),
    ('2', 'MH02', 3),
    ('3', 'MH03', 5);
GO

-- Câu 2: Thực hiện bằng ngôn ngữ SQL các câu truy vẫấn sau:
-- 1. Hiển thị thông tin các phiếu nhập của năm 2006, thông tin gồm: SỐ phiếu nhập, tên
-- khách hàng, ngày lập phiếu, thành tiền. (1 điểm)
SELECT CTnhap.SoPN, TenKH, NgayLap, SUM(SoLuong*DonGia) AS 'Thành Tiền'
FROM CTnhap
    INNER JOIN MatHang ON MatHang.MSMH = CTnhap.MSMH
    INNER JOIN PhieuNhap ON PhieuNhap.SoPN = CTnhap.SoPN
    INNER JOIN KhachHang ON KhachHang.MAKH = PhieuNhap.MAKH
WHERE YEAR(NgayLap) = 2006
GROUP BY CTnhap.SoPN, TenKH, NgayLap

-- 2. Cho biết khách hàng Ngô Anh Thư (nếu có) đã đặt mua bao nhiêu mặt hàng trong
-- tháng 02 năm 2006, thông tin gồm: tháng, năm, tổng số mặt hàng đã mua. (1 điểm)
SELECT MONTH(NgayLap) AS 'Tháng', YEAR(NgayLap) AS 'Năm', COUNT(MSMH) AS 'Tổng mặt hàng đã mua'
FROM PhieuNhap
    INNER JOIN KhachHang ON KhachHang.MAKH = PhieuNhap.MAKH
    INNER JOIN CTnhap ON CTnhap.SoPN = PhieuNhap.SoPN
WHERE TenKH LIKE N'%Ngô Anh Thư%' AND MONTH(NgayLap) = 2 AND YEAR(NgayLap) = 2006
GROUP BY TenKH, NgayLap

-- 3. In danh sách các khách hàng (MAKH, TENKH) có tổng thành tiền của các phiếu nhập
-- từ 1.000.000 trở lên. (1 điểm)
SELECT KhachHang.MAKH, TenKH, Sum(SoLuong*DonGia) AS 'Tổng thành Tiền'
FROM CTnhap
    INNER JOIN MatHang ON MatHang.MSMH = CTnhap.MSMH
    INNER JOIN PhieuNhap ON PhieuNhap.SoPN = CTnhap.SoPN
    INNER JOIN KhachHang ON KhachHang.MAKH = PhieuNhap.MAKH
GROUP BY KhachHang.MAKH, TenKH
HAVING Sum(SoLuong*DonGia) > 1000000
