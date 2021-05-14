package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMHActivity extends AppCompatActivity {
    DBHelper DBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_monhoc);
        Button btnTaoMH = findViewById(R.id.btnTaoMonHoc);
        EditText edtMaMonHoc = findViewById(R.id.edtMaMonHoc);
        EditText edtTenMonHoc = findViewById(R.id.edtTenMonHoc);
        EditText edtChiPhi = findViewById(R.id.edtChiPhi);

        btnTaoMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d("addd", "GV: " +  edtTenMonHoc.getText().toString().trim());

                    DBhelper= new DBHelper(AddMHActivity.this,"qlcd.sqlite",null,1);
                    DBhelper.QueryData("insert into class values('"
                            + edtMaMonHoc.getText().toString().trim() + "','"
                            + edtTenMonHoc.getText().toString().trim() +"',"
                            + edtChiPhi.getText().toString().trim() +")");
                    Toast.makeText(AddMHActivity.this, "thêm mon hoc thành công!", Toast.LENGTH_LONG).show();

//                    DBhelper = new DBHelper(themgvActivity.this,"qlcd.sqlite",null,1);
//                    Cursor dt= DBhelper.GetData("select * from users where teacherid = 'test2'");
//                    dt.moveToNext();
//                    Log.d("abcd",dt.getString(2));
                }
                catch (Exception e)
                {
                    Toast.makeText(AddMHActivity.this, "không thành công!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                //thêm xong thì về lại danh sách
                Intent intent = new Intent(AddMHActivity.this, DSMHActivity.class);
                intent.putExtra("message", "admin");
                startActivity(intent);
            }
        });
    }
}