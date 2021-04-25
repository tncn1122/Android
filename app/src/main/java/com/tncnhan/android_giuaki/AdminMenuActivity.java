package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdminMenuActivity extends AppCompatActivity {
    DBHelper DBhelper ;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        // GET THONG TIN USER
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        String fullname=sharedPreferences.getString("fullname","");
        int role= sharedPreferences.getInt("role",0);
        // SET NAME TEXTVIEW
        TextView textViewuserfullname= findViewById(R.id.txtUserFullName);
        textViewuserfullname.setText(fullname);
        // xỬ LÍ ROLE: 1-admin
        Button btn_taophieucham= findViewById(R.id.btnTaoPhieuCham);
        Button btn_taothongtincham= findViewById(R.id.btnTaoThongTinCham);
        Button btn_DSGV= findViewById(R.id.btnDanhSachGiangVien);
        Button btn_DSMH= findViewById(R.id.btnDanhSachMonHoc);
        Button btn_phieuthanhtoan= findViewById(R.id.btnPhieuThanhToan);
        Button btn_thongkechiphi= findViewById(R.id.btnThongKeChiPhi);
        Button btn_DSPhieu = findViewById(R.id.btnDSPhieu);
        Button btn_TaoDSSV = findViewById(R.id.btnTaoDSSV);
        LinearLayout lyGV = findViewById(R.id.lyGV);
        if(role ==0){
//            btn_taophieucham.setEnabled(false);
//            btn_taophieucham.setVisibility(View.GONE);
//            btn_taothongtincham.setEnabled(false);
//            btn_taothongtincham.setVisibility(View.GONE);
//            btn_taophieucham.getBackground().setAlpha(15);
//            btn_taothongtincham.getBackground().setAlpha(15);
            lyGV.setVisibility(View.GONE);
        }else if(role == 1){
//            btn_taophieucham.setEnabled(true);
//            btn_taothongtincham.setEnabled(true);
            lyGV.setVisibility(View.VISIBLE);
        }
//        DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);
//        Cursor dt= DBhelper.GetData("select * from users");
//        dt.moveToNext();
//        Log.d("abcd",dt.getString(2) );

        //DANG XUAT
        Button btn_DangXuat = findViewById(R.id.btnDangXuat);

        btn_DangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().clear();
                Intent intent = new Intent(AdminMenuActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_DSGV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, DSGVActivity.class);
                startActivity(intent);
            }
        });
        btn_DSMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, DSMHActivity.class);
                intent.putExtra("message", "admin");
                startActivity(intent);
            }
        });
//        btn_taophieucham.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AdminMenuActivity.this, PhieuChamActivity.class);
//                startActivity(intent);
//            }
//        });
//        btn_taothongtincham.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AdminMenuActivity.this, ThongTinChamActivity.class);
//                startActivity(intent);
//            }
//        });
        btn_DSPhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, DSPhieuActivity.class);
                startActivity(intent);
            }
        });
        btn_TaoDSSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, DSSVActivity.class);
                startActivity(intent);
            }
        });
        btn_phieuthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, PhieuThanhToanActivity.class);
                startActivity(intent);
            }
        });
        btn_thongkechiphi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, ThongKeChiPhiActivity.class);
                startActivity(intent);
            }
        });
    }
}