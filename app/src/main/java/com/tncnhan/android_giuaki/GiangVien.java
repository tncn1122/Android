package com.tncnhan.android_giuaki;

import java.util.ArrayList;

public class GiangVien {
    String ID;
    String Name;
    String SDT;
    ArrayList<PhieuChamBai> phieuChamBai;

    public GiangVien(String ID, String name, String SDT, ArrayList<PhieuChamBai> phieuChamBai) {
        this.ID = ID;
        Name = name;
        this.SDT = SDT;
        this.phieuChamBai = phieuChamBai;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public ArrayList<PhieuChamBai> getPhieuChamBai() {
        return phieuChamBai;
    }

    public void setPhieuChamBai(ArrayList<PhieuChamBai> phieuChamBai) {
        this.phieuChamBai = phieuChamBai;
    }
}
