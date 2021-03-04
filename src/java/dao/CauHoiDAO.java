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
import java.util.ArrayList;
import model.CauHoi;
import model.ChungChi;
import model.LuaChon;

/**
 *
 * @author Long Coi
 */
public class CauHoiDAO extends DAO {

    public CauHoiDAO() {
        super();
    }

    public ArrayList<CauHoi> searchCauHoi(String noiDung) {
        String sql = "select ch.id as idch, ch.noiDung as noiDungch, ch.mucDo as mucDoch, ch.idChungChi as idChungChi,\n"
                + "cc.id as idcc, cc.tenChungChi as tenChungChi, cc.tenNgoaiNgu as tenNgoaiNgu, cc.thangDiem as thangDiem, cc.thoiHan as thoiHan, cc.moTa as moTacc\n"
                + "from cauhoi ch, chungchi cc where ch.noidung LIKE ? AND cc.id = ch.idChungChi;";
        String getLuaChonSQl = "SELECT * FROM luachon WHERE idCauHoi = ?;";
        CauHoi ch = null;
        ChungChi cc = null;
        int i;
        ArrayList<CauHoi> listCauHoi = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + noiDung + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ch = new CauHoi();
                cc = new ChungChi();
                ch.setId(rs.getInt("idch"));
                ch.setNoiDung(rs.getString("noiDungch"));
                ch.setMucDo(rs.getString("mucDoch"));

                cc.setId(rs.getInt("idcc"));
                cc.setMoTa(rs.getString("moTacc"));
                cc.setTenChungChi(rs.getString("tenChungChi"));
                cc.setTenNgoaiNgu(rs.getString("tenNgoaiNgu"));
                cc.setThoiHan(rs.getInt("thoiHan"));
                cc.setThangDiem(rs.getFloat("thangDiem"));
                ch.setChungChi(cc);
                
                listCauHoi.add(ch);
            }

            for (CauHoi c : listCauHoi) {
                ps = con.prepareStatement(getLuaChonSQl);
                ps.setInt(1, c.getId());
                rs = ps.executeQuery();
                ArrayList<LuaChon> listLuaChon = new ArrayList<>();
                while (rs.next()) {
                    LuaChon lc = new LuaChon();
                    lc.setId(rs.getInt("id"));
                    lc.setNoiDung(rs.getString("noiDung"));
                    i = rs.getInt("isTrue");
                    if (i == 1) {
                        lc.setIsTrue(true);
                    } else {
                        lc.setIsTrue(false);
                    }
                    listLuaChon.add(lc);
                }
                c.setLuaChon(listLuaChon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCauHoi;
    }

    public boolean updateCauHoi(CauHoi ch) {
        boolean result = true;
        String sql = "UPDATE cauhoi SET noiDung=?, mucDo=? WHERE id=?";
        String updateLuaChonSQL = "UPDATE luachon SET noiDung=?, isTrue=? WHERE id=? AND idCauHoi=?";
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ch.getNoiDung());
            ps.setString(2, ch.getMucDo());
            ps.setInt(3, ch.getId());
            ps.execute();

            for (LuaChon lc : ch.getLuaChon()) {
                ps = con.prepareStatement(updateLuaChonSQL);
                ps.setString(1, lc.getNoiDung());
                if (lc.isIsTrue()) {
                    ps.setInt(2, 1);
                } else {
                    ps.setInt(2, 0);
                }
                ps.setInt(3, lc.getId());
                ps.setInt(4, ch.getId());
                ps.execute();
            }

            con.commit();
        } catch (SQLException e) {
            result = false;
            try {
                con.rollback();
            } catch (SQLException ex) {
                result = false;
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                result = false;
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public ArrayList<CauHoi> getCauHoiByMucDo(String mucDo){
        String sql = "select ch.id as idch, ch.noiDung as noiDungch, ch.mucDo as mucDoch,\n"
                + "cc.id as idcc, cc.tenChungChi as tenChungChi, cc.tenNgoaiNgu as tenNgoaiNgu, cc.thangDiem as thangDiem, cc.thoiHan as thoiHan, cc.moTa as moTacc\n"
                + "from cauhoi ch, chungchi cc where ch.mucDo = ? AND cc.id = ch.idChungChi;";
        String getLuaChonSQl = "SELECT * FROM luachon WHERE idCauHoi = ?;";
        CauHoi ch = null;
        ChungChi cc = null;
        int i;
        ArrayList<CauHoi> listCauHoi = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,mucDo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ch = new CauHoi();
                cc = new ChungChi();
                ch.setId(rs.getInt("idch"));
                ch.setNoiDung(rs.getString("noiDungch"));
                ch.setMucDo(rs.getString("mucDoch"));

                cc.setId(rs.getInt("idcc"));
                cc.setMoTa(rs.getString("moTacc"));
                cc.setTenChungChi(rs.getString("tenChungChi"));
                cc.setTenNgoaiNgu(rs.getString("tenNgoaiNgu"));
                cc.setThoiHan(rs.getInt("thoiHan"));
                cc.setThangDiem(rs.getFloat("thangDiem"));
                ch.setChungChi(cc);
                listCauHoi.add(ch);
            }

            for (CauHoi c : listCauHoi) {
                ps = con.prepareStatement(getLuaChonSQl);
                ps.setInt(1, c.getId());
                rs = ps.executeQuery();
                ArrayList<LuaChon> listLuaChon = new ArrayList<>();
                while (rs.next()) {
                    LuaChon lc = new LuaChon();
                    lc.setId(rs.getInt("id"));
                    lc.setNoiDung(rs.getString("noiDung"));
                    i = rs.getInt("isTrue");
                    if (i == 1) {
                        lc.setIsTrue(true);
                    } else {
                        lc.setIsTrue(false);
                    }
                    listLuaChon.add(lc);
                }
                c.setLuaChon(listLuaChon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCauHoi;
    }

    public static void main(String[] args) {
        ArrayList<CauHoi> listCH = new ArrayList<>();

        CauHoiDAO chDAO = new CauHoiDAO();
        listCH = chDAO.searchCauHoi("How");
        System.out.println("Output: " + listCH.size());
        for (CauHoi ch : listCH) {
            System.out.println(ch);
        }
    }
}
