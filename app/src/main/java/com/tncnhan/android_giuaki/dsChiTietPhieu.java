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
import android.widget.TextView;

import java.util.ArrayList;

public class dsChiTietPhieu extends AppCompatActivity {
    DBHelper DBhelper;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_chi_tiet_phieu);
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        int role= sharedPreferences.getInt("role",0);

        ImageButton imgbtn_addCTPhieu= findViewById(R.id.btnThem);
        ListView listView = findViewById(R.id.lvDSLop);

        if(role==0){
            imgbtn_addCTPhieu.setVisibility(View.GONE);
        }else if(role ==1 ){
            imgbtn_addCTPhieu.setVisibility(View.VISIBLE);
        }

        //nhận message từ danh sách phiếu -  message này bao gồm MaPhieu + " " + HoTenGV
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        Log.d("soPhieuIntent", message);
        String[] tokens = message.split(" ");
        String token1 = tokens[0]; // MaPhieu
        String token2 = tokens[1]; // HoTenGV

        //in ra tên GV phụ trách
        TextView teacher = findViewById(R.id.txtTeacher);
        teacher.setText("Giảng Viên: " + getTeacherOfClass(token2));

        ArrayList<MonHoc> ArrMH  = new ArrayList<>();
        DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);
        Cursor dt= DBhelper.GetData("select reportinfo.classid, class.classname, class.price from (reportinfo inner join class on reportinfo.classid = class.classid) where reportinfo.reportid = " + token1);
        while(dt.moveToNext())
        {
            String classId = dt.getString(0);
            MonHoc MH = new MonHoc(dt.getString(0),dt.getString(1),Integer.parseInt(dt.getString(2)),getCountScoredInClass(classId)+ "/" + getCountStudentInClass(classId));
            ArrMH.add(MH);
            Log.d("SelectPhieussss", dt.getString(0) + " " +dt.getString(1)+" "+ dt.getString(2) + " " + ArrMH.size());
        }
        CustomListAdapter_DSMH adapter = new CustomListAdapter_DSMH(ArrMH);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(DSPhieuActivity.this,ArrPC.get(position).getMaPhieu(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(dsChiTietPhieu.this, DSSVNhapDiemActivity.class);
                intent.putExtra("message", ArrMH.get(position).getMaMH());
                startActivity(intent);
            }
        });

        // thêm phiếu chấm aka reportcard
        imgbtn_addCTPhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dsChiTietPhieu.this, ThongTinChamActivity.class);
                intent.putExtra("message", message);
                startActivity(intent);
            }
        });
    }
    private String getCountScoredInClass(String classId){
        String res = "0";
        try{
            Cursor dt = DBhelper.GetData("SELECT COUNT(score) FROM score where classid = '" + classId + "'");
            dt.moveToNext();
            res = dt.getString(0);
        }
        catch (Exception e){

        }

        return res;
    }

    private String getCountStudentInClass(String classId){
        String res = "0";
        try{
            Cursor dt = DBhelper.GetData("SELECT COUNT(1) FROM score where classid = '" + classId + "'");
            dt.moveToNext();
            res = dt.getString(0);
        }
        catch (Exception e){

        }

        return res;
    }

    private String getTeacherOfClass(String classId){
        String res = "Chưa Có GV Phụ Trách";
        try{
            Cursor dt = DBhelper.GetData("SELECT fullname FROM (SELECT teacherid FROM reportinfo, reportcard WHERE reportcard.reportid = reportinfo.reportid AND reportinfo.classid = '" + classId + "'  ) as INFO INNER JOIN users on users.teacherid = INFO.teacherid");
            dt.moveToNext();
            res = dt.getString(0);
        }catch (Exception e){

        }
        return res;
    }
}