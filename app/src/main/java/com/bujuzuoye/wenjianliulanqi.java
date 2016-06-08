package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/3.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wenjianliulanqi extends Activity {
    TextView textView;
    ListView listView;
    File curr;
    File[] cfiles;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wenjianliulanqi);
        textView= (TextView) findViewById(R.id.path);
        listView= (ListView) findViewById(R.id.list);
        File root=new File("/mnt/sdcard/");
        if(root.exists()) {
            curr = root;
            cfiles = root.listFiles();
            inlistview(cfiles);
        }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(cfiles[position].isFile())
                        return;
                    File[] tmp=cfiles[position].listFiles();
                    if(tmp==null||tmp.length==0){
                        Toast.makeText(wenjianliulanqi.this, "没有文件", Toast.LENGTH_SHORT).show();
                    }else{
                        curr=cfiles[position];
                        cfiles=tmp;
                        if(curr.equals(".jpg"))
                        inlistview(cfiles);
                    }
                }
            });
            Button an= (Button) findViewById(R.id.shangyiji);
            an.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        if(!curr.getCanonicalPath().equals("/mnt/sdcard/"))
                        {
                            curr=curr.getParentFile();
                            cfiles=curr.listFiles();
                            inlistview(cfiles);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    private void inlistview(File[] files)  {
        List<Map<String,Object>> listitems=new ArrayList<Map<String, Object>>();
        for(int i=0;i<files.length;i++){
            Map<String ,Object> listit=new HashMap<String,Object>();
            if(files[i].isDirectory()){
                listit.put("icon",R.drawable.wenjian);
            }else {
                listit.put("icon",R.drawable.wenjian2);
            }
            listit.put("fileName",files[i].getName());
            listitems.add(listit);
        }
        SimpleAdapter sim=new SimpleAdapter(this,listitems,R.layout.wenjian_line,new String[]{"icon","fileName"},new int[]{R.id.icont,R.id.filename});
        listView.setAdapter(sim);
        try {
            textView.setText("当前路径为："+curr.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


