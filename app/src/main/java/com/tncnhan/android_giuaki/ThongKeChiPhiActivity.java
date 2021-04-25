package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThongKeChiPhiActivity extends AppCompatActivity {
    ArrayList<ThongKe> listThongKe;
    CustomListAdapter_ThongKe customListAdapterThongKe;
    ListView listViewThongKe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongkechiphi_layout);
        listViewThongKe = findViewById(R.id.listTK);
        MonHoc mh1 = new MonHoc("GT1", "Giai tích 1", 2000, "");
        MonHoc mh2 = new MonHoc("GT2", "Giai tích 2", 3000, "");
        MonHoc mh3 = new MonHoc("DS1", "Đại số 1", 4000, "");
        MonHoc mh4 = new MonHoc("DS2", "Đại số 2", 5000, "");
        ThongKe tk1 = new ThongKe(mh1,1000,2000,3000,4000);
        ThongKe tk2 = new ThongKe(mh2,2000,3000,4000,5000);
        ThongKe tk3 = new ThongKe(mh3,3000,4000,5000,6000);
        ThongKe tk4 = new ThongKe(mh4,1000,2000,3000,4000);
        listThongKe = new ArrayList<>();
        listThongKe.add(tk1);
        listThongKe.add(tk2);
        listThongKe.add(tk3);
        listThongKe.add(tk4);
        listThongKe.add(tk1);
        listThongKe.add(tk2);
        listThongKe.add(tk3);
        listThongKe.add(tk4);
        customListAdapterThongKe= new CustomListAdapter_ThongKe(listThongKe);
        listViewThongKe.setAdapter(customListAdapterThongKe);
        listViewThongKe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listThongKe.get(position).getMH().getTenMH().toString()
                                +" | "+listThongKe.get(position).getQ1()
                                +" | "+listThongKe.get(position).getQ2()
                                +" | "+listThongKe.get(position).getQ3()
                                +" | "+listThongKe.get(position).getQ4()
                                +" | "+listThongKe.get(position).getTong()
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}