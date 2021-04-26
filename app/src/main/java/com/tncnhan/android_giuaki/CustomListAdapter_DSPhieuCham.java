package com.tncnhan.android_giuaki;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter_DSPhieuCham extends BaseAdapter {
    ArrayList<PhieuCham> arrayList;

    public CustomListAdapter_DSPhieuCham(ArrayList<PhieuCham> arrayList) {
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
        View viewitem= View.inflate(parent.getContext(),R.layout.item_dsphieu_layout,null);
        PhieuCham phieucham= (PhieuCham) getItem(position);
        ((TextView)viewitem.findViewById(R.id.txtMaPhieu)).setText(String.valueOf(phieucham.getMaPhieu()));
        ((TextView)viewitem.findViewById(R.id.txtHoTenGV)).setText(phieucham.getHoTenGV());
        ((TextView)viewitem.findViewById(R.id.txtNgayGiao)).setText(phieucham.getNgayGiao());
        return viewitem;
    }
}
