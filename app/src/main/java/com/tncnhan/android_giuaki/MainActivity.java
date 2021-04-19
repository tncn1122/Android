package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsgv_layout);
        ArrayList<GiangVien> countryArrayList=new ArrayList<>();
        countryArrayList.add(new GiangVien("GV01","XXXXXXX","1111111111"));
        countryArrayList.add(new GiangVien("GV02","YYYYYYY","2222222222"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));
        countryArrayList.add(new GiangVien("GV03","ZZZZZZZ","3333333333"));


        CustomListAdapter_DSGV adapter = new CustomListAdapter_DSGV(countryArrayList);

        ListView listView= findViewById(R.id.lvDSGV);
        listView.setAdapter(adapter);
    }
}