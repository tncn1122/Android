package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class DSGVActivity extends AppCompatActivity {
    DBHelper DBhelper;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsgv_layout);
        // GET THONG TIN USER
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        int role= sharedPreferences.getInt("role",0);
        ImageButton imgbtn_addgv= findViewById(R.id.imgbtn_addgv);
//        ListView listView = findViewById(R.id.lvDSGV);
        SwipeMenuListView listView = findViewById(R.id.lvDSGV);

                DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);

        if(role==0){
            imgbtn_addgv.setVisibility(View.GONE);
        }else if(role ==1 ){
            imgbtn_addgv.setVisibility(View.VISIBLE);
        }


        ArrayList<GiangVien> ArrGV  = new ArrayList<>();
        Cursor dt= DBhelper.GetData("select * from users where userrole = 0");
        while(dt.moveToNext())
        {
            Log.d("SelectGV", dt.getString(0) + " " + dt.getString(3));
            GiangVien GV = new GiangVien(dt.getString(0),dt.getString(3),dt.getString(4),null);
            ArrGV.add(GV);
        }
        CustomListAdapter_DSGV adapter = new CustomListAdapter_DSGV(ArrGV);
        listView.setAdapter(adapter);




        if(role == 1)
        {
            // step 1. create a MenuCreator
            SwipeMenuCreator creator = new SwipeMenuCreator() {
                @Override
                public void create(SwipeMenu menu) {
                    SwipeMenuItem item = new SwipeMenuItem(
                            getApplicationContext());
                    item.setBackground(new ColorDrawable(Color.rgb(0xF9,
                            0x3F, 0x25)));
                    item.setWidth(dp2px(45));
                    item.setIcon(R.drawable.ic_action_trash);
                    menu.addMenuItem(item);
                }

            };
            // set creator
            listView.setMenuCreator(creator);

            // step 2. listener item click event
            listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                    GiangVien item = ArrGV.get(position);
                    ArrGV.remove(item);
                    Log.d("position",String.valueOf(position) + " " + item.getID());
                    Log.d("dsgv", String.valueOf(ArrGV));
                    adapter.notifyDataSetChanged();
                    listView.setAdapter(adapter);
                    return false;
                }
            });
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("magiaovien" , "ggg");
                Toast.makeText(DSGVActivity.this,ArrGV.get(position).getID(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DSGVActivity.this, DSMHActivity.class);
                GiangVien GV= (GiangVien) ArrGV.get(position);
                intent.putExtra("message", ArrGV.get(position).getID());
                startActivity(intent);
            }
        });


        imgbtn_addgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DSGVActivity.this, themgvActivity.class);
                startActivity(intent);
            }
        });
    }

private int dp2px(int dp) {
        float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) (dp * scale + 0.5f);
        return pixels;
        }
}