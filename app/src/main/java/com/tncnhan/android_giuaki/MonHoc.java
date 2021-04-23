package com.tncnhan.android_giuaki;

public class MonHoc {
    private String maMH;
    private String tenMH;
    private int chiPhi;
    private String Count;

    public MonHoc(String maMH, String tenMH, int chiPhi, String Count) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.chiPhi = chiPhi;
        this.Count = Count;
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

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }
    @Override
    public String toString(){
        return this.getTenMH();
    }
}
