-- YC04 - Tạo các bảng trong CSDL, tạo các ràng buộc: khoá chính, khoá ngoại,
-- ràng buộc duy nhất, ràng buộc kiểm tra …
CREATE DATABASE QLTV
GO

USE QLTV

CREATE TABLE THE_LOAI
(
    MaTL VARCHAR(10) PRIMARY KEY,
    TenTL NVARCHAR(25)
)
GO

CREATE TABLE SACH
(
    MaSach VARCHAR(10) PRIMARY KEY,
    TenSach NVARCHAR(50) NOT NULL,
    NXB NVARCHAR(100),
    SoTrang INT CHECK (SoTrang > 5),
    SoBan INT CHECK (SoBan > 1),
    GiaTien MONEY CHECK (GiaTien > 0),
    NgayNhap DATE NOT NULL,
    ViTri NVARCHAR(25) NOT NULL,
    MaTL VARCHAR(10)
        REFERENCES THE_LOAI (MaTL),
)
GO

CREATE TABLE TAC_GIA
(
    MaSach VARCHAR(10) NOT NULL,
    TenTG NVARCHAR(50) NOT NULL,
    PRIMARY KEY (MaSach,TenTG),
    FOREIGN KEY (MaSach) REFERENCES SACH (MaSach),
)
GO


CREATE TABLE THE_SV
(
    MaSV VARCHAR(10) PRIMARY KEY,
    Ho NVARCHAR(10),
    TenLot NVARCHAR(50),
    TenSV NVARCHAR(50) NOT NULL,
    chuyenNganh NVARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    dienThoai VARCHAR(10) NOT NULL,
    ngayHetHan DATE NOT NULL,
)
GO

CREATE TABLE PHIEU_MUON
(
    SoPhieu INT IDENTITY(1, 1) PRIMARY KEY,
    MaSV VARCHAR(10) NOT NULL,
    ngayMuon DATE NOT NULL,
    ngayTra DATE,
    TrangThai NVARCHAR(50),
    SoSachMuon INT CHECK (SoSachMuon <= 3),
    FOREIGN KEY (MaSV) REFERENCES THE_SV (MaSV),
    CHECK (ngayTra > ngayMuon),
)
GO

CREATE TABLE CT_MUON
(
    SoPhieu INT NOT NULL,
    MaSach VARCHAR(10) NOT NULL,
    PRIMARY KEY (MaSach,SoPhieu),
    FOREIGN KEY (MaSach) REFERENCES SACH (MaSach),
    FOREIGN KEY (SoPhieu) REFERENCES PHIEU_MUON (SoPhieu),
)
GO



-- YC5 - Nhập dữ liệu vào cho các bảng (ít nhất 5 bản ghỉ trên mỗi bảng)
-- Nhập dữ liệu bảng Thể loại
INSERT INTO THE_LOAI
    ( MaTL, TenTL )
VALUES
    ('TL01', N'IT'),
    ('TL02', N'Văn học'),
    ('TL03', N'Kinh tế'),
    ('TL04', N'Ngoại ngữ'),
    ('TL05', N'Lịch sử')
GO

-- Nhập dữ liệu bảng Sách
INSERT INTO SACH
    ( MaSach, TenSach, NXB, SoTrang, SoBan, GiaTien, NgayNhap, ViTri, MaTL )
VALUES
    ('S01', N'Giáo trình C++ và Lập trình hướng đối tượng', N'NXB Bách khoa Hà Nội', 482, 11, 116000, '2007-05-12', 'K201', 'TL01'),
    ('S02', N'Giáo Trình Kỹ Thuật Lập Trình C Căn Bản & Nâng Cao', N'NXB Thông Tin Và Truyền Thông', 430, 12, 108000, '2007-02-28', 'K302', 'Tl01'),
    ('S03', N'Nhà Giả Kim', N'MXB Hội Nhà Văn', 227, 10, 79000, '2005-10-25', 'K421', 'TL02'),
    ('S04', N'Hai Số Phận', N'NXB Văn Học', 768, 5, 175000, '2006-02-10', 'K412', 'TL02'),
    ('S05', N'How Business Works - Hiểu Hết Về Kinh Doanh', N'NXB Thế Giới', 351, 4, 380000, '2009-10-30', 'K324', 'TL03'),
    ('S06', N'Tiền Đẻ Ra Tiền - Đầu Tư Tài Chính Thông Minh', N'NXB Hồng Đức', 292, 20, 120000, '2009-03-22', 'K431', 'TL03'),
    ('S07', N'Cẩm Nang Cấu Trúc Tiếng Anh', N'MXB Đại học Sư phạm', 237, 9, 100000, '2008-08-07', 'K322', 'TL04'),
    ('S08', N'Hackers Ielts: Reading', N'NXB Thế Giới', 552, 23, 260000, '2008-02-12', 'K112', 'TL04'),
    ('S09', N'Lịch Sử Văn Minh Ả Rập', N'NXB Hồng Đức', 526, 18, 180000, '2006-09-02', 'K132', 'TL05'),
    ('S10', N'Xứ Đông Dương', N'NXB Thế Giới', 650, 3, 300000, '2005-11-30', 'K133', 'TL05'),
    ('S11', N'Lập trình SQL căn bản', N'NXB Lao động Xã hội', 160, 3, 150000, '2007-11-30', 'K143', 'TL01'),
    ('S12', N'Giáo Trình SQL', N'NXB ĐHKH Huế', 146, 3, 100000, '2004-01-30', 'K153', 'TL01')

