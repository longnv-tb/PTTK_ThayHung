/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.NhanVien;
import model.ThanhVien;

/**
 *
 * @author Long Coi
 */
public class NhanVienDAO extends DAO{
    public NhanVienDAO(){
        super();
    }
    
    public NhanVien getNhanVien(ThanhVien tv){
        String sql = "select * from nhanvien where id = ?";
        NhanVien nv = null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, tv.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nv = new NhanVien();
                nv.setId(rs.getInt("id"));
                nv.setViTri(rs.getString("viTri"));
                nv.setDiaChi(tv.getDiaChi());
                nv.setEmail(tv.getEmail());
                nv.setGioiTinh(tv.getGioiTinh());
                nv.setMatKhau(tv.getMatKhau());
                nv.setNgaySinh(tv.getNgaySinh());
                nv.setSdt(tv.getSdt());
                nv.setTen(tv.getTen());
                nv.setTenDangNhap(tv.getTenDangNhap());
                nv.setVaiTro(tv.getVaiTro());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nv;
    }
}
