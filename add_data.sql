use quanlysanpham;

-- taikhoan
insert into taikhoan(TenDangNhap,MatKhau,HoTen,SoDienThoai,NgaySinh,Quyen) 
values ("PhungNhuY","1","Phùng Như Ý","0383844686","2001-02-28","nhanvien");
insert into taikhoan(TenDangNhap,MatKhau,HoTen,SoDienThoai,NgaySinh,Quyen) 
values ("TruongThiThuPhuong","1","Trương Thị Thu Phương","0966504386","2001-07-04","nhanvien");
insert into taikhoan(TenDangNhap,MatKhau,Quyen) 
values ("NguyenThiTraMy","1","nhanvien");
insert into taikhoan(TenDangNhap,MatKhau,HoTen,SoDienThoai,NgaySinh,Quyen) 
values ("admin","1","","",null,"quanly");

-- danh muc
insert into danhmuc(TenDanhMuc, MoTa)
values ("áo thun", "day la mo ta");
insert into danhmuc(TenDanhMuc, MoTa)
values ("áo sơ mi", "day la mo ta");
insert into danhmuc(TenDanhMuc, MoTa)
values ("quần cộc", "day la mo ta");
insert into danhmuc(TenDanhMuc, MoTa)
values ("quần bò", "day la mo ta");

-- san pham
insert into sanpham(TenSanPham, MaDanhMuc, DonViTinh, SoLuong, DonGia, KichCo, MoTa)
values ("áo thun nam",1, "chiếc", 10, 50000, "S", "mota");
insert into sanpham(TenSanPham, MaDanhMuc, DonViTinh, SoLuong, DonGia, KichCo, MoTa)
values ("áo thun nam",1, "chiếc", 12, 50000, "M", "mota");
insert into sanpham(TenSanPham, MaDanhMuc, DonViTinh, SoLuong, DonGia, KichCo, MoTa)
values ("áo thun nữ",1, "chiếc", 11, 50000, "S", "mota");
insert into sanpham(TenSanPham, MaDanhMuc, DonViTinh, SoLuong, DonGia, KichCo, MoTa)
values ("áo thun nữ",1, "chiếc", 12, 50000, "M", "mota");
insert into sanpham(TenSanPham, MaDanhMuc, DonViTinh, SoLuong, DonGia, KichCo, MoTa)
values ("áo sơ mi nam",2, "chiếc", 2, 100000, "S", null);
insert into sanpham(TenSanPham, MaDanhMuc, DonViTinh, SoLuong, DonGia, KichCo, MoTa)
values ("Quần cộc đen",3, "chiếc", 5, 120000, "M", "");
insert into sanpham(TenSanPham, MaDanhMuc, DonViTinh, SoLuong, DonGia, KichCo, MoTa)
values ("quần bò GAP",4, "chiếc", 0, 100000, "L", "");
select * from danhmuc;


-- hoa don
insert into hoadon(TenKhachHang, SoDienThoai, ThoiGianXuat, MaTaiKhoan, TongTien)
values ("Khach Hang 1", "123456789", "2022-06-04", 1, 100000);
insert into hoadon(TenKhachHang, SoDienThoai, ThoiGianXuat, MaTaiKhoan, TongTien)
values ("Khach Hang 1", "123456789", "2022-06-04", 1, 150000);

-- hoadon_sanpham
insert into hoadon_sanpham(MaHoaDon, MaSanPham, SoLuong)
values (1, 1, 1);
insert into hoadon_sanpham(MaHoaDon, MaSanPham, SoLuong)
values (1, 2, 1);
insert into hoadon_sanpham(MaHoaDon, MaSanPham, SoLuong)
values (2, 4, 1);
insert into hoadon_sanpham(MaHoaDon, MaSanPham, SoLuong)
values (2, 5, 1);