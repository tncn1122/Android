package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.IDN;

public class themgvActivity extends AppCompatActivity {
    DBHelper DBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themgv);
        EditText edtTenTaiKhoan = findViewById(R.id.edtTenTaiKhoan);
        EditText edtHoVaTen = findViewById(R.id.edtHoVaTen);
        EditText edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        EditText edtMatKhau = findViewById(R.id.edtMatKhau);
        EditText edtNhapLaiMK = findViewById(R.id.edtNhapLaiMK);
        Button btnTaoGiaoVien = findViewById(R.id.btnTaoGiaoVien);

        btnTaoGiaoVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d("addd", "GV: " +  edtTenTaiKhoan.getText().toString().trim());

                    DBhelper= new DBHelper(themgvActivity.this,"qlcd.sqlite",null,1);
                    DBhelper.QueryData("insert into users values('" + edtTenTaiKhoan.getText().toString().trim() + "','"
                            + edtMatKhau.getText().toString().trim() +"',0,'"
                            + edtHoVaTen.getText().toString().trim() +"','"
                            + edtMatKhau.getText().toString().trim() + "')");
                    Toast.makeText(themgvActivity.this, "thêm giảng viên thành công!", Toast.LENGTH_LONG).show();

//                    DBhelper = new DBHelper(themgvActivity.this,"qlcd.sqlite",null,1);
//                    Cursor dt= DBhelper.GetData("select * from users where teacherid = 'test2'");
//                    dt.moveToNext();
//                    Log.d("abcd",dt.getString(2));
                }
                catch (Exception e)
                {
                    Toast.makeText(themgvActivity.this, "không thành công!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                //thêm xong thì về lại danh sách
                Intent intent = new Intent(themgvActivity.this, DSGVActivity.class);
                startActivity(intent);
            }
        });


    }
}