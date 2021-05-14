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

public class EditMHActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    DBHelper DBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mh);

        // GET THONG TIN USER
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        int role= sharedPreferences.getInt("role",0);

        Button btnSuaMH = findViewById(R.id.btnSuaMonHoc);
        EditText edtMaMonHoc = findViewById(R.id.edtMaMonHoc);
        EditText edtTenMonHoc = findViewById(R.id.edtTenMonHoc);
        EditText edtChiPhi = findViewById(R.id.edtChiPhi);

        // nhận classId từ DSSVNhapDiem
        Intent intent = getIntent();
        String message = intent.getStringExtra("classId");
        Log.d("classIdMessage", message);

        Cursor dt;
        DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);
        dt= DBhelper.GetData("select * from class where class.classid = '" + message + "'");
        //nhả data vào các field
        dt.moveToNext();
        edtMaMonHoc.setText(dt.getString(0));
        edtTenMonHoc.setText(dt.getString(1));
        edtChiPhi.setText(dt.getString(2));

        // lưu lại data cũ
        String oldMaMonHoc = dt.getString(0);

        btnSuaMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d("addd", "GV: " +  edtTenMonHoc.getText().toString().trim());

                    DBhelper= new DBHelper(EditMHActivity.this,"qlcd.sqlite",null,1);
                    DBhelper.QueryData("insert or replace into class values('"
                            + edtMaMonHoc.getText().toString().trim() + "','"
                            + edtTenMonHoc.getText().toString().trim() +"',"
                            + edtChiPhi.getText().toString().trim() +")");
                    // edit xong thì xóa cái cũ
//                    DBhelper= new DBHelper(EditMHActivity.this,"qlcd.sqlite",null,1);
//                    DBhelper.QueryData("delete from class where class.classid = '" + oldMaMonHoc + "'");
                    Toast.makeText(EditMHActivity.this, "Thành công!", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(EditMHActivity.this, "không thành công!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                //thêm xong thì về lại danh sách
                Intent intent = new Intent(EditMHActivity.this, DSMHActivity.class);
                intent.putExtra("message", "admin");
                startActivity(intent);
            }
        });
    }
}