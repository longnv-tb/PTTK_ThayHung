/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ChungChi;

/**
 *
 * @author Long Coi
 */
public class ChungChiDAO extends DAO{
    public ChungChiDAO(){
        super();
    }
    
    public ArrayList<ChungChi> getChungChi(){
        String sql = "{call getChungChi()}";
        ArrayList<ChungChi> listCC = new ArrayList<>();
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                ChungChi cc = new ChungChi();
                cc.setId(rs.getInt("id"));
                cc.setMoTa(rs.getString("moTa"));
                cc.setTenChungChi(rs.getString("tenChungChi"));
                cc.setTenNgoaiNgu(rs.getString("tenNgoaiNgu"));
                cc.setThangDiem(rs.getFloat("thangDiem"));
                cc.setThoiHan(rs.getInt("thoiHan"));
                listCC.add(cc);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listCC;
    }
    
    public static void main(String[] args) {
        ArrayList<ChungChi> list = new ChungChiDAO().getChungChi();
        System.out.println(list);
    }
}
