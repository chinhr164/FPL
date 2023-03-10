-- <1> Tạo bảng và thêm dữ liệu
CREATE DATABASE QLSV
GO

USE QLSV
GO

CREATE TABLE KHOA
(
    MaKhoa  varchar(10) PRIMARY KEY,
    TenKhoa nvarchar(50)
)
GO

CREATE TABLE SINH_VIEN
(
    HoSV     nvarchar(50),
    TenSV    nvarchar(50),
    MaSV     varchar(10) PRIMARY KEY,
    NgaySinh date,
    Phai     nvarchar(3),
    MaKhoa   varchar(10) NOT NULL FOREIGN KEY REFERENCES KHOA (MAKHOA)
)
GO

CREATE TABLE KET_QUA
(
    MaSV   varchar(10) NOT NULL FOREIGN KEY REFERENCES SINH_VIEN (MaSV),
    MaMH   varchar(10) NOT NULL,
    LanThi int         NOT NULL,
    Diem   float,
    PRIMARY KEY (MaSV, MaMH, LanThi)
)
GO

-- Dữ liệu bảng Khóa
INSERT INTO KHOA(MaKhoa, TenKhoa)
VALUES ('K15.1', N'Khóa 15 nhập học lần 1'),
       ('K15.3', N'Khóa 15 nhập học lần 2'),
       ('K15.3', N'Khóa 15 nhập học lần 3'),
       ('K17.1', N'Khóa 17 nhập học lần 1'),
       ('K17.2', N'Khóa 17 nhập học lần 2'),
       ('K17.3', N'Khóa 17 nhập học lần 3');
GO

-- Dữ liệu bảng Sinh viên
INSERT INTO SINH_VIEN(HoSV, TenSV, MaSV, NgaySinh, Phai, MaKhoa)
VALUES (N'Ngô', N'Trung Hiếu', 'PH21424', '2003-12-18', N'Nam', 'K15.1'),
       (N'Cao', N'Văn Chỉnh', 'PH21409', '1997-10-25', N'Nam', 'K15.1'),
       (N'Đỗ', N'Xuân Hiếu', 'PH21419', '2003-13-01', N'Nam', 'K15.2'),
       (N'Đinh', N'Viết Khang', 'PH21079', '2002-10-17', N'Nam', 'K15.2'),
       (N'Hà Thị', N'Ngọc Hải', 'PH21513', '2003-02-12', N'Nữ', 'K15.3'),
       (N'Phan Lê', N'Phúc An', 'PH61691', '1998-10-01', N'Nam', 'K15.3'),
       (N'Vũ', N'Đức Chung', 'PH61571', '1998-04-22', N'Nam', 'K17.1'),
       (N'Nguyễn', N'Bá Công', 'PH61662', '1998-02-09', N'Nam', 'K17.1'),
       (N'Cao', N'Tiến Đạt', 'PH63043', '1996-12-15', N'Nam', 'K17.2'),
       (N'Nguyễn', N'Mạnh Dũng', 'PH60090', '1994-02-16', N'Nam', 'K17.2'),
       (N'Nguyễn', N'Thị Oanh', 'PH63157', '1998-02-07', N'Nam', 'K17.3'),
       (N'Nguyễn Thị', N'Tố Uyên', 'PH00456', '1998-09-15', N'Nam', 'K17.3');
GO

-- Dữ liệu bảng Kết quả
INSERT INTO KET_QUA(MaSV, MaMH, LanThi, Diem)
VALUES ('PH00456', 'SKI1014', 1, 10),
       ('PH00456', 'COM108', 1, 8),
       ('PH00456', 'MUL1013', 1, 9),
       ('PH00456', 'COM107', 1, 7),
       ('PH21424', 'COM2012', 1, 9),
       ('PH21409', 'COM2012', 1, 8),
       ('PH21419', 'COM2012', 1, 10),
       ('PH21079', 'COM2012', 1, 7),
       ('PH21513', 'COM2012', 1, 10);
GO


-- <2> Các câu truy vấn
-- Câu 1: Cho biết danh sách các sinh viên phái Nữ: MaSV, HoSV, TenSV, NgaySinh, Phai
SELECT MaSV, HoSV, TenSV, NgaySinh, Phai
FROM SINH_VIEN
WHERE Phai LIKE N'Nữ';

-- Câu 2: Cho biết kết quả các môn học của sinh viên có mã PH00456: MaSV, HoSV, TenSV, NgaySinh, MaMH, LanThi, Diem.
SELECT KQ.MaSV, HoSV, TenSV, NgaySinh, MaMH, LanThi, Diem
FROM SINH_VIEN
         INNER JOIN KET_QUA KQ ON SINH_VIEN.MaSV = KQ.MaSV
WHERE KQ.MaSV LIKE 'PH00456';

-- Câu 3: Cho biết số sinh viên của khóa K15.3: MaKhoa, TenKhoa, Tổng số SV.

-- Câu 4: Cho biết thông tin sinh viên chưa học môn có mã COM2012: MaSV, Họ và tên, NgaySinh, phai.
-- Câu 5: Cho biết thông tin sinh viên của khoa K15.3, sắp tăng dần theo MaKH, giảm dần theo MaMH: MaSV, họ và tên, ngaysinh, MaKhoa, TenKhoa, MaMH, LanThi, Diem.
-- Câu 6: Sửa điểm của sinh viên PH00123, môn MOB1013 thành 8.
-- Câu 7: Cho biết thông tin sinh viên có tuổi từ 20-25
-- Câu 8: Chèn thêm 1 dòng dữ liệu vào bảng Khoa. Lưu ý các cột dữ liệu không được null.
-- Câu 9: Xóa thông tin các kết quả thi có điểm <5