GO

-- Nhập dữ liệu bảng Tác giả
INSERT INTO TAC_GIA
    ( MaSach, TenTG )
VALUES
    ('S01', N'Phạm Văn Ất'),
    ('S01', N'Lê Trường Thông'),
    ('S02', N'Phạm Văn Ất'),
    ('S02', N'Đỗ Văn Tuấn'),
    ('S03', N'Paulo Coelho'),
    ('S04', N'Jeffrey Archer'),
    ('S05', N'Nhiều Tác Giả'),
    ('S06', N'Duncan Bannatyne'),
    ('S07', N'Trang Anh'),
    ('S08', N'Viện ngôn ngữ Hackers'),
    ('S09', N'VWill Durant'),
    ('S10', N'Paul Doumer'),
    ('S11', N'Đoàn Thiện Ngân'),
    ('S12', N'Trần Nguyên Phong')
GO

--  Nhập dữ liệu Thẻ SV
INSERT INTO THE_SV
    ( MaSV, ho, TenLot, TenSV, chuyenNganh, email, dienThoai, ngayHetHan )
VALUES
    ('PH21409', N'Cao', N'Văn', N'Chỉnh', N'LTMT', 'chinhcv@gmail.com', '0338878397', '2023-12-31'),
    ('PH21079', N'Đinh', N'Viết', N'Khang', N'LTMT', 'khangdv@gmail.com', '0338878397', '2023-12-31'),
    ('PH21411', N'Đỗ', N'Xuân', N'Hiếu', N'LTMT', 'hieudx@gmail.com', '0338878397', '2023-12-31'),
    ('PH21424', N'Ngô', N'Trung', N'Hiếu', N'LTMT', 'hieunt@gmail.com', '0338878397', '2023-12-31'),
    ('PH21513', N'Hà', N'Thị', N'Ngọc Hải', N'LTMT', 'haihtn@gmail.com', '0338878397', '2023-12-31')
GO

-- Nhập dữ liệu Phiếu mượn
INSERT INTO PHIEU_MUON
    ( MaSV, ngayMuon, ngayTra, TrangThai, SoSachMuon )
OUTPUT
inserted.SoPhieu
VALUES
    ('PH21409', '2017-12-31', '2018-01-03', N'Đã trả', 3)
INSERT INTO PHIEU_MUON
    ( MaSV, ngayMuon, ngayTra, TrangThai, SoSachMuon )
OUTPUT
inserted.SoPhieu
VALUES
    ('PH21079', '2017-12-31', NULL, N'Chưa trả', 1)
INSERT INTO PHIEU_MUON
    ( MaSV, ngayMuon, ngayTra, TrangThai, SoSachMuon )
OUTPUT
inserted.SoPhieu
VALUES
    ('PH21411', '2017-12-31', '2018-01-06', N'Đã trả', 2)
INSERT INTO PHIEU_MUON
    ( MaSV, ngayMuon, ngayTra, TrangThai, SoSachMuon )
OUTPUT
inserted.SoPhieu
VALUES
    ('PH21424', '2017-12-31', NULL, N'Chưa trả', 1)
INSERT INTO PHIEU_MUON
    ( MaSV, ngayMuon, ngayTra, TrangThai, SoSachMuon )
OUTPUT
inserted.SoPhieu
VALUES
    ('PH21513', '2017-01-31', '2017-02-06', N'Đã trả', 2)
GO
SELECT *
FROM PHIEU_MUON
-- Nhập dữ liệu bảng CT_Mượn
INSERT INTO CT_MUON
    ( SoPhieu, MaSach )
VALUES
    (1, 'S01'),
    (1, 'S03'),
    (1, 'S05'),
    (2, 'S02'),
    (3, 'S04'),
    (3, 'S06'),
    (4, 'S07'),
    (5, 'S08'),
    (5, 'S09')
GO

-- YC6 - Viết các câu truy vấn:
-- 6.1 Liệt kê tất cả thông tin của các đầu sách gồm mã sách, tên sách, giá tiền , tác giả
-- thuộc loại sách có mã “IT”.
SELECT SACH.MaSach, TenSach, GiaTien, TenTG
FROM SACH
    INNER JOIN TAC_GIA ON SACH.MaSach = TAC_GIA.MaSach
    INNER JOIN THE_LOAI ON SACH.MaTL = THE_LOAI.MaTL
WHERE TenTL LIKE 'IT'

