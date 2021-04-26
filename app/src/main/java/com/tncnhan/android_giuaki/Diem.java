package com.tncnhan.android_giuaki;

import android.widget.BaseAdapter;

public class Diem {
    SinhVien sv;
    MonHoc mh;
    float diem;

    public Diem(SinhVien sv, MonHoc mh, float diem) {
        this.sv = sv;
        this.mh = mh;
        this.diem = diem;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public MonHoc getMh() {
        return mh;
    }

    public void setMh(MonHoc mh) {
        this.mh = mh;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
}
