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
public class TrungTam {
    private int id;
    private String ten, diaChi, moTa;
    private ArrayList<PhongThi> phongThi;

    public TrungTam() {
    }

    public TrungTam(int id, String ten, String diaChi, String moTa, ArrayList<PhongThi> phongThi) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.moTa = moTa;
        this.phongThi = phongThi;
    }
}
