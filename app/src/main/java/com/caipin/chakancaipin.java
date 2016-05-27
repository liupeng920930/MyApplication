package com.caipin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-5-18.
 */
public class chakancaipin extends BaseActivity {

    GridView tv;

    List<caipubean.RowsBean> list=new ArrayList<caipubean.RowsBean>();
    List<Map<String,Object>> res =new ArrayList<Map<String,Object>>();
     Handler h=new Handler(){
         @Override
         public void handleMessage(Message msg) {
             super.handleMessage(msg);
             Bundle b=msg.getData();
             String str= (String) b.get("str");
             Gson gson=new Gson();
             caipubean c=gson.fromJson(str,caipubean.class);
             list=c.getRows();
             for(caipubean.RowsBean s:list){
                 Map<String,Object> map=new HashMap<String,Object>();
                 map.put("name",s.getCainame());
                 map.put("jiage",s.getCaijiage());
                 map.put("huodongjia",s.getHoudongjia());
                 map.put("danwei",s.getDanweiname());
                 map.put("leixing",s.getLeixingname());
                 map.put("bianhao",s.getCaiid());
                 res.add(map);
             }
             SimpleAdapter ss=new SimpleAdapter(chakancaipin.this,res,R.layout.chakancaipin_rows,new String[]{"name","jiage"},new int[]{R.id.name, R.id.jiage});
             tv.setAdapter(ss);
         }
     };
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.chakancaipin);
        tv= (GridView) findViewById(R.id.cai);
        tv.setColumnWidth(2);
        tv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(chakancaipin.this,xiangxicaipin.class);
                Bundle b=new Bundle();
                b.putSerializable("str", (Serializable) res.get(position));
                i.putExtra("name",b);
                startActivity(i);
            }
        });

    }


     public void caidan(View view){
         (new Thread(){
             @Override
             public void run() {
                 String httpUrl = "http://192.168.1.12:8080/webhellos/upfasongcaipin";
                 StringBuffer sbf = new StringBuffer();
                 String result = null;
                 try {
                     URL  url = new URL(httpUrl);
                     HttpURLConnection connection = (HttpURLConnection) url .openConnection();
                     connection.setRequestMethod("GET");
                     connection.connect();
                     InputStream is = connection.getInputStream();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                     String strRead = null;
                     while ((strRead = reader.readLine()) != null) {
                         sbf.append(strRead);
                         sbf.append("\r\n");
                     }
                     reader.close();
                     is.close();
                     result = sbf.toString();
                     Message mm=new Message();
                     Bundle b=new Bundle();
                     b.putSerializable("str",result);
                     mm.setData(b);
                     h.sendMessage(mm);
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (ProtocolException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }).start();
     }


}
