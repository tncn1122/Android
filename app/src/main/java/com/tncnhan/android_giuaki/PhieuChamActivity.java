package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PhieuChamActivity extends AppCompatActivity {
    DBHelper DBhelper;
    int selected_position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DBhelper= new DBHelper(this,"qlcd.sqlite",null,1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themphieucham_layout);
        Button btnadd= findViewById(R.id.btnThemPhieu);
        Spinner gvspinner= findViewById(R.id.spnGV);

        ArrayList<GiangVien> dsgiangvien= new ArrayList<GiangVien>();
        Cursor dt= DBhelper.GetData("select teacherid,fullname from users where userrole=0");
        while (dt.moveToNext()){
            GiangVien gv=new GiangVien(dt.getString(0), dt.getString(1),"0123",null);
            dsgiangvien.add(gv);
//            Log.d("bcv", gv.getName());
        }

        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, dsgiangvien);
        gvspinner.setAdapter(spinnerAdapter);

        gvspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selected_position= position;
                //đối số postion là vị trí phần tử trong list Data
//                String msg = "position :" + position + " value :" + dsgiangvien.get(position);
//                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(getApplicationContext(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker ngaygiao= findViewById(R.id.dpPhieu);
                int day= ngaygiao.getDayOfMonth();
                int month= ngaygiao.getMonth()+1;
                int year= ngaygiao.getYear();

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String ngaychon= String.valueOf(year)+"-"+ String.valueOf(month)+ "-"+String.valueOf(day);

                Date date2 = Calendar.getInstance().getTime();
                String strtodate = dateFormat.format(date2);

                try {
                    // Kiểm tra xem ngày giao có lớn hơn ngày hiện tại không
                    if (dateFormat.parse(ngaychon).before(dateFormat.parse(strtodate))||dateFormat.parse(ngaychon).equals(dateFormat.parse(strtodate))){
                        Toast.makeText(getApplicationContext(),"Ngày giao phải lớn hơn ngày hiện tại" , Toast.LENGTH_SHORT).show();
                    }else{
                        try {
                            DBhelper.QueryData("insert into reportcard(teacherid,delidate) values('"+dsgiangvien.get(selected_position).getID()+"','"+ngaychon+"')");
                            Toast.makeText(getApplicationContext(),"Thêm thành công!" , Toast.LENGTH_SHORT).show();
                        }catch (Exception ex){
                            Toast.makeText(getApplicationContext(),"Lỗi ghi CSDL! Không thể thêm!" , Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}