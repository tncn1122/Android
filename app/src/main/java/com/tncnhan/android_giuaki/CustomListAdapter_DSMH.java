package com.tncnhan.android_giuaki;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter_DSMH extends BaseAdapter {
    ArrayList<MonHoc> arrayList;

    public CustomListAdapter_DSMH(ArrayList<MonHoc> arrayList) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewitem= View.inflate(parent.getContext(),R.layout.item_dsmh_layout,null);
        MonHoc MH= (MonHoc)getItem(position);
        ((TextView)viewitem.findViewById(R.id.txtMaMH)).setText(MH.getMaMH());
        ((TextView)viewitem.findViewById(R.id.txtTenMH)).setText(String.valueOf(MH.getTenMH()));
        ((TextView)viewitem.findViewById(R.id.txtChiPhi)).setText(String.valueOf(MH.getChiPhi()));
        ((TextView)viewitem.findViewById(R.id.txtPC)).setText("3/3");
        return viewitem;
    }
}
