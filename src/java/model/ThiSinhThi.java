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
public class ThiSinhThi {
    private int id;
    private String soBaoDanh;
    private Date ngayDangKy;
    private float lePhiThi;
    private ThiSinh thiSinh;
    private DeThi deThi;

    public ThiSinhThi() {
    }

    public ThiSinhThi(int id, String soBaoDanh, Date ngayDangKy, float lePhiThi, ThiSinh thiSinh, DeThi deThi) {
        this.id = id;
        this.soBaoDanh = soBaoDanh;
        this.ngayDangKy = ngayDangKy;
        this.lePhiThi = lePhiThi;
        this.thiSinh = thiSinh;
        this.deThi = deThi;
    }
    
}
