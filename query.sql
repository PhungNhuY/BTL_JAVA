select sanpham.MaSanPham, 
		sanpham.TenSanPham, 
        sanpham.MaDanhMuc, 
        sanpham.DonViTinh, 
        sanpham.SoLuong as SoLuongCon,
        sanpham.DonGia,
        sanpham.KichCo,
        sanpham.MoTa,
		count(sanpham.MaSanPham) as SoLuongBan
from sanpham
inner join hoadon_sanpham on sanpham.MaSanPham = hoadon_sanpham.MaSanPham
group by MaSanPham;