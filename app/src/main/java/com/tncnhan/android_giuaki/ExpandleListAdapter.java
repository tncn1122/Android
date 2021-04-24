package com.tncnhan.android_giuaki;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpandleListAdapter extends BaseExpandableListAdapter {
    public ExpandleListAdapter(Context context, ArrayList<PhieuChamBai> expandleTitle, HashMap<PhieuChamBai, ArrayList<ThongTinChamBai>> expandelListDetail) {
        this.context = context;
        this.expandleTitle = expandleTitle;
        this.expandelListDetail = expandelListDetail;
    }

    private Context context;
    private ArrayList<PhieuChamBai> expandleTitle;
    private HashMap<PhieuChamBai, ArrayList<ThongTinChamBai>> expandelListDetail;

    @Override
    public int getGroupCount() {
        return this.expandleTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.expandelListDetail.get(this.expandleTitle.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.expandleTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.expandelListDetail.get(this.expandleTitle.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        PhieuChamBai expandleListTitleText = (PhieuChamBai) getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.item_phieuthanhtoan_layout, null);
        }
        TextView tvSoPhieu, tvNgayGiao, tvTong;
        tvSoPhieu = (TextView) convertView.findViewById(R.id.txtIDMaPhieuPTT);
        tvNgayGiao = (TextView) convertView.findViewById(R.id.txtNgayGiaoPTT);
        tvTong = (TextView) convertView.findViewById(R.id.txtTongTienPTT);
        tvSoPhieu.setText(String.valueOf(expandleListTitleText.getMaPhieu()));
        tvNgayGiao.setText(String.valueOf(expandleListTitleText.getNgayGiao()));
        tvTong.setText(String.valueOf(expandleListTitleText.getThanhToan()));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ThongTinChamBai expandleListText = (ThongTinChamBai) getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.item_phieuthanhtoan_layout_monhoc, null);
        }
        TextView tvTenMh, tvSoBai, tvChiPhi, tvTong;
        tvTenMh = (TextView) convertView.findViewById(R.id.txtTenMHPhieu);
        tvSoBai = (TextView) convertView.findViewById(R.id.txtSoBaiMH);
        tvChiPhi = (TextView) convertView.findViewById(R.id.txtChiPhiMH);
        tvTong = (TextView) convertView.findViewById(R.id.txtTongChiPhiMH);
        tvTenMh.setText(expandleListText.getMH().getTenMH());
        tvSoBai.setText(String.valueOf(expandleListText.getSoBai()));
        tvChiPhi.setText(String.valueOf(expandleListText.getMH().getChiPhi()));
        tvTong.setText(String.valueOf(expandleListText.getTong()));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
