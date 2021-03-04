/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.ChungChi;
import model.LichThi;
import model.PhongThi;

/**
 *
 * @author Long Coi
 */
public class LichThiDAO extends DAO{
    public LichThiDAO(){
        super();
    }
    
    public ArrayList<LichThi> getLichThiByChungChi(int idCC, Date date){
        ChungChi cc = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql1 = "SELECT * FROM chungchi where id=?;";
            ps = con.prepareStatement(sql1);
            ps.setInt(1, idCC);
            rs = ps.executeQuery();
            if(rs.next()){
                cc = new ChungChi();
                cc.setId(rs.getInt("id"));
                cc.setMoTa(rs.getString("moTa"));
                cc.setTenChungChi(rs.getString("tenChungChi"));
                cc.setTenNgoaiNgu(rs.getString("tenNgoaiNgu"));
                cc.setThangDiem(rs.getFloat("thangDiem"));
                cc.setThoiHan(rs.getInt("thoiHan"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ArrayList<LichThi> listLT = new ArrayList<>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        LichThi lt = null;
        PhongThi pt = null;
        String sql = "select lt.id as idlt, lt.ngayThi as ngayThi, lt.gioThi as gioThi, lt.moTa as moTalt, lt.thoiGianLamBai as thoiGianLamBai, \n"
                + "pt.id as idpt, pt.ten as tenpt, pt.siSo as siSo \n"
                + "from lichthi lt, phongthi pt where lt.idChungChi = ? AND lt.idPhongThi = pt.id AND lt.ngayThi > ?;";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,idCC);
            ps.setString(2, sdf1.format(date));
            rs = ps.executeQuery();
            while(rs.next()){
                lt = new LichThi();
                lt.setId(rs.getInt("idlt"));
                lt.setGioThi(rs.getTime("gioThi"));
                lt.setNgayThi(rs.getDate("ngayThi"));
                lt.setMoTa(rs.getString("moTalt"));
                lt.setThoiGianLamBai(rs.getInt("thoiGianLamBai"));
                
                pt = new PhongThi();
                pt.setId(rs.getInt("idpt"));
                pt.setSiSo(rs.getInt("siSo"));
                pt.setTen(rs.getString("tenpt"));
                lt.setPhongThi(pt);

                lt.setChungChi(cc);
                
                listLT.add(lt);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listLT;
    }
    
    public static void main(String[] args) {
        Date date = java.util.Calendar.getInstance().getTime();
        System.out.println(date);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf1.format(date));
        System.out.println(sdf2.format(date));
        ArrayList<LichThi> list = new LichThiDAO().getLichThiByChungChi(1,date);
        System.out.println(list);
    }
}
