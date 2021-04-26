package com.tncnhan.android_giuaki;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter_DSDIEM extends BaseAdapter {
    ArrayList<Diem> dsDiem=  new ArrayList<>();

    public CustomListAdapter_DSDIEM(ArrayList<Diem> dsDiem) {
        this.dsDiem = dsDiem;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewitem= View.inflate(parent.getContext(),R.layout.item_nhapdiem_layout,null);
        Diem nhapdiem= (Diem) getItem(position);
        ((TextView)viewitem.findViewById(R.id.txtMaSV)).setText(nhapdiem.sv.getID());
        ((TextView)viewitem.findViewById(R.id.txtHoTenSV)).setText(String.valueOf(nhapdiem.sv.getName()));
        ((TextView)viewitem.findViewById(R.id.edtDiem)).setText(String.valueOf(nhapdiem.diem));
        return viewitem;
    }
}
