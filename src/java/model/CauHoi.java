/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Long Coi
 */
public class CauHoi {
    private int id;
    private String noiDung, mucDo;
    private ArrayList<LuaChon> luaChon;
    private ChungChi chungChi;

    public CauHoi() {
    }

    public CauHoi(int id, String noiDung, String mucDo, ArrayList<LuaChon> luaChon, ChungChi chungChi) {
        this.id = id;
        this.noiDung = noiDung;
        this.mucDo = mucDo;
        this.luaChon = luaChon;
        this.chungChi = chungChi;
    }

    public int getId() {
        return id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public String getMucDo() {
        return mucDo;
    }

    public ArrayList<LuaChon> getLuaChon() {
        return luaChon;
    }

    public ChungChi getChungChi() {
        return chungChi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setMucDo(String mucDo) {
        this.mucDo = mucDo;
    }

    public void setLuaChon(ArrayList<LuaChon> luaChon) {
        this.luaChon = luaChon;
    }

    public void setChungChi(ChungChi chungChi) {
        this.chungChi = chungChi;
    }

    @Override
    public String toString() {
        return "CauHoi{" + "id=" + id + ", noiDung=" + noiDung + ", mucDo=" + mucDo + ", luaChon=" + luaChon + ", chungChi=" + chungChi + '}';
    }
}
