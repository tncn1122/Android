package com.tncnhan.android_giuaki;

public class MonHoc {
    private String maMH;
    private String tenMH;
    private int chiPhi;

    public MonHoc(String maMH, String tenMH, int chiPhi) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.chiPhi = chiPhi;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(int chiPhi) {
        this.chiPhi = chiPhi;
    }
}
