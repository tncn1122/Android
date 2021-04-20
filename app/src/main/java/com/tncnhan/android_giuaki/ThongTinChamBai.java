package com.tncnhan.android_giuaki;

import java.util.ArrayList;

public class ThongTinChamBai {
    private MonHoc MH;
    private int soBai;

    public ThongTinChamBai(MonHoc MH, int soBai) {
        this.MH = MH;
        this.soBai = soBai;
    }

    public MonHoc getMH() {
        return MH;
    }

    public void setMH(MonHoc listMH) {
        this.MH = listMH;
    }

    public int getSoBai() {
        return soBai;
    }

    public void setSoBai(int soBai) {
        this.soBai = soBai;
    }

    public int getTong() {
        return soBai*MH.getChiPhi();
    }
}
