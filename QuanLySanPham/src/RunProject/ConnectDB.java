/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RunProject;

import Object.DanhMucObject;
import Object.HoaDonObject;
import Object.HoaDon_SanPhamObject;
import Object.SanPhamObject;
import Object.TaiKhoanObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhu y phung
 */
public class ConnectDB {

    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public ConnectDB() {

        String URL = "jdbc:mysql://127.0.0.1:3306/quanlysanpham";
        String USERNAME = "root";
        String PASSWORD = "admin";
        // trong đó : 127.0.0.1:3306/quanlysanpham là tên và đường dẫn tới CSDL.
        try {
            try {
                // Nạp driver cho việc kết nối
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.print("Kết nối thành công\n");
        } catch (SQLException e) {
            System.out.print("Kết nối thất bại\n");
            // e.printStackTrace();
        }
    }

    public ArrayList<TaiKhoanObject> dsTaiKhoan() {
        ArrayList<TaiKhoanObject> dsTKhoan = new ArrayList<>();
        try {
            String sql = "SELECT * FROM taikhoan";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                TaiKhoanObject tk = new TaiKhoanObject();
                tk.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setHoTen(rs.getString("HoTen"));
                tk.setSoDienThoai(rs.getString("SoDienThoai"));
                tk.setNgaySinh(rs.getString("NgaySinh"));
                tk.setQuyen(rs.getString("Quyen"));
                dsTKhoan.add(tk);
            }
            rs.close();
        } catch (SQLException ex) {
        }
        return dsTKhoan;
    }

