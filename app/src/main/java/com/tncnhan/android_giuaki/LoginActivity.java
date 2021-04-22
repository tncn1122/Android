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

public class LoginActivity extends AppCompatActivity {
    DBHelper DBhelper;
    // Dùng để lưu dữ liệu toàn cục
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
//    sharedPreferences.getString(USENAME_KEY,"")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Init_DB();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginbtn= findViewById(R.id.btnLogin);

        EditText editusername= findViewById(R.id.edtLogin);
        EditText editpassword= findViewById(R.id.edtPassword);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Kiểm tra đã nhập đủ thông tin chưa
                if(editusername.getText().toString().trim().isEmpty()){
                    editusername.setError("Nhập tài khoản ^^");
                }
                if(editpassword.getText().toString().trim().isEmpty()) {
                    editpassword.setError("Nhập mật khẩu ^^");
                }
                //  Kiểm tra đúng tài khoản mật khẩu chưa
                Cursor dt= DBhelper.GetData("select userrole,fullname from users where teacherid='"+editusername.getText().toString().trim()+"' and userpass='"+editpassword.getText().toString().trim()+"'");
                if (dt.getCount()<1){
                    // Sai tên đăng nhập hoặc tài khoản
                    Toast.makeText(getApplicationContext(),"Sai tên đăng nhập/ mật khẩu", Toast.LENGTH_SHORT).show();
                }else if(dt.getCount()==1){
                    dt.moveToNext();
                    int role= dt.getInt(0);
                    String fullname=dt.getString(1);
                    sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putString("username", editusername.getText().toString().trim());
                    editor.putString("password", editpassword.getText().toString().trim());
                    editor.putInt("role", role);
                    editor.putString("fullname",String.valueOf(fullname));
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công nha :))" , Toast.LENGTH_SHORT).show();

                    // Chuyển giao diện
                    Intent intent = new Intent(LoginActivity.this, AdminMenuActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public  void Init_DB(){
        DBhelper= new DBHelper(this,"qlcd.sqlite",null,1);
    }
}