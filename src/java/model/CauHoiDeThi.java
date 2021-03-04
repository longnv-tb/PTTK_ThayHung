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
public class CauHoiDeThi {
    private int id;
    private CauHoi cauHoi;

    public CauHoiDeThi() {
    }

    public CauHoiDeThi(CauHoi cauHoi) {
        this.cauHoi = cauHoi;
    }

    public int getId() {
        return id;
    }

    public CauHoi getCauHoi() {
        return cauHoi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCauHoi(CauHoi cauHoi) {
        this.cauHoi = cauHoi;
    }

    @Override
    public String toString() {
        return "CauHoiDeThi{" + "id=" + id + ", cauHoi=" + cauHoi + '}';
    }
}