    public ArrayList<SanPhamObject> dsSanPham() {
        ArrayList<SanPhamObject> dsSanPham = new ArrayList<SanPhamObject>();
        try {
            String sql = "SELECT * FROM sanpham";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                SanPhamObject sp = new SanPhamObject();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setKichCo(rs.getString("KichCo"));
                sp.setMoTa(rs.getString("MoTa"));
                dsSanPham.add(sp);
            }
            rs.close();
        } catch (SQLException ex) {

        }
        return dsSanPham;
    }

    public ArrayList<HoaDon_SanPhamObject> dsHoaDon_SanPham() {
        ArrayList<HoaDon_SanPhamObject> dsHoaDon_SanPham = new ArrayList<HoaDon_SanPhamObject>();
        try {
            String sql = "SELECT * FROM hoadon_sanpham";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HoaDon_SanPhamObject temp = new HoaDon_SanPhamObject();
                temp.setMaHoaDon(rs.getInt("MaHoaDon"));
                temp.setMaSanPham(rs.getInt("MaSanPham"));
                temp.setSoLuong(rs.getInt("SoLuong"));
                dsHoaDon_SanPham.add(temp);
            }
            rs.close();
        } catch (SQLException ex) {
        }
        return dsHoaDon_SanPham;
    }

    public ArrayList<HoaDonObject> dsHoaDon() {
        ArrayList<HoaDonObject> dsHoaDon = new ArrayList<HoaDonObject>();
        try {
            String sql = "SELECT * FROM hoadon";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HoaDonObject temp = new HoaDonObject();
                temp.setMaHoaDon(rs.getInt("MaHoaDon"));
                temp.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                temp.setTenKhachHang(rs.getString("TenKhachHanh"));
                temp.setSoDienThoai(rs.getString("SoDienThoai"));
                temp.setThoiGianXuat(rs.getString("ThoiGianXuat"));
                dsHoaDon.add(temp);
            }
            rs.close();
        } catch (SQLException ex) {
        }
        return dsHoaDon;
    }

    public ArrayList<DanhMucObject> dsDanhMuc() {
        ArrayList<DanhMucObject> dsDanhMuc = new ArrayList<DanhMucObject>();
        try {
            String sql = "SELECT * FROM danhmuc";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                DanhMucObject temp = new DanhMucObject();
                temp.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                temp.setTenDanhMuc(rs.getString("TenDanhMuc"));
                temp.setMoTa(rs.getString("MoTa"));
                dsDanhMuc.add(temp);
            }
            rs.close();
        } catch (SQLException ex) {
        }
        return dsDanhMuc;
    }

    public boolean themDanhMuc(DanhMucObject dm) {

        try {
            String sql = "INSERT INTO danhmuc(TenDanhMuc, MoTa) "
                    + "VALUES('" + dm.getTenDanhMuc() + "',"
                    + "'" + dm.getMoTa() + "')";

            st = conn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public boolean suaDanhMuc(DanhMucObject dm) {
        try {
            String sql = "UPDATE danhmuc SET TenDanhMuc='" + dm.getTenDanhMuc() + "',MoTa='" + dm.getMoTa() + "' WHERE MaDanhMuc=" + dm.getMaDanhMuc();
            st = conn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public boolean themSanPham(SanPhamObject sp) {

        try {
            String sql = "INSERT INTO sanpham(TenSanPham, MaDanhMuc, DonViTinh, SoLuong, DonGia, KichCo, MoTa) "
                    + "VALUES('" + sp.getTenSanPham() + "',"
                    + "" + sp.getMaDanhMuc() + ","
                    + "'" + sp.getDonViTinh() + "',"
                    + "" + sp.getSoLuong() + ","
                    + "" + sp.getDonGia() + ","
                    + "'" + sp.getKichCo() + "',"
                    + "'" + sp.getMoTa() + "')";

            st = conn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public boolean suaSanPham(SanPhamObject sp) {
        try {
            String sql = "UPDATE sanpham SET TenSanPham='" + sp.getTenSanPham() + "',"
                    + "SoLuong=" + sp.getSoLuong() + ","
                    + "DonGia=" + sp.getDonGia() + ","
                    + "KichCo='" + sp.getKichCo() + "',"
                    + "MoTa='" + sp.getMoTa() + "',"
                    + "DonViTinh='" + sp.getDonViTinh() + "' WHERE MaSanPham='" + sp.getMaSanPham() + "'";
            st = conn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public void xoaSanPham(int ma) {
        try {
            String sql = "delete from sanpham where MaSanPham=" + ma;
            st = conn.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException ex) {
        }

    }

    public boolean themTaiKhoan(TaiKhoanObject tk) {

        try {
            String sql = "INSERT INTO taikhoan(TenDangNhap,MatKhau,HoTen,SoDienThoai,NgaySinh,Quyen) "
                    + "VALUES('" + tk.getTenDangNhap() + "',"
                    + "'" + tk.getMatKhau() + "',"
                    + "'" + tk.getHoTen() + "',"
                    + "'" + tk.getSoDienThoai() + "',"
                    + "'" + tk.getNgaySinh() + "',"
                    + "'" + tk.getQuyen() + "');";

            st = conn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public boolean suaNhanVien(TaiKhoanObject tk) {
        try {
            String sql = "UPDATE taikhoan SET MatKhau='" + tk.getMatKhau() + "',"
                    + "SoDienThoai='" + tk.getSoDienThoai() + "',"
                    + "HoTen='" + tk.getHoTen() + "',"
                    + "NgaySinh='" + tk.getNgaySinh() + "',"
                    + "Quyen='" + tk.getQuyen() + "' WHERE MaTaiKhoan=" + tk.getMaTaiKhoan() ;
            st = conn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public ArrayList<SanPhamObject> dsSanPhamBanTrongNgay() {
        ArrayList<SanPhamObject> dsSanPham = new ArrayList<SanPhamObject>();
        try {
            String sql = "select sanpham.MaSanPham, "
                    + "sanpham.TenSanPham, "
                    + "sanpham.MaDanhMuc, "
                    + "sanpham.DonViTinh, "
                    + "sanpham.SoLuong as SoLuongCon, "
                    + "sanpham.DonGia, "
                    + "sanpham.KichCo, "
                    + "sanpham.MoTa, "
                    + "count(sanpham.MaSanPham) as SoLuongBan "
                    + "from sanpham "
                    + "inner join hoadon_sanpham on sanpham.MaSanPham = hoadon_sanpham.MaSanPham "
                    + "group by MaSanPham; ";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                SanPhamObject sp = new SanPhamObject();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setSoLuong(rs.getInt("SoLuongCon"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setKichCo(rs.getString("KichCo"));
                sp.setMoTa(rs.getString("MoTa"));
                sp.setSoLuongBan(rs.getInt("SoLuongBan"));
                dsSanPham.add(sp);
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsSanPham;
    }

    public ArrayList<HoaDonObject> dsHoaDonTrongNgay() {
        ArrayList<HoaDonObject> dsHoaDon = new ArrayList<HoaDonObject>();
        try {
            String sql = "SELECT * FROM hoadon WHERE ThoiGianXuat='2022-06-04'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HoaDonObject temp = new HoaDonObject();
                temp.setMaHoaDon(rs.getInt("MaHoaDon"));
                temp.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                temp.setTenKhachHang(rs.getString("TenKhachHang"));
                temp.setSoDienThoai(rs.getString("SoDienThoai"));
                temp.setThoiGianXuat(rs.getString("ThoiGianXuat"));
                temp.setTongTien(rs.getInt("TongTien"));
                dsHoaDon.add(temp);
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsHoaDon;
    }

    public SanPhamObject getSanPhamById(int maSanPham) {
        SanPhamObject sp = new SanPhamObject();
        try {
            String sql = "SELECT * FROM sanpham WHERE MaSanPham = " + maSanPham;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setKichCo(rs.getString("KichCo"));
                sp.setMoTa(rs.getString("MoTa"));
            }
            rs.close();
        } catch (SQLException ex) {
        }
        return sp;
    }
    
    public int themHoaDon(HoaDonObject temp){
        try {
            //them hoa don
            String sql = "INSERT INTO hoadon(MaTaiKhoan, TenKhachHang, SoDienThoai, ThoiGianXuat, TongTien) "
                    + "VALUES(" + temp.getMaTaiKhoan()+ ","
                    + "'" + temp.getTenKhachHang()+ "',"
                    + "'" + temp.getSoDienThoai()+ "',"
                    + "'" + temp.getThoiGianXuat()+ "',"
                    + "" + temp.getTongTien()+ ")";
            System.out.println(sql);
            st = conn.createStatement();
            st.executeUpdate(sql);
            
            sql = "SELECT MAX(MaHoaDon) FROM hoadon";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            int mahoadon=0;
            while (rs.next()) {
                mahoadon = rs.getInt("max(MaHoaDon)");
            }
            rs.close();
            return mahoadon;
        } catch (SQLException ex) {
        }
        return 0;
    }
    
    public boolean themHoaDon_sanPham(int mahoadon, int masanpham, int soluong){
        
        try {
            String sql = "INSERT INTO hoadon_sanpham(MaHoaDon, MaSanPham, SoLuong) "
                    + "VALUES(" + String.valueOf(mahoadon)+ ","
                    + "" + String.valueOf(masanpham) + ","
                    + "" + String.valueOf(soluong) + ")";
            st = conn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return false;
    }
    
    public boolean giamSoLuong(int masanpham, int soluong){
        int soluonghienco = 0;
        try {
            String sql = "SELECT * FROM sanpham WHERE MaSanPham = " + masanpham;
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                soluonghienco = rs.getInt("SoLuong");
            }
            rs.close();
        } catch (SQLException ex) {
        }
        
        //sua
        try {
            String sql = "UPDATE sanpham SET SoLuong=" +String.valueOf(soluonghienco-soluong) +" WHERE MaSanPham=" + masanpham;
            st = conn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }
    
    public ArrayList<TaiKhoanObject> timKiemTaiKhoan(String text){
        ArrayList<TaiKhoanObject> result = new ArrayList<TaiKhoanObject>();
        try {
            String sql = "SELECT * FROM taikhoan WHERE HoTen LIKE '%"+text+"%'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                TaiKhoanObject tk = new TaiKhoanObject();
                tk.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setHoTen(rs.getString("HoTen"));
                tk.setSoDienThoai(rs.getString("SoDienThoai"));
                tk.setNgaySinh(rs.getString("NgaySinh"));
                tk.setQuyen(rs.getString("Quyen"));
                result.add(tk);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<DanhMucObject> timKiemDanhMuc(String text){
        ArrayList<DanhMucObject> result = new ArrayList<DanhMucObject>();
        try {
            String sql = "SELECT * FROM danhmuc WHERE TenDanhMuc LIKE '%"+text+"%'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                DanhMucObject temp = new DanhMucObject();
                temp.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                temp.setTenDanhMuc(rs.getString("TenDanhMuc"));
                temp.setMoTa(rs.getString("MoTa"));
                result.add(temp);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<SanPhamObject> timKiemSanPham(String text){
        ArrayList<SanPhamObject> result = new ArrayList<SanPhamObject>();
        try {
            String sql = "SELECT * FROM sanpham WHERE TenSanPham LIKE '%"+text+"%'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                SanPhamObject sp = new SanPhamObject();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setKichCo(rs.getString("KichCo"));
                sp.setMoTa(rs.getString("MoTa"));
                result.add(sp);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public TaiKhoanObject DangNhap(String taiKhoan, String matKhau){
        TaiKhoanObject ans = new TaiKhoanObject();
        ans.setMaTaiKhoan(-1);
        ans.setQuyen("");
        try {
            String sql = "SELECT * FROM taikhoan WHERE TenDangNhap='"+taiKhoan+"' AND MatKhau='"+matKhau+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                TaiKhoanObject tk = new TaiKhoanObject();
                tk.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setHoTen(rs.getString("HoTen"));
                tk.setSoDienThoai(rs.getString("SoDienThoai"));
                tk.setNgaySinh(rs.getString("NgaySinh"));
                tk.setQuyen(rs.getString("Quyen"));
                ans = tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ans;
    }
}
