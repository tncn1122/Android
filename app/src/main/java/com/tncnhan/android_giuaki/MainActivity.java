package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBHelper DBhelper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themthongtincham_layout);
//        String tenGV[] = {"Giáo viên 1", "Giáo viên 2", "Giáo viên 3", "Giáo viên 4", "Giáo viên 5"};
        String maPhieu[] = {"01","02","03","04","05"};
        String tenMH[] = {"Môn học 1","Môn học 2","Môn học 3","Môn học 4","Môn học 5"};
        ArrayAdapter<String> adapterMP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, maPhieu);
        ArrayAdapter<String> adapterMH = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tenMH);
        adapterMP.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        adapterMH.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        Spinner spnMP = (Spinner)findViewById(R.id.spnSoPhieu);
        Spinner spnMH = (Spinner)findViewById(R.id.spnTenMH);
        EditText edtSoBai = (EditText)findViewById(R.id.edtSoBai);
        Button btnThem = (Button)findViewById(R.id.btnThemThongTin);
//        DatePicker dpNgayGiao = (DatePicker)findViewById(R.id.dpPhieu);
        spnMH.setAdapter(adapterMH);
        spnMP.setAdapter(adapterMP);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, spnMP.getSelectedItem() + "\n" + spnMH.getSelectedItem() + "\n" + edtSoBai.getText(), Toast.LENGTH_SHORT).show();
            }
        });


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



//        ArrayList<ThongKe> thongKes = new ArrayList<>();
//        thongKes.add(new ThongKe(new MonHoc("MH01", "Môn học 1", 1000), 30000, 140000, 290000, 500000));
//        thongKes.add(new ThongKe(new MonHoc("MH02", "Môn học 2", 2000), 40000, 250000, 300000, 700000));
//        thongKes.add(new ThongKe(new MonHoc("MH03", "Môn học 3", 3000), 50000, 360000, 410000, 800000));
//        thongKes.add(new ThongKe(new MonHoc("MH04", "Môn học 4", 4000), 60000, 470000, 520000, 900000));
//        thongKes.add(new ThongKe(new MonHoc("MH05", "Môn học 5", 5000), 70000, 580000, 630000, 990000));

//        CustomListAdapter_ThongKe thongKe = new CustomListAdapter_ThongKe(thongKes);
//        ListView listView = findViewById(R.id.listTK);
//        listView.setAdapter(thongKe);
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
        Init_DB();
    }
    public void Init_DB(){
        DBhelper =new DBHelper(this,"qlcd.sqlite",null,1);
        DBhelper.QueryData("create table if not exists users(teacherid varchar(30) primary key,userpass varchar(30),userrole int,fullname nvarchar(100),phone nvarchar(20))");
        DBhelper.QueryData("create table if not exists reportcard( reportid int IDENTITY(1,1) primary key, teacherid varchar(30), delidate date, FOREIGN KEY (teacherid) REFERENCES users(teacherid) )");
        DBhelper.QueryData("create table if not exists class( classid varchar(20) primary key, classname varchar(30), price int )");
        DBhelper.QueryData("create table if not exists reportinfo( reportid int, classid varchar(20), primary key(reportid, classid), FOREIGN KEY (reportid) REFERENCES reportcard(reportid), FOREIGN KEY (classid) REFERENCES class(classid) )");
        DBhelper.QueryData("create table if not exists student( studentid varchar(30) primary key, studentname varchar(50) )");
        DBhelper.QueryData("create table if not exists score( studentid varchar(30), classid varchar(20), score float check(score >= 0 and score <= 10), primary key(studentid,classid), FOREIGN KEY (studentid) REFERENCES student(studentid), FOREIGN KEY (classid) REFERENCES class(classid) )");

        //DBhelper.QueryData("insert into users values('admi2n','123',0,'bcv','0123')");
//        DBhelper.QueryData("insert into reportcard (teacherid,delidate)values('admi2n',2020/05/10)");
//        DBhelper.QueryData("insert into class values('class1','class mot',12345)");
//        DBhelper.QueryData("insert into reportinfo values('1','class1')");
//        DBhelper.QueryData("insert into student values('s1','student1')");

        DBhelper.QueryData("insert into users values('admin','123',1,'Banh Cam Vinh','0123456789')");
        DBhelper.QueryData("insert into users values('user','123',0,'Pham Nhat Quan','0123456789')");


//        Cursor dt= DBhelper.GetData("select * from student");
//        dt.moveToNext();
//        Log.d("abcd",dt.getString(1) );
    }
}