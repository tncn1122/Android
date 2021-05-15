package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class themsvActivity extends AppCompatActivity {
    DBHelper DBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themsv);
        Button btnTaoSV = findViewById(R.id.btnTaoSV);
        EditText edtMaSV = findViewById(R.id.edtMaSV);
        EditText edtTenSV = findViewById(R.id.edtTenSV);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tranlation_x);
        edtMaSV.startAnimation(animation);
        edtTenSV.startAnimation(animation);
        btnTaoSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    DBhelper= new DBHelper(themsvActivity.this,"qlcd.sqlite",null,1);
                    DBhelper.QueryData("insert into student values('"
                            + edtMaSV.getText().toString().trim() + "','"
                            + edtTenSV.getText().toString().trim() +"')");
                    Toast.makeText(themsvActivity.this, "thêm sinh viên thành công!", Toast.LENGTH_SHORT).show();

//                    DBhelper = new DBHelper(themgvActivity.this,"qlcd.sqlite",null,1);
//                    Cursor dt= DBhelper.GetData("select * from users where teacherid = 'test2'");
//                    dt.moveToNext();
//                    Log.d("abcd",dt.getString(2));
                }
                catch (Exception e)
                {
                    Toast.makeText(themsvActivity.this, "không thành công!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                //thêm xong thì về lại danh sách
                Intent intent = new Intent(themsvActivity.this, DSSVActivity.class);
                startActivity(intent);
            }
        });
    }
}