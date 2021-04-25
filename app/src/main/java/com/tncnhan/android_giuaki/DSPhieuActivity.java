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

public class DSPhieuActivity extends AppCompatActivity {

    DBHelper DBhelper;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_phieu);
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        int role= sharedPreferences.getInt("role",0);
        ImageButton imgbtn_addPhieu= findViewById(R.id.imgbtn_addPhieu);
        ListView listView = findViewById(R.id.lvDSPhieu);

        if(role==0){
            imgbtn_addPhieu.setVisibility(View.GONE);
        }else if(role ==1 ){
            imgbtn_addPhieu.setVisibility(View.VISIBLE);
        }

        ArrayList<PhieuCham> ArrPC  = new ArrayList<>();
        DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);
        Cursor dt= DBhelper.GetData("select * from reportcard");
        while(dt.moveToNext())
        {
            Log.d("SelectPhieu", dt.getString(0) + " " + dt.getString(2));
            PhieuCham Phieu = new PhieuCham(Integer.parseInt(dt.getString(0)),dt.getString(1),dt.getString(2),null);
            ArrPC.add(Phieu);
        }
        CustomListAdapter_DSPhieuCham adapter = new CustomListAdapter_DSPhieuCham(ArrPC);
        listView.setAdapter(adapter);
        // thêm môn từng phiếu aka reportinfo
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DSPhieuActivity.this,ArrPC.get(position).getMaPhieu(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DSPhieuActivity.this, ThongTinChamActivity.class);
                PhieuCham Phieu= (PhieuCham) ArrPC.get(position);
                intent.putExtra("message", ArrPC.get(position).getMaPhieu());
                startActivity(intent);
            }
        });

        // thêm phiếu chấm aka reportcard
        imgbtn_addPhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DSPhieuActivity.this, PhieuChamActivity.class);
                startActivity(intent);
            }
        });
    }
}