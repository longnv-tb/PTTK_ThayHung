/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.CauHoiDeThi;
import model.DeThi;

/**
 *
 * @author Long Coi
 */
public class DeThiDAO extends DAO{
    public DeThiDAO(){
        super();
    }
    
    public boolean addDeThi(DeThi dt){
        String sql= "insert into dethi (moTa, maDe, idChungChi, idLichThi, idNhanVienRaDe) values (?,?,?,?,?);";
        String sqlAddCauHoiDeThi = "insert into cauhoidethi (idCauHoi, idDeThi) values (?,?);";
        boolean result = true;
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,dt.getMoTa());
            ps.setString(2, dt.getMaDe());
            ps.setInt(3, dt.getChungChi().getId());
            ps.setInt(4, dt.getLichThi().getId());
            ps.setInt(5, dt.getNhanVienRaDe().getId());
            
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()){
                dt.setId(generatedKeys.getInt(1));
                
                /*insert cau hoi de thi*/
                for(CauHoiDeThi chdt: dt.getCauHoiDeThi()){
                    ps = con.prepareStatement(sqlAddCauHoiDeThi, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, chdt.getCauHoi().getId());
                    ps.setInt(2, dt.getId());
                    ps.executeUpdate();
                    generatedKeys = ps.getGeneratedKeys();
                    if(generatedKeys.next()){
                        chdt.setId(generatedKeys.getInt(1));
                    }
                }
            }
            con.commit();
        }catch(Exception e){
            result = false;
            try{
                con.rollback();
            }catch(Exception ex){
                result = false;
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            try{
                con.setAutoCommit(true);
            }catch(Exception e){
                result = false;
                e.printStackTrace();
            }
        }
        return result;
    }
}
