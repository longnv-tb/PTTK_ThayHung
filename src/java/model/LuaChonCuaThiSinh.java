/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Long Coi
 */
class LuaChonCuaThiSinh {
    private int id;
    private LuaChon luaChon;
    private CauHoiDeThi cauHoiDeThi;

    public LuaChonCuaThiSinh() {
    }

    public LuaChonCuaThiSinh(int id, LuaChon luaChon, CauHoiDeThi cauHoiDeThi) {
        this.id = id;
        this.luaChon = luaChon;
        this.cauHoiDeThi = cauHoiDeThi;
    }
    
    
}
