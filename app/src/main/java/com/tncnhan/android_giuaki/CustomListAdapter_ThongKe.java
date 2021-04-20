package com.tncnhan.android_giuaki;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter_ThongKe extends BaseAdapter {
    ArrayList<ThongKe> thongKes;

    public CustomListAdapter_ThongKe(ArrayList<ThongKe> thongKes) {
        this.thongKes = thongKes;
    }

    @Override
    public int getCount() {
        return thongKes.size();
    }

    @Override
    public Object getItem(int i) {
        return thongKes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View kqView = View.inflate(viewGroup.getContext(), R.layout.item_thongke_layout, null);
        ThongKe tk = (ThongKe)getItem(i);

        ((TextView)kqView.findViewById(R.id.txtTenMonHocTK)).setText(tk.getMH().getTenMH());
        ((TextView)kqView.findViewById(R.id.txtQ1)).setText(String.valueOf(tk.getQ1()));
        ((TextView)kqView.findViewById(R.id.txtQ2)).setText(String.valueOf(tk.getQ2()));
        ((TextView)kqView.findViewById(R.id.txtQ3)).setText(String.valueOf(tk.getQ3()));
        ((TextView)kqView.findViewById(R.id.txtQ4)).setText(String.valueOf(tk.getQ4()));
        ((TextView)kqView.findViewById(R.id.txtChiPhiNam)).setText(String.valueOf(tk.getTong()));

        return kqView;
    }
}
