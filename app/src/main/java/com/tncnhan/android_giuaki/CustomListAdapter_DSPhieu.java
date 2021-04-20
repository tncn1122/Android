package com.tncnhan.android_giuaki;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter_DSPhieu extends BaseAdapter {
    ArrayList<PhieuChamBai> phieuChamBai;

    public CustomListAdapter_DSPhieu(ArrayList<PhieuChamBai> phieuChamBai) {
        this.phieuChamBai = phieuChamBai;
    }

    @Override
    public int getCount() {
        return phieuChamBai.size();
    }

    @Override
    public Object getItem(int i) {
        return phieuChamBai.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View kqView = View.inflate(viewGroup.getContext(), R.layout.item_phieuthanhtoan_layout, null);
        PhieuChamBai phieuCB = (PhieuChamBai)getItem(i);
        ((TextView)kqView.findViewById(R.id.txtIDMaPhieu)).setText(String.valueOf(phieuCB.getMaPhieu()));
        ((TextView)kqView.findViewById(R.id.txtNgayGiao)).setText(phieuCB.getNgayGiao());
        ((TextView)kqView.findViewById(R.id.txtTongTien)).setText(String.valueOf(phieuCB.getThanhToan()));

        CustomListAdapter_DSThongTinPhieu dsThongTinPhieu = new CustomListAdapter_DSThongTinPhieu(phieuCB.getThongTinChamBai());
        ((ListView)kqView.findViewById(R.id.listMHPhieu)).setAdapter(dsThongTinPhieu);

        return kqView;
    }
}
