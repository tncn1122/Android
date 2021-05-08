package com.tncnhan.android_giuaki;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomListAdapter_DSDIEM extends BaseAdapter {
    ArrayList<Diem> dsDiem=  new ArrayList<>();

    public CustomListAdapter_DSDIEM(ArrayList<Diem> dsDiem) {
        this.dsDiem = dsDiem;
    }

    @Override
    public int getCount() {
        return dsDiem.size();
    }

    @Override
    public Object getItem(int position) {
        return dsDiem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewitem= View.inflate(parent.getContext(),R.layout.item_nhapdiem_layout,null);
        Diem nhapdiem= (Diem) getItem(position);
        ((TextView)viewitem.findViewById(R.id.txtMaSV)).setText(nhapdiem.sv.getID());
        ((TextView)viewitem.findViewById(R.id.txtHoTenSV)).setText(String.valueOf(nhapdiem.sv.getName()));
        String score;
        if(nhapdiem.diem < 0){
            score = "";
        }
        else{
            score = String.valueOf(nhapdiem.diem);
        }
        TextView txtDiem = (TextView) viewitem.findViewById(R.id.edtDiem);
        txtDiem.setText(score);
        txtDiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Diem cur = dsDiem.get(position);
                try{
                    cur.diem = Float.valueOf(s.toString());
                }
                catch (Exception e){
                    cur.diem = -1;
                }
                dsDiem.set(position, cur);
            }
        });

        return viewitem;
    }
}
