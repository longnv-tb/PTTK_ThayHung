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
public class PhongThi {
    private int id;
    private String ten;
    private int siSo;
    //private int conLai;

    public PhongThi() {
    }

    public PhongThi(int id, String ten, int siSo) {
        this.id = id;
        this.ten = ten;
        this.siSo = siSo;
    //    this.conLai = conLai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }
    
    
//    public int getConLai() {
//        return conLai;
//    }
//
//    public void setConLai(int conLai) {
//        this.conLai = conLai;
//    }
//    
//    

    @Override
    public String toString() {
        return "PhongThi{" + "id=" + id + ", ten=" + ten + ", siSo=" + siSo + '}';
    }
}
