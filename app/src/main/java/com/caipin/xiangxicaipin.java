package com.caipin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-5-19.
 */
public class xiangxicaipin extends Activity{
    List<Map<String,Object>> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiangxicaipin);
        TextView tv1= (TextView) findViewById(R.id.caipin1);
        TextView tv2= (TextView) findViewById(R.id.caipin2);
        TextView tv3= (TextView) findViewById(R.id.caipin3);
        TextView tv4= (TextView) findViewById(R.id.caipin4);
        TextView tv5= (TextView) findViewById(R.id.caipin5);
        TextView tv6= (TextView) findViewById(R.id.caipin6);
        list=new ArrayList<Map<String, Object>>();
        Bundle a= getIntent().getBundleExtra("name");
        Map<String,Object> map= (Map<String, Object>) a.get("str");
        tv1.setText((String)map.get("name"));
        tv2.setText((Integer) map.get("jiage"));
        tv3.setText((Integer) map.get("huodongjia"));
        tv4.setText((String)map.get("danwei"));
        tv5.setText((String)map.get("leixing"));
        tv6.setText((Integer) map.get("bianhao"));



    }
}
