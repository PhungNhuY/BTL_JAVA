/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RunProject;

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
}
