package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/16.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.fuleiACtivity.BaseActivity;

public class baiduhelper extends SQLiteOpenHelper {
    final String sql="create table ditu(_id int primary key autoincrement,jindu double,weidu double)";

    public baiduhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
