package com.tncnhan.android_giuaki;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class PhieuThanhToanActivity extends AppCompatActivity {
    DBHelper DBhelper;
    SharedPreferences sharedPreferences;
    ExpandableListView expandableListView;
    ExpandleListAdapter expandleListAdapter;
    ArrayList<PhieuChamBai> expandleListTitle;
    HashMap<PhieuChamBai, ArrayList<ThongTinChamBai>> expandleListDetail= new HashMap<>();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DBhelper= new DBHelper(this,"qlcd.sqlite",null,1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phieuthanhtoan_layout);

        TextView teacheridtv= findViewById(R.id.txtPhieuDataMaGV);
        TextView hotentv= findViewById(R.id.txtPhieuDataHoTenGV);
        TextView phonetv= findViewById(R.id.txtPhieuDataSdtGV);
        TextView tongtientv= findViewById(R.id.txtTongThanhToan);
        TextView nguoithanhtoantv= findViewById(R.id.txtTenNguoiThanhToan);
        TextView ngaythanhtoantv= findViewById(R.id.txtNgayThanhToan);
        TextView thangthanhtoantv= findViewById(R.id.txtThangThanhToan);
        TextView namthanhtoantv= findViewById(R.id.txtNamThanhToan);
        LocalDate currentdate = LocalDate.now();
        ngaythanhtoantv.setText(String.valueOf(currentdate.getDayOfMonth()));
        thangthanhtoantv.setText(String.valueOf(currentdate.getMonthValue()));
        namthanhtoantv.setText(String.valueOf(currentdate.getYear()));

//        Vỉnh- Ad dữ liệu từ DB
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        String teacherid= sharedPreferences.getString("username","");
        Cursor dt = DBhelper.GetData("select sum(price)as 'price'\n" +
                "from\n" +
                "(\n" +
                "select class.classid,price\n" +
                "from(\n" +
                "select classid\n" +
                "from(\n" +
                "select reportid\n" +
                "from reportcard\n" +
                "where teacherid='"+teacherid+"') as rs_card\n" +
                "inner join reportinfo\n" +
                "on reportinfo.reportid= rs_card.reportid)as rs_card_info\n" +
                "INNER join class\n" +
                "on class.classid= rs_card_info.classid) as rs_card_info_class\n" +
                "inner join score\n" +
                "on score.classid= rs_card_info_class.classid");
        if(dt.moveToNext()){
            tongtientv.setText(String.valueOf(dt.getInt(0)));
        }else{
            tongtientv.setText("0");
        }


        dt= DBhelper.GetData("select fullname,phone from users where teacherid='"+teacherid+"'");
        if(dt.moveToNext()){
            nguoithanhtoantv.setText(dt.getString(0).toString());
            teacheridtv.setText(teacherid.toString());
            hotentv.setText(dt.getString(0).toString());
            phonetv.setText(dt.getString(1).toString());
        }else{

        }
        HashMap<PhieuChamBai, ArrayList<ThongTinChamBai>> expandablelist_DB = new HashMap<>();
        dt= DBhelper.GetData("select reportinfo.reportid,delidate from reportinfo inner JOIN ( select reportid,delidate from reportcard where teacherid='"+teacherid+"')as rs_reportinfo on rs_reportinfo.reportid= reportinfo.reportid group by reportinfo.reportid");
        Log.d("bcv", teacherid);
        while(dt.moveToNext()){
            ArrayList<ThongTinChamBai> list = new ArrayList<>();
            Cursor dt_detail= DBhelper.GetData("select score.classid,classname,count(classname)as 'Số bài',price,price*count(classname) as 'Tổng tiền'\n" +
                    "from(\n" +
                    "select class.classid,classname,price \n" +
                    "from( \n" +
                    "SELECT rs_card.reportid,classid \n" +
                    "from( \n" +
                    "SELECT reportid \n" +
                    "from reportcard \n" +
                    "WHERE teacherid='"+teacherid+"' and reportid='"+String.valueOf(dt.getInt(0))+"')as rs_card \n" +
                    "inner JOIN reportinfo \n" +
                    "on reportinfo.reportid= rs_card.reportid )as rs_card_info \n" +
                    "INNER JOIN class on class.classid= rs_card_info.classid \n" +
                    ") as rs_card_info_class\n" +
                    "inner join score\n" +
                    "on score.classid= rs_card_info_class.classid\n" +
                    "group by classname,price,score.classid");
            while(dt_detail.moveToNext()){
                MonHoc mh = new MonHoc(dt_detail.getString(0), dt_detail.getString(1), dt_detail.getInt(3), String.valueOf(dt_detail.getInt(2)));
                ThongTinChamBai ptt = new ThongTinChamBai(mh, dt_detail.getInt(2));
                list.add(ptt);
            }
            PhieuChamBai pc = new PhieuChamBai(dt.getInt(0), dt.getString(1), list);
            expandleListDetail.put(pc, list);
        }


        expandableListView =(ExpandableListView) findViewById(R.id.expanded_menu);
//        expandleListDetail = ExpandleData.getData();
        expandleListTitle = new ArrayList<>(expandleListDetail.keySet());
        expandleListAdapter = new ExpandleListAdapter(this, expandleListTitle, expandleListDetail);
        expandableListView.setAdapter(expandleListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //Toast.makeText(getApplicationContext(), String.valueOf(expandleListTitle.get(groupPosition)), Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
               // Toast.makeText(getApplicationContext(), String.valueOf(expandleListTitle.get(groupPosition)), Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandleListTitle.get(groupPosition).getMaPhieu()
                                + " -> "
                                + expandleListDetail.get(
                                expandleListTitle.get(groupPosition)).get(
                                childPosition).getMH().getTenMH(), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }


}