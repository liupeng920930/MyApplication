package com.example.administrator.myapplication;/**
 * Created by Administrator on 2016/6/1.
 */

import android.app.Activity;
import android.os.Bundle;

import com.fuleiACtivity.BaseActivity;

public class huaban extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        huabu b=new huabu(this);
        b.setOnTouchListener(b);
        setContentView(b);
    }
}

