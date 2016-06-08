package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/6.
 */

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class caipinzengjia extends BaseActivity {
    EditText caiid;
    EditText cainame;
    EditText caijiage;
    int id1;
    String na;
    int jia1;
    xueshenghelper xu;
    SQLiteDatabase db;
    String cai1;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.caipingengxin);
        caiid= (EditText) findViewById(R.id.caiid3);
        cainame= (EditText) findViewById(R.id.cainame3);
        caijiage= (EditText) findViewById(R.id.caijiage3);
        Intent intent =getIntent();
        String first = intent.getStringExtra("cai");
        String[] a=first.split("@");
        cai1=a[0];
        caiid.setText(cai1);
        cainame.setText(a[1]);
        caijiage.setText(a[2]);
        xu=new xueshenghelper(this,"cai",null,1);
        db=xu.getReadableDatabase();

    }
    public void genxin(View view){
        String id2=caiid.getText().toString();
        na=cainame.getText().toString();
        String jia=caijiage.getText().toString();
        id1=Integer.parseInt(id2);
        jia1=Integer.parseInt(jia);
        ContentValues c=new ContentValues();
        c.put("_id",id1);
        c.put("caiming",na);
        c.put("jiage",jia1);
        db.update("caipin",c,"_id=?",new String[]{cai1});
        Intent i=new Intent(this,xueshengshuju.class);
        startActivity(i);
    }
}
