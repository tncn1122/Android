package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DSSVActivity extends AppCompatActivity {
    DBHelper DBhelper;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dssv_layout);
        // GET THONG TIN USER
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        int role= sharedPreferences.getInt("role",0);
        ImageButton imgbtn_addsv= findViewById(R.id.imgbtn_addsv);
        ListView listView = findViewById(R.id.lvDSSV);

        if(role==0){
            imgbtn_addsv.setVisibility(View.GONE);
        }else if(role ==1 ){
            imgbtn_addsv.setVisibility(View.VISIBLE);
        }


        ArrayList<SinhVien> ArrSV  = new ArrayList<>();
        DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);
        Cursor dt= DBhelper.GetData("select * from student");
        while(dt.moveToNext())
        {
            Log.d("SelectSV", dt.getString(0) + " " + dt.getString(1));
            SinhVien SV = new SinhVien(dt.getString(0),dt.getString(1));
            ArrSV.add(SV);
        }
        CustomListAdapter_DSSV adapter = new CustomListAdapter_DSSV(ArrSV);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //do something
            }
        });


        imgbtn_addsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DSSVActivity.this, themsvActivity.class);
                startActivity(intent);
            }
        });
    }
}