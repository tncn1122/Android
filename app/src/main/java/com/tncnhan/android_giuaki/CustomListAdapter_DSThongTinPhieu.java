package com.tncnhan.android_giuaki;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter_DSThongTinPhieu extends BaseAdapter {
    private ArrayList<ThongTinChamBai> thongTinChamBai;

    public CustomListAdapter_DSThongTinPhieu(ArrayList<ThongTinChamBai> thongTinChamBai) {
        this.thongTinChamBai = thongTinChamBai;
    }

    @Override
    public int getCount() {
        return thongTinChamBai.size();
    }

    @Override
    public Object getItem(int i) {
        return thongTinChamBai.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View kqView = View.inflate(viewGroup.getContext(), R.layout.item_phieuthanhtoan_layout_monhoc, null);
        ThongTinChamBai thongTinCB = (ThongTinChamBai)getItem(i);
        ((TextView)kqView.findViewById(R.id.txtTenMHPhieu)).setText(thongTinCB.getMH().getTenMH());
        ((TextView)kqView.findViewById(R.id.txtSoBaiMH)).setText(String.valueOf(thongTinCB.getSoBai()));
        ((TextView)kqView.findViewById(R.id.txtChiPhiMH)).setText(String.valueOf(thongTinCB.getMH().getChiPhi()));
        ((TextView)kqView.findViewById(R.id.txtTongChiPhiMH)).setText(String.valueOf(thongTinCB.getTong()));

        return kqView;
    }
}
