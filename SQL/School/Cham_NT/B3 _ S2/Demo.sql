CREATE DATABASE QUANLYNHANVIEN
GO

USE QUANLYNHANVIEN;
GO

CREATE TABLE PHONG_BAN
(
    MA_PB NVARCHAR(50) PRIMARY KEY,
    TEN_PB NVARCHAR(50),
    MA_TRUONGPHONG NVARCHAR(50),
);

CREATE TABLE NHAN_VIEN
(
    ID_NHANVIEN NVARCHAR(50) PRIMARY KEY,
    HO_NV NVARCHAR(50),
    TEN_NV NVARCHAR(50),
    NAM_SINH DATE,
    DIA_CHI NVARCHAR(50),
    GIOI_TINH NVARCHAR(50),
    LUONG INT,
    PHG NVARCHAR(50) REFERENCES PHONG_BAN (MA_PB),
);

CREATE TABLE DU_AN
(
    MA_DUAN NVARCHAR(50) PRIMARY KEY,
    TEN_DUAN NVARCHAR(50),
    NGAY_BATDAU DATETIME,
    NGAY_KET_THUC DATETIME
);

CREATE TABLE QUANLY_DUAN
(
    MA_DUAN NVARCHAR(50),
    MA_NHANVIEN NVARCHAR(50),
    NGAY_THAM_GIA DATETIME,
    NGAY_KET_THUC DATETIME,
    SO_GIO INT,
    VAI_TRO NVARCHAR(50),
    PRIMARY KEY (MA_DUAN, MA_NHANVIEN),
    FOREIGN KEY (MA_NHANVIEN) REFERENCES NHAN_VIEN (ID_NHANVIEN),
    FOREIGN KEY (MA_DUAN) REFERENCES DU_AN,
);

ALTER TABLE PHONG_BAN
    ADD CONSTRAINT Phong_Ban_FK FOREIGN KEY (MA_TRUONGPHONG) REFERENCES NHAN_VIEN (ID_NHANVIEN);

-- <Slide7>
-- 1.Sao chép toàn bộ dữ liệu thành bảng mới
SELECT *
INTO NV_Test
FROM NHAN_VIEN;

SELECT *
INTO DA_Test
FROM DU_AN;

SELECT *
INTO PB_Test
FROM PHONG_BAN;

SELECT *
INTO QLDA_Test
FROM QUANLY_DUAN;

SELECT *
INTO NV_Test
FROM NHAN_VIEN;

-- 2. Tạo bảng mới từ bảng Dự Án có ngày bắt đầu
-- và ngày kết thúc trong 2016
SELECT *
INTO DA_2016
FROM DU_AN
WHERE YEAR(NGAY_BATDAU) = 2016
    AND YEAR(NGAY_KET_THUC) = 2016;

-- 3.Thêm dữ liệu các bảng
-- Nhập dữ liệu bảng Phòng ban
INSERT INTO PHONG_BAN
    (MA_PB, TEN_PB, MA_TRUONGPHONG)
VALUES
    (N'PB01', N'Hành chính', NULL),
    (N'PB02', N'Kinh doanh', NULL),
    (N'PB03', N'Sản xuất', NULL),
    (N'PB04', N'Quản lý', NULL),
    (N'PB05', N'Kế toán', NULL);
GO

-- Nhập dữ liệu bảng Nhân viên
INSERT INTO NHAN_VIEN
    (ID_NHANVIEN, HO_NV, TEN_NV, NAM_SINH, DIA_CHI, GIOI_TINH, LUONG, PHG)
VALUES
    ('NV001', N'Cao Văn', N'Chỉnh', '1997', N'Hạ Mỗ, Đan Phượng, Hà Nội', N'Nam', 1000, NULL),
    ('NV002', N'Ngô Trung', N'Hiếu', '2003', N'xã Đại Hợp, huyện Kiến Thụy, TP Hải Phòng', N'Nam', 1500, NULL),
    ('NV003', N'Đỗ Xuân', N'Hiếu', '2003', N'Nhật Tiến, xã Trường Yên, Chương Mỹ, Hà Nội', N'Nam', 800, NULL),
    ('NV004', N'Đinh Viết', N'Khang', '2003', N'xã Yên Hợp, Quỳ Hợp, Nghệ An', N'Nam', 500, NULL),
    ('NV005', N'Hà Thị', N'Ngọc Hải', '2003', N'Hạ Đình, Thanh Xuân, Hà Nội', N'Nam', 2000, NULL);
GO

--Nhập dữ liệu bảng Dự án
INSERT INTO DU_AN
    (MA_DUAN, TEN_DUAN, NGAY_BATDAU, NGAY_KET_THUC)
VALUES
    ('DA01', N'Sữa chữa', '2016-12-01', '2017-02-28'),
    ('DA02', N'Tin học hóa', '2016-07-12', '2016-09-30'),
    ('DA03', N'Đóng gói SP', '2015-12-30', '2018-12-30'),
    ('DA04', N'Hoạch toán doanh thu', '2017-02-03', '2017-05-8'),
    ('DA05', N'Tổ chức doanh nghiệp', '2015-11-21', '2018-12-30');
GO

-- Nhập dữ liệu bảng QLDA
INSERT INTO QUANLY_DUAN
    (MA_DUAN, MA_NHANVIEN, NGAY_THAM_GIA, NGAY_KET_THUC, SO_GIO, VAI_TRO)
VALUES
    ('DA01', 'NV001', '2016-12-01', '2017-02-28', 1000, N'Nhân viên'),
    ('DA01', 'NV002', '2016-12-01', '2017-02-28', 1000, N'Nhân viên'),
    ('DA03', 'NV005', '2015-12-30', '2018-12-30', 153600, N'Nhân viên'),
    ('DA03', 'NV004', '2015-12-30', '2018-12-30', 152000, N'Nhân viên'),
    ('DA05', 'NV001', '2015-11-21', '2018-12-30', 1000, N'Nhân viên');
GO


-- Thêm chỉ mục
CREATE INDEX nv_index ON NHAN_VIEN(ID_NHANVIEN);
CREATE INDEX da_index ON DU_AN  (MA_DUAN);
CREATE INDEX pb_index ON PHONG_BAN (MA_PB);
CREATE INDEX qlda_index ON QUANLY_DUAN (MA_DUAN);

-- Thêm chỉ mục duy nhât
CREATE UNIQUE INDEX nv_ui ON NHAN_VIEN(Email);

USE QUANLYNHANVIEn
-- Xóa chỉ mục
DROP INDEX nv_index ON NHAN_VIEN;
