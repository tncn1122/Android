package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditUsertInfo extends AppCompatActivity {
    DBHelper DBhelper;
    // Dùng để lưu dữ liệu toàn cục
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_usert_info);

        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        EditText edtTenTaiKhoan = findViewById(R.id.edtTenTaiKhoan);
        EditText edtHoVaTen = findViewById(R.id.edtHoVaTen);
        EditText edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        Button btnEditGiaoVien = findViewById(R.id.btnEditUser);

        String userName = sharedPreferences.getString("username","");

        Cursor dt;
        DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);
        dt= DBhelper.GetData("select * from users where users.teacherid = '" + userName + "'");
        //nhả data vào các field
        dt.moveToNext();
        edtTenTaiKhoan.setText(dt.getString(0));
        edtHoVaTen.setText(dt.getString(3));
        edtSoDienThoai.setText(dt.getString(4));
        String mk = dt.getString(1);

        btnEditGiaoVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flagValid = true;
                if(edtTenTaiKhoan.getText().toString().trim().isEmpty())
                {
                    edtTenTaiKhoan.setError("Tên tài khoản không được trống");
                    flagValid = false;
                }
                if(edtHoVaTen.getText().toString().trim().isEmpty())
                {
                    edtHoVaTen.setError("Họ và tên không được trống");
                    flagValid = false;
                }
                if(edtSoDienThoai.getText().toString().trim().isEmpty())
                {
                    edtSoDienThoai.setError("Số điện thoại không được trống");
                    flagValid =false;
                }
                if(edtSoDienThoai.getText().toString().trim().length() != 10)
                {
                    edtSoDienThoai.setError("số điện thoại phải gồm 10 số");
                    flagValid = false;
                }
                try {
                    if(flagValid)
                    {
                        Log.d("addd", "GV: " +  edtTenTaiKhoan.getText().toString().trim());

                        DBhelper= new DBHelper(EditUsertInfo.this,"qlcd.sqlite",null,1);
                        DBhelper.QueryData("insert or replace into users values('" + edtTenTaiKhoan.getText().toString().trim() + "','"
                                + mk +"',0,'"
                                + edtHoVaTen.getText().toString().trim() +"','"
                                + edtSoDienThoai.getText().toString().trim() + "')");

                        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
                        editor = sharedPreferences.edit();
                        editor.putString("username", edtTenTaiKhoan.getText().toString().trim());
                        editor.putString("password", mk);
                        editor.putInt("role", 0);
                        editor.putString("fullname",edtHoVaTen.getText().toString().trim());
                        editor.commit();
                        Toast.makeText(EditUsertInfo.this, "Thành công!", Toast.LENGTH_LONG).show();
                        //thêm xong thì về lại danh sách
                        Intent intent = new Intent(EditUsertInfo.this, AdminMenuActivity.class);
                        startActivity(intent);
                    }

                    //                    DBhelper = new DBHelper(themgvActivity.this,"qlcd.sqlite",null,1);
                    //                    Cursor dt= DBhelper.GetData("select * from users where teacherid = 'test2'");
                    //                    dt.moveToNext();
                    //                    Log.d("abcd",dt.getString(2));
                }
                catch (Exception e)
                {
                    Toast.makeText(EditUsertInfo.this, "không thành công!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

    }
}