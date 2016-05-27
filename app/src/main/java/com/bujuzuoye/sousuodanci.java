package com.bujuzuoye;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;
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
 * Created by Administrator on 16-5-24.
 */
public class sousuodanci extends BaseActivity {
    SearchView sv;
    ListView lv;
    List<Map<String,Object>> res;
    List<dancibean.ResultBean> list;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String str = (String) b.get("str");
            Gson gson=new Gson();
            dancibean dan=gson.fromJson(str,dancibean.class);
            list=dan.getResult();
           for (dancibean.ResultBean a:list){
               Map<String,Object> map=new HashMap<String,Object>();
               map.put("name",a.getName());
               res.add(map);
           }
            SimpleAdapter a=new SimpleAdapter(sousuodanci.this,res,android.R.layout.simple_expandable_list_item_1,new String[]{"name"},new int[]{android.R.id.text1});
            lv.setAdapter(a);
        }
    };
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.sousuodanci);
        sv= (SearchView) findViewById(R.id.danci);
        lv= (ListView) findViewById(R.id.list);
        res=new ArrayList<Map<String, Object>>();
        list=new ArrayList<dancibean.ResultBean>();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {
                res.clear();
                if(query.equals("")||query==null){

                }else {
                    (new Thread() {
                        @Override
                        public void run() {
                            String httpUrl = "http://apis.baidu.com/avatardata/chengyu/search";
                            String httpArg = "dtype=JSON&keyWord=" + query + "&page=1&rows=20";
                            BufferedReader reader = null;
                            String result = null;
                            StringBuffer sbf = new StringBuffer();
                            httpUrl = httpUrl + "?" + httpArg;
                            try {
                                URL url = new URL(httpUrl);
                                HttpURLConnection connection = (HttpURLConnection) url
                                        .openConnection();
                                connection.setRequestMethod("GET");
                                connection.setRequestProperty("apikey", "562bafef6007883e2e8fffbbdfa9e6ac");
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
                                b.putSerializable("str", result);
                                m.setData(b);
                                h.sendMessage(m);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
                return true;
            }
            @Override
            public boolean onQueryTextChange(final String newText) {
                return false;
            }
        });

    }
}
