create database QUAN_LY_KHACH_HANG
go

USE QUAN_LY_KHACH_HANG
go

create table KHACH_HANG
(
	MaKH varchar(10) not null,
	HoTenKH nvarchar(50) not null,
	DiaChi nvarchar(100),
	SoDT varchar(10),
	primary key (MaKH)
)
go

create table TAI_KHOAN
(
	SoTK varchar(15) not null,
	MaKH varchar(10) not null,
	NgayMoTK datetime,
	SoTien money,
	primary key (SoTK),
	foreign key (MaKH) references KHACH_HANG(MaKH),
	check (SoTien>=0)
)
go

create table GIAO_DICH
(
	MaGD varchar(10) not null,
	SoTK varchar(15) not null,
	ThoiGianGD datetime,
	SoTienGD money,
	MoTaGD nvarchar(60),
	SoDuTK money,
	primary key (MaGD),
	foreign key (SoTK) references TAI_KHOAN(SoTK),
	check (SoTienGD>=0),
	check (SoDuTK>=0)
)
go

--Nhập liệu bảng Khách hàng
Insert into KHACH_HANG(MaKH,HoTenKH,DiaChi,SoDT)
values ('KH01',N'Cao Văn Chỉnh',N' 03 ngõ Bà Triệu, Hai Bà Trưng, Hà Nội','0338878397');
Insert into KHACH_HANG(MaKH,HoTenKH,DiaChi,SoDT)
values ('KH02',N'Ngô Trung Hiếu',N'xã Đại Hợp, huyện Kiến Thụy, TP Hải Phòng','0339731812');
Insert into KHACH_HANG(MaKH,HoTenKH,DiaChi,SoDT)
values ('KH03',N'Đõ Xuân Hiếu',N'Nhật Tiến, xã Trường Yên, Chương Mỹ, Hà Nội','097396777');
Insert into KHACH_HANG(MaKH,HoTenKH,DiaChi,SoDT)
values ('KH04',N'Đinh Viét Khang',N'xã Yên Hợp, Quỳ Hợp, Nghệ An','0338269641');
Insert into KHACH_HANG(MaKH,HoTenKH,DiaChi,SoDT)
values ('KH05',N'Hà Thị Ngọc Hải',N'Thượng Đình, Thanh Xuân, Hà Nội','0941889768');
go

--Nhập liệu bảng Tài khoản
Insert into TAI_KHOAN(SoTK,MaKH,NgayMoTK,SoTien)
values ('068787158555325','KH01','2021-03-21',500);
Insert into TAI_KHOAN(SoTK,MaKH,NgayMoTK,SoTien)
values ('068102384811830','KH02','2018-04-16',1000);
Insert into TAI_KHOAN(SoTK,MaKH,NgayMoTK,SoTien)
values ('068648427929931','KH03','2019-12-31',1500);
Insert into TAI_KHOAN(SoTK,MaKH,NgayMoTK,SoTien)
values ('068969587281032','KH04','2021-08-05',900);
Insert into TAI_KHOAN(SoTK,MaKH,NgayMoTK,SoTien)
values ('068279408708433','KH05','2021-09-16',700);
go

--Nhập liệu bảng Giao dịch
Insert into GIAO_DICH(MaGD,SoTK,ThoiGianGD,SoTienGD,MoTaGD,SoDuTK)
values ('GD01','068787158555325','2022-01-01',100,N'Rút tiền tại ATM123',400);
Insert into GIAO_DICH(MaGD,SoTK,ThoiGianGD,SoTienGD,MoTaGD,SoDuTK)
values ('GD02','068102384811830','2022-01-01',500,N'Rút tiền tại ATM123',500);
Insert into GIAO_DICH(MaGD,SoTK,ThoiGianGD,SoTienGD,MoTaGD,SoDuTK)
values ('GD03','068102384811830','2022-01-11',500,N'Rút tiền tại ATM123',0);
Insert into GIAO_DICH(MaGD,SoTK,ThoiGianGD,SoTienGD,MoTaGD,SoDuTK)
values ('GD04','068969587281032','2022-01-01',500,N'Rút tiền tại ATM123',400);
Insert into GIAO_DICH(MaGD,SoTK,ThoiGianGD,SoTienGD,MoTaGD,SoDuTK)
values ('GD05','068279408708433','2022-01-01',300,N'Rút tiền tại ATM123',400);
go

select * from KHACH_HANG;
select * from TAI_KHOAN;
select * from GIAO_DICH; 