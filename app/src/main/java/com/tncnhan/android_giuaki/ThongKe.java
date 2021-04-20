package com.tncnhan.android_giuaki;

public class ThongKe {
    private MonHoc MH;
    private int Q1;
    private int Q2;
    private int Q3;
    private int Q4;

    public ThongKe(MonHoc MH, int q1, int q2, int q3, int q4) {
        this.MH = MH;
        Q1 = q1;
        Q2 = q2;
        Q3 = q3;
        Q4 = q4;
    }

    public int getTong() {
        return Q1+Q2+Q3+Q4;
    }

    public MonHoc getMH() {
        return MH;
    }

    public void setMH(MonHoc MH) {
        this.MH = MH;
    }

    public int getQ1() {
        return Q1;
    }

    public void setQ1(int q1) {
        Q1 = q1;
    }

    public int getQ2() {
        return Q2;
    }

    public void setQ2(int q2) {
        Q2 = q2;
    }

    public int getQ3() {
        return Q3;
    }

    public void setQ3(int q3) {
        Q3 = q3;
    }

    public int getQ4() {
        return Q4;
    }

    public void setQ4(int q4) {
        Q4 = q4;
    }
}
