package com.tncnhan.android_giuaki;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter_DSGV extends BaseAdapter{
    ArrayList<GiangVien> arrayList;

    CustomListAdapter_DSGV(ArrayList<GiangVien> arrayList){
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewitem= View.inflate(parent.getContext(),R.layout.item_dsgv_layout,null);
        GiangVien GV= (GiangVien)getItem(position);
        ((TextView)viewitem.findViewById(R.id.txtMaGV)).setText(GV.getID());
        ((TextView)viewitem.findViewById(R.id.txtHoTenGV)).setText(String.valueOf(GV.getName()));
        ((TextView)viewitem.findViewById(R.id.txtSdtGV)).setText(GV.getSDT());
        return viewitem;
    }
}