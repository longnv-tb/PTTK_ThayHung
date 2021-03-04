/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.NhanVien;
import model.NhanVienRaDe;
import model.ThanhVien;

/**
 *
 * @author Long Coi
 */
public class NhanVienRaDeDAO extends DAO{
    public NhanVienRaDeDAO(){
        super();
    }
    
    public NhanVienRaDe getNhanVienRaDe(NhanVien nv){
        String sql = "select * from nhanvienrade where id = ?";
        NhanVienRaDe nvrd = null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nv.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nvrd = new NhanVienRaDe();
                nvrd.setId(rs.getInt("id"));
                nvrd.setViTri(nv.getViTri());
                nvrd.setDiaChi(nv.getDiaChi());
                nvrd.setEmail(nv.getEmail());
                nvrd.setGioiTinh(nv.getGioiTinh());
                nvrd.setMatKhau(nv.getMatKhau());
                nvrd.setNgaySinh(nv.getNgaySinh());
                nvrd.setSdt(nv.getSdt());
                nvrd.setTen(nv.getTen());
                nvrd.setTenDangNhap(nv.getTenDangNhap());
                nvrd.setVaiTro(nv.getVaiTro());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nvrd;
    }
}
