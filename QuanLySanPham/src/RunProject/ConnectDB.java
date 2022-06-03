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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nhu y phung
 */
public class ConnectDB {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
 
    public ConnectDB(){
 
        String URL = "jdbc:mysql://127.0.0.1:3306/quanlysanpham"; 
        String USERNAME = "root";
        String PASSWORD = "admin";
        // trong đó : 127.0.0.1:3306/quanlysanpham là tên và đường dẫn tới CSDL.
        try {
            // Nạp driver cho việc kết nối
            Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.print("Kết nối thành công\n");
        } catch (SQLException e) {
            System.out.print("Kết nối thất bại\n");
            e.printStackTrace();
        }
    }
    
    public ArrayList<TaiKhoanObject> dsTaiKhoan(){
        ArrayList<TaiKhoanObject>dsTKhoan=new ArrayList<>();
        try{
            String sql="SELECT * FROM taikhoan";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                TaiKhoanObject tk=new TaiKhoanObject();
                tk.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setHoTen(rs.getString("HoTen"));
                tk.setSoDienThoai(rs.getString("SoDienThoai"));
                tk.setNgaySinh(rs.getDate("NgaySinh"));
                tk.setQuyen(rs.getString("Quyen"));
                dsTKhoan.add(tk);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dsTKhoan;
    }
    
    public ArrayList<SanPhamObject> dsSanPham(){
        ArrayList<SanPhamObject> dsSanPham = new ArrayList<SanPhamObject>();
        try{
            String sql="SELECT * FROM sanpham";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                SanPhamObject sp = new SanPhamObject();
                sp.setMaSanPham(rs.getInt("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                sp.setDonViTinh(rs.getInt("DonViTinh"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(sr.getInt("DonGia"));
                sp.setKichCo(rs.getString("KichCo"));
                sp.setMoTa(rs.getString("MoTa"));
                dsSanPham.add(sp);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dsSanPham;
    }
    
    public ArrayList<HoaDon_SanPhamObject> dsHoaDon_SanPham(){
        ArrayList<HoaDon_SanPhamObject> dsHoaDon_SanPham = new ArrayList<HoaDon_SanPhamObject>();
        try{
            String sql="SELECT * FROM hoadon_sanpham";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                HoaDon_SanPhamObject temp = new HoaDon_SanPhamObject();
                temp.setMaHoaDon(rs.getInt("MaHoaDon"));
                temp.setMaSanPham(rs.getInt("MaSanPham"));
                temp.setSoLuong(rs.getInt("SoLuong"));
                dsHoaDon_SanPham.add(temp);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dsHoaDon_SanPham;
    }
    
    public ArrayList<HoaDonObject> dsHoaDon(){
        ArrayList<HoaDonObject> dsHoaDon = new ArrayList<HoaDonObject>();
        try{
            String sql="SELECT * FROM hoadon";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                HoaDonObject temp = new HoaDonObject();
                temp.setMaHoaDon(rs.getInt("MaHoaDon"));
                temp.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                temp.setTenKhachHang(rs.getString("TenKhachHanh"));
                temp.setSoDienThoai(rs.getString("SoDienThoai"));
                temp.setThoiGianXuat(rs.getDate("ThoiGianXuat"));
                dsHoaDon.add(temp);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dsHoaDon;
    }
    
    public ArrayList<DanhMucObject> dsDanhMuc(){
        ArrayList<DanhMucObject> dsDanhMuc = new ArrayList<DanhMucObject>();
        try{
            String sql="SELECT * FROM hoadon";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                DanhMucObject temp = new DanhMucObject();
                temp.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                temp.setTenDanhMuc(rs.getString("TenDanhMuc"));
                temp.setMoTa(rs.getString("MoTa"));
                dsDanhMuc.add(temp);
            }
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dsDanhMuc;
    }
}