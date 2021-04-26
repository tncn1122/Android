package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DSSVNhapDiemActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    DBHelper DBhelper;
    ArrayList<Diem> dsDiem  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dssv_nhapdiem_layout);
        // GET THONG TIN USER
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        int role= sharedPreferences.getInt("role",0);
        ImageButton imgbtn_addDiem= findViewById(R.id.btnThem);
        EditText NhapDiem = findViewById(R.id.edtDiem);

        if(role==1){
            imgbtn_addDiem.setVisibility(View.INVISIBLE);
        }else if(role ==0 ){
            imgbtn_addDiem.setVisibility(View.VISIBLE);
        }
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        Cursor dt;
        DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);

        dt= DBhelper.GetData("select student.studentid, student.studentname, score.score, class.classname from (student inner join score on student.studentid = score.studentid) inner join class on score.classid = class.classid  where class.classid = '" + message + "'" );
        while(dt.moveToNext())
        {
            Log.d("MSV", dt.getString(0) + " " + dt.getString(2));
            SinhVien sv = new SinhVien(dt.getString(0), dt.getString(1));
            MonHoc mh = new MonHoc(message, dt.getString(3),0,null);
            Diem diem = new Diem(sv,mh,Float.parseFloat(dt.getString(2)));
            dsDiem.add(diem);
        }
        CustomListAdapter_DSDIEM adapter = new CustomListAdapter_DSDIEM(dsDiem);

        ListView listView= findViewById(R.id.lvDSDiem);
        listView.setAdapter(adapter);
        // thêm điểm vào db
        imgbtn_addDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Diem it:dsDiem)
                {
                    DBhelper= new DBHelper(DSSVNhapDiemActivity.this,"qlcd.sqlite",null,1);
                    DBhelper.QueryData("insert into score values('" + it.sv.getID() + "','"
                            + it.mh.getMaMH() +"',"
                            + it.diem + ")");
                }
                Toast.makeText(DSSVNhapDiemActivity.this, "thêm danh sách điểm thành công!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}