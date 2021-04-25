package com.tncnhan.android_giuaki;

public class SinhVien {
    String ID;
    String Name;

    public SinhVien(String ID, String name) {
        this.ID = ID;
        Name = name;
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
}
