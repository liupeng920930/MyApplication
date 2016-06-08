package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/3.
 */

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class xueshengshuju extends BaseActivity {
    xueshenghelper xu;
    ListView lv;
    List<caipinbean> l;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.xueshengshuju);
        lv= (ListView) findViewById(R.id.caipin);
        xu=new xueshenghelper(this,"cai",null,1);
        Cursor c = xu.getReadableDatabase().query("caipin",null,null,null,null,null,null);
        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.caipinliebiao,c,new String[]{"_id","caiming","jiage"},new int[]{R.id.caiid,R.id.cainame,R.id.caijiage},0);
        lv.setAdapter(aca);
        l=new ArrayList<caipinbean>();
        while (c.moveToNext()){
            caipinbean cai=new caipinbean();
            cai.caiid=c.getInt(c.getColumnIndex("_id"));
            cai.cainame=c.getString(c.getColumnIndex("caiming"));
            cai.jiage=c.getInt(c.getColumnIndex("jiage"));
            l.add(cai);
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(xueshengshuju.this,caipinzengjia.class);
                String a=l.get(position).caiid+"@"+l.get(position).cainame+"@"+l.get(position).jiage;
                i.putExtra("cai",a);
                startActivity(i);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog builder=new AlertDialog.Builder(xueshengshuju.this)
                        .setTitle("提示框")
                        .setMessage("确认要删除吗？")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SQLiteDatabase db=xu.getReadableDatabase();
                                db.delete("caipin","_id=?",new String[]{l.get(position).caiid+""});
                                Intent i=new Intent(xueshengshuju.this,xueshengshuju.class);
                                startActivity(i);
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                builder.show();

                return true;
            }
        });
    }

    public  void  tianjia(View view){
        Intent i=new Intent(xueshengshuju.this,caipingengxin.class);
        startActivity(i);
    }
}
