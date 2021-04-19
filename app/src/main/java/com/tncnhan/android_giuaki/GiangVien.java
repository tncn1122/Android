package com.tncnhan.android_giuaki;

public class GiangVien {
    String ID;
    String Name;
    String SDT;

    public GiangVien(String ID, String name, String SDT) {
        this.ID = ID;
        Name = name;
        this.SDT = SDT;
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
}
