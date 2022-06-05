/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.sql.Date;

/**
 *
 * @author nhu y phung
 */
public class TaiKhoanObject {
    private int maTaiKhoan;
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private String SoDienThoai;
    private String ngaySinh; 
    private String quyen;

    public TaiKhoanObject(int maTaiKhoan, String tenDangNhap, String matKhau, String hoTen, String SoDienThoai, String ngaySinh, String quyen) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.SoDienThoai = SoDienThoai;
        this.ngaySinh = ngaySinh;
        this.quyen = quyen;
    }

    public TaiKhoanObject(String tenDangNhap, String matKhau, String hoTen, String SoDienThoai, String ngaySinh, String quyen) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.SoDienThoai = SoDienThoai;
        this.ngaySinh = ngaySinh;
        this.quyen = quyen;
    }

    public TaiKhoanObject() {
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }
    
    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
}
