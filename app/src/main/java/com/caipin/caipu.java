package com.caipin;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-5-18.
 */
public class caipu extends Activity {
    EditText et;
    ListView tv;
    List<caipinbean.TngouBean> list=new ArrayList<caipinbean.TngouBean>();
    List<Map<String,Object>> res =new ArrayList<Map<String,Object>>();
     Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b=msg.getData();
            String str= (String) b.get("str");
            Gson gson=new Gson();
            caipinbean cai=gson.fromJson(str,caipinbean.class);
            list=cai.getTngou();
            for(caipinbean.TngouBean s:list){
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("name",s.getDescription());
                map.put("img",s.getImg());
                res.add(map);
            }
            SimpleAdapter ss=new SimpleAdapter(caipu.this,res,R.layout.caipu_list,new String[]{"name","img"},new int[]{R.id.yonglian, R.id.img});
            tv.setAdapter(ss);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caipu);
        et= (EditText) findViewById(R.id.mingzi);
        tv= (ListView) findViewById(R.id.caipu);
    }
    public void cha(View view){
        (new Thread(){
            @Override
            public void run() {
                String httpUrl = "http://apis.baidu.com/tngou/cook/name";
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                httpUrl = httpUrl + "?name="+et.getText().toString();

                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("apikey",  "562bafef6007883e2e8fffbbdfa9e6ac");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    reader.close();
                    result = sbf.toString();

                    Message m = new Message();
                    Bundle b = new Bundle();
                    b.putSerializable("str",result);
                    m.setData(b);
                    h.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
