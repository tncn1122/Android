package com.tncnhan.android_giuaki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ThongKeActivity extends AppCompatActivity {
    DBHelper DBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        Intent intent = getIntent();
        String classId = intent.getStringExtra("classId");
        DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);
        createChart(classId);
        Log.d("asdfasdf", classId);


    }

    String getCharScore(Float score){
        if(score >= 8.5){
            return "A, A+";
        }
        else if(score >= 7.0){
            return "B, B+";
        }
        else if(score >= 5.5){
            return "C, C+";
        }
        else if (score >= 4.0){
            return "D, D+";
        }
        return "F";
    }

    void createChart(String classID){

        List<PieEntry> entries = new ArrayList<>();

        Map<String, Integer> res = new HashMap<String, Integer>();

        //DBhelper = new DBHelper(this,"qlcd.sqlite",null,1);
        float point;
        int total = 0;
        String rank;
        try{
            Cursor dt = DBhelper.GetData("SELECT score FROM score WHERE classid = '" + classID + "'");
            while(dt.moveToNext()){
                String tmp = dt.getString(0);
                if(tmp == null){
                    point = 0.0F;
                }
                else{
                    point = Float.valueOf(tmp);
                }

                rank = getCharScore(point);
                //Log.d("asdfasdf", res.get(rank).toString());
                if(res.containsKey(rank)){
                    res.put(rank, res.get(rank)+1);
                }
                else{
                    res.put(rank, 1);
                }
                total++;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        TextView txtThongke = findViewById(R.id.txtThongKe);
        if(total > 0){
            txtThongke.setText("Lớp: " + getClassName(classID));
        }
        else{
            txtThongke.setText("Lớp chưa có thông tin điểm");
        }
        for(Map.Entry<String, Integer> entry : res.entrySet()){
            entries.add(new PieEntry(entry.getValue()*1F/total*100, entry.getKey()));
            //Log.d("asdfasdf", String.valueOf(entry.getValue()/total*100));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Điểm Hệ Chữ");

        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(new int[]{R.color.color1 , R.color.color2, R.color.color3, R.color.color4, R.color.color5}, ThongKeActivity.this);
        dataSet.setValueTextSize(15);
        dataSet.setValueTextColor(Color.WHITE);



        PieData data = new PieData(dataSet);


        PieChart chart = (PieChart) findViewById(R.id.chart);
        data.setValueFormatter(new PercentFormatter(chart));
        chart.setUsePercentValues(true);
        chart.setData(data);
        chart.animateX(700);
        chart.getDescription().setEnabled(false);
        chart.setCenterText(getStudentCount(classID));

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        chart.invalidate();
    }


    String getClassName(String classID){
        String res = "";
        try{
            Cursor dt = DBhelper.GetData("SELECT classname FROM class where classid = '" + classID +"'");
            dt.moveToNext();
            res = dt.getString(0);
        }catch (Exception e){

        }
        return res;
    }

    SpannableString getStudentCount(String classID){
        String res = "";
        try{
            Cursor dt = DBhelper.GetData("SELECT COUNT(1) FROM score where classid =  '" + classID +"'");
            dt.moveToNext();
            res = dt.getString(0);
        }catch (Exception e){

        }
        SpannableString s = new SpannableString(res + " Sinh Viên");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, res.length(), 0);

        return s;
    }


}