package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DSGVActivity extends AppCompatActivity {
    DBHelper DBhelper;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsgv_layout);
        // GET THONG TIN USER
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        int role= sharedPreferences.getInt("role",0);
        ImageButton imgbtn_addgv= findViewById(R.id.imgbtn_addgv);
        ListView listView = findViewById(R.id.lvDSGV);

        if(role==0){
            imgbtn_addgv.setVisibility(View.GONE);
        }else if(role ==1 ){
            imgbtn_addgv.setVisibility(View.VISIBLE);
        }


        ArrayList<GiangVien> ArrGV  = new ArrayList<>();
        DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);
        Cursor dt= DBhelper.GetData("select * from users where userrole = 0");
        while(dt.moveToNext())
        {
            Log.d("SelectGV", dt.getString(0) + " " + dt.getString(3));
            GiangVien GV = new GiangVien(dt.getString(0),dt.getString(3),dt.getString(4),null);
            ArrGV.add(GV);
        }
        CustomListAdapter_DSGV adapter = new CustomListAdapter_DSGV(ArrGV);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("magiaovien" , "ggg");
                Toast.makeText(DSGVActivity.this,ArrGV.get(position).getID(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DSGVActivity.this, DSMHActivity.class);
                GiangVien GV= (GiangVien) ArrGV.get(position);
                intent.putExtra("message", ArrGV.get(position).getID());
                startActivity(intent);
            }
        });


        imgbtn_addgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DSGVActivity.this, themgvActivity.class);
                startActivity(intent);
            }
        });
    }
}
