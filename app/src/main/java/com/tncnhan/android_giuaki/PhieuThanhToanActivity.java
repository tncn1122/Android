package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class PhieuThanhToanActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandleListAdapter expandleListAdapter;
    ArrayList<PhieuChamBai> expandleListTitle;
    HashMap<PhieuChamBai, ArrayList<ThongTinChamBai>> expandleListDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phieuthanhtoan_layout);
        expandableListView =(ExpandableListView) findViewById(R.id.expanded_menu);
        expandleListDetail = ExpandleData.getData();
        expandleListTitle = new ArrayList<>(expandleListDetail.keySet());
        expandleListAdapter = new ExpandleListAdapter(this, expandleListTitle, expandleListDetail);
        expandableListView.setAdapter(expandleListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //Toast.makeText(getApplicationContext(), String.valueOf(expandleListTitle.get(groupPosition)), Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
               // Toast.makeText(getApplicationContext(), String.valueOf(expandleListTitle.get(groupPosition)), Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandleListTitle.get(groupPosition).getMaPhieu()
                                + " -> "
                                + expandleListDetail.get(
                                expandleListTitle.get(groupPosition)).get(
                                childPosition).getMH().getTenMH(), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }


}