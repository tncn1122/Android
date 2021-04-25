package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ThongTinChamActivity extends AppCompatActivity {
    DBHelper DBhelper;
    ArrayList<Integer> listSoPhieu = new ArrayList<>();
    ArrayList<MonHoc> listMonHoc = new ArrayList<>();
    int soPhieu = 0;
    String maMH = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themthongtincham_layout);
        Spinner spinnerSoPhieu, spinnerTenMH;
        spinnerSoPhieu = findViewById(R.id.spnSoPhieu);
        spinnerTenMH = findViewById(R.id.spnTenMH);
        Button btnThemThongTin = findViewById(R.id.btnThemThongTin);
        //nhận message từ danh sách phiếu
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        DBhelper= new DBHelper(this,"qlcd.sqlite",null,1);

        Cursor dtSoPhieu;
        try{
            dtSoPhieu= DBhelper.GetData("select reportid from reportcard");
            if(dtSoPhieu.getCount()<1){
                Toast.makeText(getApplicationContext(),"Chưa có dữ liệu bạn eii!" , Toast.LENGTH_SHORT).show();
            }else{
                while(dtSoPhieu.moveToNext()){
                    Integer soPhieu = dtSoPhieu.getInt(0);
                    listSoPhieu.add(soPhieu);
                    //Toast.makeText(getApplicationContext(),String.valueOf(soPhieu) , Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception e){
            Log.d("cc",String.valueOf(e.getMessage()));
        }

        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listSoPhieu);
        spinnerSoPhieu.setAdapter(spinnerAdapter);

        spinnerSoPhieu.setSelection(Integer.parseInt(message));
        spinnerSoPhieu.setEnabled(false);

        spinnerSoPhieu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //đối số postion là vị trí phần tử trong list Data
                String msg = "position :" + position + " value :" + listSoPhieu.get(position);
                soPhieu=listSoPhieu.get(position);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(getApplicationContext(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        Cursor dtMonHoc;
        try{
            dtMonHoc= DBhelper.GetData("select * from class");
            if(dtMonHoc.getCount()<1){
                Toast.makeText(getApplicationContext(),"Chưa có dữ liệu bạn eii!" , Toast.LENGTH_SHORT).show();
            }else{
                while(dtMonHoc.moveToNext()){

                    String idMH = dtMonHoc.getString(0);
                    String tenMH = dtMonHoc.getString(1);
                    Integer price = dtMonHoc.getInt(2);
                    MonHoc mh = new MonHoc(idMH, tenMH, price,null);
                    listMonHoc.add(mh);
                }
            }
        }catch (Exception e){
            Log.d("aaa",String.valueOf(e.getMessage()));
        }

        ArrayAdapter spAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listMonHoc);
        spinnerTenMH.setAdapter(spAdapter);
        spinnerTenMH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //đối số postion là vị trí phần tử trong list Data
                String msg = "position :" + position + " value :" + listMonHoc.get(position);
                maMH=listMonHoc.get(position).getMaMH();
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(getApplicationContext(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        // gán id đã intent từ ds phiếu vào biến
        soPhieu = Integer.parseInt(message);
        btnThemThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor dt= DBhelper.GetData("select * from reportinfo where reportid='"+soPhieu+"'and classid = '"+maMH+"'");
                if(dt.getCount()>0){
                    Toast.makeText(getApplicationContext(), "Dữ liệu này đã tồn tại!", Toast.LENGTH_SHORT).show();
                }
                else{
                    DBhelper.QueryData("insert into reportinfo values('"+soPhieu+"','"+maMH+"')");
                    Toast.makeText(getApplicationContext(), "Thêm dữ liệu thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}