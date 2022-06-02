create database QuanLySanPham;

use quanlysanpham;

create table TaiKhoan(
	MaTaiKhoan int primary Key auto_increment,
    TenDangNhap varchar(32) not null,
    MatKhau varchar(32) not null,
    HoTen nvarchar(64),
    SoDienThoai varchar(11),
    NgaySinh date,
    Quyen varchar(10) not null,
    NgayTao datetime default current_timestamp,
    NgayCapNhat datetime default current_timestamp on update current_timestamp,
    unique(TenDangNhap)
);

create table HoaDon(
	MaHoaDon int primary key auto_increment,
    MaTaiKhoan int not null, 
    TenKhachHang nvarchar(64),
    SoDienThoai varchar(11),
    ThoiGianXuat datetime default current_timestamp,
    TongTien int not null,
    foreign key (MaTaiKhoan) references TaiKhoan(MaTaiKhoan) on delete no action
);

create table DanhMuc(
	MaDanhMuc int primary key auto_increment,
    TenDanhMuc nvarchar(128) not null,
    MoTa text,
    NgayTao datetime default current_timestamp,
    NgayCapNhat datetime default current_timestamp on update current_timestamp,
    unique(TenDanhMuc)
);

create table SanPham(
	MaSanPham int primary key auto_increment,
    TenSanPham nvarchar(128) not null,
    MaDanhMuc int,
    DonViTinh nvarchar(32),
    SoLuong int default 0,
    DonGia int,
    KichCo nvarchar(32),
    MoTa text,
    NgayTao datetime default current_timestamp,
    NgayCapNhat datetime default current_timestamp on update current_timestamp,
    foreign key (MaDanhMuc) references DanhMuc(MaDanhMuc) on delete set null
);

create table HoaDon_SanPham(
	MaHoaDon int,
    MaSanPham int,
    SoLuong int,
    constraint pk_HoaDon_SanPham primary key (MaHoaDon, MaSanPham),
    foreign key (MaHoaDon) references HoaDon(MaHoaDon) on delete no action,
    foreign key (MaSanPham) references SanPham(MaSanPham) on delete no action
);