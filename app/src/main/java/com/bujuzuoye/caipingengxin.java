package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/3.
 */

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class caipingengxin extends BaseActivity {
    EditText caiid;
    EditText cainame;
    EditText caijiage;
    int id1;
    String na;
    int jia1;
    xueshenghelper xu;
    SQLiteDatabase db;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.caipingengxin);
        caiid= (EditText) findViewById(R.id.caiid3);
        cainame= (EditText) findViewById(R.id.cainame3);
        caijiage= (EditText) findViewById(R.id.caijiage3);
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
        db.insert("caipin",null,c);
        Intent i=new Intent(this,xueshengshuju.class);
        startActivity(i);
    }
}
