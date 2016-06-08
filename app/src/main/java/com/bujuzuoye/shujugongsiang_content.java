package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/6.
 */

import android.app.Activity;
import android.content.ContentProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class shujugongsiang_content extends Activity{
    Cursor c;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shujugongxiang);
        c = getContentResolver().query(Uri.parse("content://com.ralph.second/students"),null,null,null,null);
        lv= (ListView) findViewById(R.id.shuju);
    }
    public void chaxunshuju(View v){
        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.shujugongxiang_row,c,new String[]{"_id","name","age"},new int[]{R.id.shushengid,R.id.shushengname,R.id.shushengage},0);
        lv.setAdapter(aca);
    }
}
