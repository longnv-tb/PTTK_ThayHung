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
public class LuaChon {
    private int id;
    private String noiDung;
    private boolean isTrue;

    public LuaChon() {
    }

    public LuaChon(int id, String noiDung, boolean isTrue) {
        this.id = id;
        this.noiDung = noiDung;
        this.isTrue = isTrue;
    }

    public int getId() {
        return id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public boolean isIsTrue() {
        return isTrue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    @Override
    public String toString() {
        return "LuaChon{" + "id=" + id + ", noiDung=" + noiDung + ", isTrue=" + isTrue + '}';
    }
}
