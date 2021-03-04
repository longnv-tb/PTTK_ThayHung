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
public class ChungChi {
    private int id;
    private String tenNgoaiNgu, tenChungChi;
    private float thangDiem;
    private String moTa;
    private int thoiHan;

    public ChungChi() {
    }

    public ChungChi(int id, String tenNgoaiNgu, String tenChungChi, float thangDiem, String moTa, int thoiHan) {
        this.id = id;
        this.tenNgoaiNgu = tenNgoaiNgu;
        this.tenChungChi = tenChungChi;
        this.thangDiem = thangDiem;
        this.moTa = moTa;
        this.thoiHan = thoiHan;
    }

    public int getId() {
        return id;
    }

    public String getTenNgoaiNgu() {
        return tenNgoaiNgu;
    }

    public String getTenChungChi() {
        return tenChungChi;
    }

    public float getThangDiem() {
        return thangDiem;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getThoiHan() {
        return thoiHan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenNgoaiNgu(String tenNgoaiNgu) {
        this.tenNgoaiNgu = tenNgoaiNgu;
    }

    public void setTenChungChi(String tenChungChi) {
        this.tenChungChi = tenChungChi;
    }

    public void setThangDiem(float thangDiem) {
        this.thangDiem = thangDiem;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    @Override
    public String toString() {
        return "ChungChi{" + "id=" + id + ", tenNgoaiNgu=" + tenNgoaiNgu + ", tenChungChi=" + tenChungChi + ", thangDiem=" + thangDiem + ", moTa=" + moTa + ", thoiHan=" + thoiHan + '}';
    }
    
    
}
