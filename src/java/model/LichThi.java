/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Long Coi
 */
public class LichThi {
    private int id;
    private Date ngayThi;
    private Date gioThi;
    private int thoiGianLamBai;
    private String moTa;
    private PhongThi phongThi;
    private ChungChi chungChi;

    public LichThi() {
    }

    public LichThi(int id, Date ngayThi, Date gioThi, int thoiGianLamBai, String moTa, PhongThi phongThi, ChungChi chungChi) {
        this.id = id;
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
        this.thoiGianLamBai = thoiGianLamBai;
        this.moTa = moTa;
        this.phongThi = phongThi;
        this.chungChi = chungChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public Date getGioThi() {
        return gioThi;
    }

    public void setGioThi(Date gioThi) {
        this.gioThi = gioThi;
    }

    public int getThoiGianLamBai() {
        return thoiGianLamBai;
    }

    public void setThoiGianLamBai(int thoiGianLamBai) {
        this.thoiGianLamBai = thoiGianLamBai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public PhongThi getPhongThi() {
        return phongThi;
    }

    public void setPhongThi(PhongThi phongThi) {
        this.phongThi = phongThi;
    }

    public ChungChi getChungChi() {
        return chungChi;
    }

    public void setChungChi(ChungChi chungChi) {
        this.chungChi = chungChi;
    }

    @Override
    public String toString() {
        return "LichThi{" + "id=" + id + ", ngayThi=" + ngayThi + ", gioThi=" + gioThi + ", thoiGianLamBai=" + thoiGianLamBai + ", moTa=" + moTa + ", phongThi=" + phongThi + ", chungChi=" + chungChi + '}';
    }
    
    
}
