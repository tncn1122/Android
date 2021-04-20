package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongkechiphi_layout);

//        ArrayList<ThongTinChamBai> thongTinChamBais = new ArrayList<>();
//        thongTinChamBais.add(new ThongTinChamBai(new MonHoc("MH01", "Môn học 1", 10000), 30));
//        thongTinChamBais.add(new ThongTinChamBai(new MonHoc("MH02", "Môn học 2", 12000), 40));
//        thongTinChamBais.add(new ThongTinChamBai(new MonHoc("MH03", "Môn học 3", 15000), 60));
//
//        ArrayList<ThongTinChamBai> thongTinChamBais2 = new ArrayList<>();
//        thongTinChamBais2.add(new ThongTinChamBai(new MonHoc("MH04", "Môn học 4", 7000), 10));
//        thongTinChamBais2.add(new ThongTinChamBai(new MonHoc("MH05", "Môn học 5", 8000), 20));
//        thongTinChamBais2.add(new ThongTinChamBai(new MonHoc("MH06", "Môn học 6", 9000), 25));
//
//        ArrayList<ThongTinChamBai> thongTinChamBais3 = new ArrayList<>();
//        thongTinChamBais3.add(new ThongTinChamBai(new MonHoc("MH04", "Môn học 4", 7000), 10));
//        thongTinChamBais3.add(new ThongTinChamBai(new MonHoc("MH05", "Môn học 5", 8000), 20));
//        thongTinChamBais3.add(new ThongTinChamBai(new MonHoc("MH06", "Môn học 6", 9000), 25));
//
//        ArrayList<ThongTinChamBai> thongTinChamBais4 = new ArrayList<>();
//        thongTinChamBais4.add(new ThongTinChamBai(new MonHoc("MH04", "Môn học 4", 7000), 10));
//        thongTinChamBais4.add(new ThongTinChamBai(new MonHoc("MH05", "Môn học 5", 8000), 20));
//        thongTinChamBais4.add(new ThongTinChamBai(new MonHoc("MH06", "Môn học 6", 9000), 25));
//
//
//        ArrayList<PhieuChamBai> phieuChamBais = new ArrayList<>();
//        phieuChamBais.add(new PhieuChamBai(1, "09-04-1999", thongTinChamBais));
//        phieuChamBais.add(new PhieuChamBai(2, "09-04-1999", thongTinChamBais2));
//        phieuChamBais.add(new PhieuChamBai(2, "09-04-1999", thongTinChamBais3));
//        phieuChamBais.add(new PhieuChamBai(2, "09-04-1999", thongTinChamBais4));
//
//        CustomListAdapter_DSPhieu dsPhieu = new CustomListAdapter_DSPhieu(phieuChamBais);
//
//        ListView listView = findViewById(R.id.listDSPhieu);
//        listView.setAdapter(dsPhieu);



        ArrayList<ThongKe> thongKes = new ArrayList<>();
        thongKes.add(new ThongKe(new MonHoc("MH01", "Môn học 1", 1000), 30000, 140000, 290000, 500000));
        thongKes.add(new ThongKe(new MonHoc("MH02", "Môn học 2", 2000), 40000, 250000, 300000, 700000));
        thongKes.add(new ThongKe(new MonHoc("MH03", "Môn học 3", 3000), 50000, 360000, 410000, 800000));
        thongKes.add(new ThongKe(new MonHoc("MH04", "Môn học 4", 4000), 60000, 470000, 520000, 900000));
        thongKes.add(new ThongKe(new MonHoc("MH05", "Môn học 5", 5000), 70000, 580000, 630000, 990000));

        CustomListAdapter_ThongKe thongKe = new CustomListAdapter_ThongKe(thongKes);
        ListView listView = findViewById(R.id.listTK);
        listView.setAdapter(thongKe);
//        ArrayList<GiangVien> countryArrayList=new ArrayList<>();
//        countryArrayList.add(new GiangVien("GV01","XXXXXXX","1111111111"));
//        countryArrayList.add(new GiangVien("GV02","YYYYYYY","2222222222"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
//        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));


//        CustomListAdapter_DSGV adapter = new CustomListAdapter_DSGV(countryArrayList);

//        ListView listView= findViewById(R.id.lvDSGV);
//        listView.setAdapter(adapter);

    }
}