package com.tncnhan.android_giuaki;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter_DSPhieuCham extends BaseAdapter {
    ArrayList<PhieuCham> phieuCham;

    public CustomListAdapter_DSPhieuCham(ArrayList<PhieuCham> phieuCham) {
        this.phieuCham = phieuCham;
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
        View viewitem= View.inflate(parent.getContext(),R.layout.item_dsphieu_layout,null);
        PhieuCham Phieu= (PhieuCham) getItem(position);
        ((TextView)viewitem.findViewById(R.id.txtMaPhieu)).setText(Phieu.getMaPhieu());
        ((TextView)viewitem.findViewById(R.id.txtHoTenGV)).setText(Phieu.getHoTenGV());
        ((TextView)viewitem.findViewById(R.id.txtNgayGiao)).setText(Phieu.getNgayGiao());
        return viewitem;
    }
}
