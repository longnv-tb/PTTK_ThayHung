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
public class DeThi {
    private int id;
    private int tongSoCau;
    private String maDe;
    private String moTa;
    private ArrayList<CauHoiDeThi> cauHoiDeThi;
    private LichThi lichThi;
    private ChungChi chungChi;
    private NhanVienRaDe nhanVienRaDe;

    public DeThi() {
    }

    public DeThi(int id, int tongSoCau, String maDe, String moTa, ArrayList<CauHoiDeThi> cauHoiDeThi, LichThi lichThi, ChungChi chungChi, NhanVienRaDe nhanVienRaDe) {
        this.id = id;
        this.tongSoCau = tongSoCau;
        this.maDe = maDe;
        this.moTa = moTa;
        this.cauHoiDeThi = cauHoiDeThi;
        this.lichThi = lichThi;
        this.chungChi = chungChi;
        this.nhanVienRaDe = nhanVienRaDe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTongSoCau() {
        return tongSoCau;
    }

    public void setTongSoCau(int tongSoCau) {
        this.tongSoCau = tongSoCau;
    }

    public String getMaDe() {
        return maDe;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public ArrayList<CauHoiDeThi> getCauHoiDeThi() {
        return cauHoiDeThi;
    }

    public void setCauHoiDeThi(ArrayList<CauHoiDeThi> cauHoiDeThi) {
        this.cauHoiDeThi = cauHoiDeThi;
    }

    public LichThi getLichThi() {
        return lichThi;
    }

    public void setLichThi(LichThi lichThi) {
        this.lichThi = lichThi;
    }

    public ChungChi getChungChi() {
        return chungChi;
    }

    public void setChungChi(ChungChi chungChi) {
        this.chungChi = chungChi;
    }

    public NhanVienRaDe getNhanVienRaDe() {
        return nhanVienRaDe;
    }

    public void setNhanVienRaDe(NhanVienRaDe nhanVienRaDe) {
        this.nhanVienRaDe = nhanVienRaDe;
    }

    @Override
    public String toString() {
        return "DeThi{" + "id=" + id + ", tongSoCau=" + tongSoCau + ", maDe=" + maDe + ", moTa=" + moTa + ", cauHoiDeThi=" + cauHoiDeThi + ", lichThi=" + lichThi + ", chungChi=" + chungChi + ", nhanVienRaDe=" + nhanVienRaDe + '}';
    }
    
}