-- 6.2 Liệt kê các phiếu mượn gồm các thông tin mã phiếu mượn, mã sách , ngày mượn, mã sinh viên
-- có ngày mượn trong tháng 01/2017.
SELECT PHIEU_MUON.SoPhieu, MaSach, ngayMuon, MaSV
FROM PHIEU_MUON
    INNER JOIN CT_MUON ON PHIEU_MUON.SoPhieu = CT_MUON.SoPhieu
WHERE YEAR(ngayMuon) = 2017 AND MONTH(ngayMuon) = 1

-- 6.3 Liệt kê các phiếu mượn chưa trả sách cho thư viên
-- theo thứ tự tăng dần của ngày mượn sách.
SELECT *
FROM PHIEU_MUON
WHERE TrangThai LIKE N'Chưa trả'
ORDER BY ngayMuon

-- 6.4 Liệt kê tổng số đầu sách của mỗi loại sách
-- gồm mã loại sách, tên loại sách, tổng số lượng sách mỗi loại).
SELECT SACH.MaTL 'Mã thể loại', TenTL 'Tên thể loại', SUM(SoBan) 'Tổng số sách'
FROM THE_LOAI
    INNER JOIN SACH ON THE_LOAI.MaTL = SACH.MaTL
GROUP BY SACH.MaTL,TenTL

-- 6.5 Đếm xem có bao nhiêu lượt sinh viên đã mượn sách.
SELECT COUNT(*) 'Số lượt sinh viên mượn sách'
FROM PHIEU_MUON

-- 6.6 Hiển thị tất cả các quyển sách có tiêu đề chứa từ khoá “SQL”.
SELECT *
FROM SACH
WHERE TenSach LIKE N'%SQL%'

-- 6.7 Hiển thị thông tin mượn sách gồm các thông tin: mã sinh viên, tên sinh viên,
-- mã phiếu mượn, tiêu đề sách, ngày mượn, ngày trả. Sắp xếp thứ tự theo ngày mượn sách.
SELECT PHIEU_MUON.MaSV, ho + ' ' + TenLot + ' ' + TenSV N'Họ tên SV', PHIEU_MUON.SoPhieu, TenSach, ngayMuon, ngayTra
FROM PHIEU_MUON
    INNER JOIN CT_MUON ON PHIEU_MUON.SoPhieu = CT_MUON.SoPhieu
    INNER JOIN THE_SV ON PHIEU_MUON.MaSV = THE_SV.MaSV
    INNER JOIN SACH ON CT_MUON.MaSach = SACH.MaSach
ORDER BY ngayMuon

-- 6.8 Liệt kê các đầu sách có lượt mượn lớn hơn 20 lần.
SELECT TenSach, COUNT(CT_MUON.MaSach) N'Lượt mượn'
FROM SACH
    INNER JOIN CT_MUON ON SACH.MaSach = CT_MUON.MaSach
GROUP BY TenSach
HAVING COUNT(CT_MUON.MaSach) > 20

-- 6.9 Viết câu lệnh cập nhật lại giá tiền của các quyển sách có ngày nhập kho
-- trước năm 2014 giảm 30%.
UPDATE SACH
SET GiaTien = GiaTien * 0.7
WHERE YEAR(NgayNhap) < 2014

-- 6.10 Viết câu lệnh cập nhật lại trạng thái đã trả sách cho phiếu mượn
-- của sinh viên có mã sinh viên PD12301 (ví dụ) // Sinh viên có mã PH21409.
UPDATE PHIEU_MUON
SET TrangThai = N'Chưa trả'
WHERE MaSV = 'PH21079'

-- 6.11 Lập danh sách các phiếu mượn quá hạn chưa trả gồm các thông tin:
-- mã phiếu mượn, tên sinh viên, email, danh sách các sách đã mượn, ngày mượn.
SELECT PHIEU_MUON.SoPhieu, ho + ' ' + TenLot + ' ' + TenSV N'Họ tên SV', email, TenSach, ngayMuon
FROM PHIEU_MUON
    INNER JOIN CT_MUON ON PHIEU_MUON.SoPhieu = CT_MUON.SoPhieu
    INNER JOIN THE_SV ON PHIEU_MUON.MaSV = THE_SV.MaSV
    INNER JOIN SACH ON CT_MUON.MaSach = SACH.MaSach
WHERE  PHIEU_MUON.SoPhieu IN
(
SELECT SoPhieu
from PHIEU_MUON
WHERE DATEDIFF(DAY,ngayMuon,CURRENT_TIMESTAMP) > 7 AND TrangThai LIKE N'Chưa trả'
)

-- 6.12 Viết câu lệnh cập nhật lại số lượng bản sao tăng lên 5 đơn vị
-- đối với các đầu sách có lượt mượn lớn hơn 10
UPDATE SACH
SET SoBan = SoBan + 5
WHERE MaSach IN
(
SELECT MaSach
FROM CT_MUON
GROUP BY MaSach
HAVING COUNT(CT_MUON.MaSach) > 10
)

-- 6.13 Viết câu lệnh xoá các phiếu mượn có ngày mượn và ngày trả trước "1/1/2010"
DELETE PHIEU_MUON
WHERE YEAR(ngayMuon) < 2010
    AND YEAR(ngayTra) < 2010