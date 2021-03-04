/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Long Coi
 */
public class BaiThi {
    private int id;
    private Date gioNop;
    private float ketQua;
    private ThiSinhThi thiSinhThi;
    private ArrayList<LuaChonCuaThiSinh> luaChonCuaThiSinh;

    public BaiThi() {
    }

    public BaiThi(int id, Date gioNop, float ketQua, ThiSinhThi thiSinhThi, ArrayList<LuaChonCuaThiSinh> luaChonCuaThiSinh) {
        this.id = id;
        this.gioNop = gioNop;
        this.ketQua = ketQua;
        this.thiSinhThi = thiSinhThi;
        this.luaChonCuaThiSinh = luaChonCuaThiSinh;
    }
    
    
}
