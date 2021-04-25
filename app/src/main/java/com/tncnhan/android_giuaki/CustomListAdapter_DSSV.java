package com.tncnhan.android_giuaki;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter_DSSV extends BaseAdapter {
    ArrayList<SinhVien> arrayList;

    public CustomListAdapter_DSSV(ArrayList<SinhVien> arrayList) {
        this.arrayList = arrayList;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewitem= View.inflate(parent.getContext(),R.layout.item_dssv_layout,null);
        SinhVien SV= (SinhVien) getItem(position);
        ((TextView)viewitem.findViewById(R.id.txtMaSV)).setText(SV.getID());
        ((TextView)viewitem.findViewById(R.id.txtHoTenSV)).setText(String.valueOf(SV.getName()));
        return viewitem;
    }
}
