package com.tncnhan.android_giuaki;

import java.util.ArrayList;

public class PhieuCham {

    private int maPhieu;
    private String HoTenGV;
    private String ngayGiao;
    private ArrayList<ThongTinChamBai> thongTinChamBai;

    public PhieuCham(int maPhieu, String hoTenGV, String ngayGiao, ArrayList<ThongTinChamBai> thongTinChamBai) {
        this.maPhieu = maPhieu;
        this.HoTenGV = hoTenGV;
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

    public String getHoTenGV() {
        return HoTenGV;
    }

    public void setHoTenGV(String hoTenGV) {
        HoTenGV = hoTenGV;
    }

    public ArrayList<ThongTinChamBai> getThongTinChamBai() {
        return thongTinChamBai;
    }

    public void setThongTinChamBai(ArrayList<ThongTinChamBai> thongTinChamBai) {
        this.thongTinChamBai = thongTinChamBai;
    }
}
