package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DSGVActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsgv_layout);
        // GET THONG TIN USER
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        int role= sharedPreferences.getInt("role",0);
        ImageButton imgbtn_addgv= findViewById(R.id.imgbtn_addgv);
        if(role==0){
            imgbtn_addgv.setVisibility(View.INVISIBLE);
        }else if(role ==1 ){
            imgbtn_addgv.setVisibility(View.VISIBLE);
        }
    }
}