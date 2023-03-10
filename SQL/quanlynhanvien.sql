CREATE DATABASE quanLyNhanVien
USE quanLyNhanVien
----------------------------
CREATE TABLE Phong_Ban
(
    Ma_PB          char(5) PRIMARY KEY,
    Ten_PB         nvarchar(50),
    Ma_TruongPhong char(8)
);

CREATE TABLE Nhan_Vien
(
    ID_Nhanvien char(8) PRIMARY KEY,
    Ho_NV       nvarchar(20),
    Ten_NV      nvarchar(20),
    Nam_sinh    date,
    Dia_chi     nvarchar(50),
    Gioi_tinh   nvarchar(10),
    Luong       int,
    PHG         char(5)
);

CREATE TABLE Du_An
(
    Ma_DA   char(5) PRIMARY KEY,
    Ten_DA  nvarchar(50),
    Ngay_BD date,
    Ngay_KT date
);

CREATE TABLE Quanly_DuAn
(
    Ma_DA       char(5),
    Ma_Nhanvien char(8),
    Ngay_TG     date,
    Ngay_KT     date,
    So_Gio      int,
    Vai_Tro     nvarchar(50)
);

/* tao rang buoc khoa chinh khoa ngoai*/
USE quanLyNhanVien
ALTER TABLE Quanly_DuAn
    ALTER COLUMN Ma_DA char(5) NOT NULL;


ALTER TABLE Quanly_DuAn
    ALTER COLUMN Ma_Nhanvien char(8) NOT NULL;

ALTER TABLE Quanly_DuAn
    ADD CONSTRAINT QLDA_PRI
        PRIMARY KEY (Ma_DA, Ma_Nhanvien);

USE quanLyNhanVien
ALTER TABLE Quanly_DuAn
    DROP CONSTRAINT QLDA_PRI


ALTER TABLE Quanly_DuAn
    ADD CONSTRAINT QLDA_DA_PK
        FOREIGN KEY (Ma_DA)
            REFERENCES Du_An (Ma_DA);

ALTER TABLE Quanly_DuAn
    ADD CONSTRAINT QLDA_NV_PK
        FOREIGN KEY (Ma_Nhanvien)
            REFERENCES Nhan_Vien (ID_Nhanvien);

-- tao rang buoc khoa ngoai bang Nhan_Vien
ALTER TABLE Nhan_Vien
    ADD CONSTRAINT NV_PB_PK
        FOREIGN KEY (PHG)
            REFERENCES Phong_Ban (Ma_PB);

ALTER TABLE Phong_Ban
    ADD CONSTRAINT PB_NV_PK
        FOREIGN KEY (Ma_TruongPhong)
            REFERENCES Nhan_Vien (ID_Nhanvien);

ALTER TABLE Phong_Ban
    ADD Mo_ta nvarchar(200);

ALTER TABLE Quanly_DuAn
    ADD CONSTRAINT chk_sogio
        CHECK (So_Gio > 0);

/* giong comment trong c*/
/* them khoa chinh*/
-- comment

ALTER TABLE Phong_Ban
    ADD CONSTRAINT Pri_PB
        PRIMARY KEY (Ma_PB);

