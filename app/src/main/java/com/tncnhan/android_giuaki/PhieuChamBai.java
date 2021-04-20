package com.tncnhan.android_giuaki;

import java.util.ArrayList;

public class PhieuChamBai {
    private int maPhieu;
    private String ngayGiao;
    private ArrayList<ThongTinChamBai> thongTinChamBai;

    public PhieuChamBai(int maPhieu, String ngayGiao, ArrayList<ThongTinChamBai> thongTinChamBai) {
        this.maPhieu = maPhieu;
        this.ngayGiao = ngayGiao;
        this.thongTinChamBai = thongTinChamBai;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(String ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public ArrayList<ThongTinChamBai> getThongTinChamBai() {
        return thongTinChamBai;
    }

    public void setThongTinChamBai(ArrayList<ThongTinChamBai> thongTinChamBai) {
        this.thongTinChamBai = thongTinChamBai;
    }

    public int getThanhToan(){
        int tong = 0;
        for(ThongTinChamBai item : thongTinChamBai)
            tong += item.getTong();
        return tong;
    }
}
