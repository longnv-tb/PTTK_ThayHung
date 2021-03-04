/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Long Coi
 */
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import model.ThanhVien;
 
public class ThanhVienDAO extends DAO{
 
    public ThanhVienDAO() {
        super();
    }
     
    public boolean checkLogin(ThanhVien tv){
        boolean kq = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(tv.getTenDangNhap().contains("true") || tv.getTenDangNhap().contains("=")|| tv.getMatKhau().contains("true") || tv.getMatKhau().contains("="))
            return false;
        String sql = "{call checkLogin(?,?)}";
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,tv.getTenDangNhap());
            cs.setString(2,tv.getMatKhau());
            ResultSet rs = cs.executeQuery();
            
            if(rs.next()){
                tv.setId(rs.getInt("id"));
                tv.setVaiTro(rs.getString("vaitro"));
                tv.setTen(rs.getString("ten"));
                tv.setNgaySinh(rs.getDate("ngaySinh"));
                tv.setGioiTinh(rs.getString("gioiTinh"));
                tv.setDiaChi(rs.getString("diaChi"));
                tv.setEmail(rs.getString("email"));
                tv.setVaiTro(rs.getString("vaiTro"));
                tv.setSdt(rs.getString("sdt"));
                kq = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
            kq = false;
        }
        System.out.println(kq);
        return kq;
    }
    
//    public boolean checkLogin(ThanhVien tv){
//        String sql = "SELECT * FROM thanhvien WHERE tenDangNhap=? AND matKhau=?";
//    }
    
//    public static void main(String[] args) {
//        ThanhVien tv = new ThanhVien();
//        tv.setTenDangNhap("long");
//        tv.setMatKhau("123455");
//        ThanhVienDAO tvDao = new ThanhVienDAO();
//        if(tvDao.checkLogin(tv)){
//            System.out.println(tv);
//        }
//    }
}