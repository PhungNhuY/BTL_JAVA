create database QuanLySanPham;

use QuanLySanPham;

create table VaiTro(
	MaVaiTro int primary Key auto_increment,
    TenVaiTro nvarchar(50) ,
    unique(TenVaiTro)
);

create table TaiKhoan(
	MaTaiKhoan int primary key auto_increment,
    TenDangNhap char(50),
    MatKhau char(50),
    unique(TenDangNhap),
    MaVaiTro int,
    foreign key (MaVaiTro) references VaiTro(MaVaiTro)
);

create table PhanLoai(
	MaPhanLoai int primary key auto_increment,
    TenPhanLoai nvarchar(100),
    unique(TenPhanLoai)
);

create table SanPham(
	MaSanPham int primary key auto_increment,
    TenSanPham nvarchar(100),
	Gia int,
    SoLuong int,
    MoTa text,
    MaPhanLoai int,
    unique(TenSanPham),
    foreign key (MaPhanLoai) references PhanLoai(MaPhanLoai)
);

insert into VaiTro(TenVaiTro) values ('Người quản trị');
insert into VaiTro(TenVaiTro) values ('Nhân viên');

insert into TaiKhoan(TenDangNhap, MatKhau, MaVaiTro) values ('admin', 'admin', 1);
insert into TaiKhoan(TenDangNhap, MatKhau, MaVaiTro) values ('NhanVien', 'NhanVien', 2);

insert into PhanLoai(TenPhanLoai) values ('tủ lạnh');
insert into PhanLoai(TenPhanLoai) values ('máy giặt');
insert into PhanLoai(TenPhanLoai) values ('quạt điện');

insert into SanPham(TenSanPham, Gia, SoLuong, MoTa, MaPhanLoai)
values ('Tủ lạnh Toshiba', 1000000, 5, 'đây là mô tả', 1);
insert into SanPham(TenSanPham, Gia, SoLuong, MoTa, MaPhanLoai)
values ('Tủ lạnh SamSung', 900000, 8, 'đây là mô tả', 1);
insert into SanPham(TenSanPham, Gia, SoLuong, MoTa, MaPhanLoai)
values ('Tủ lạnh Hitachi', 1234567, 0, 'đây là mô tả', 1);

insert into SanPham(TenSanPham, Gia, SoLuong, MoTa, MaPhanLoai)
values ('Máy giặt Toshiba', 123456, 1, 'đây là mô tả', 2);
insert into SanPham(TenSanPham, Gia, SoLuong, MoTa, MaPhanLoai)
values ('Máy giặt SamSung', 9876543, 2, 'đây là mô tả', 2);
insert into SanPham(TenSanPham, Gia, SoLuong, MoTa, MaPhanLoai)
values ('Máy giặt Hitachi', 1111111, 3, 'đây là mô tả', 2);

insert into SanPham(TenSanPham, Gia, SoLuong, MoTa, MaPhanLoai)
values ('Quạt điện Toshiba', 120000, 1, 'đây là mô tả', 3);
insert into SanPham(TenSanPham, Gia, SoLuong, MoTa, MaPhanLoai)
values ('Quạt điện SamSung', 130000, 2, 'đây là mô tả', 3);
insert into SanPham(TenSanPham, Gia, SoLuong, MoTa, MaPhanLoai)
values ('Quạt điện Hitachi', 140000, 3, 'đây là mô tả', 3);