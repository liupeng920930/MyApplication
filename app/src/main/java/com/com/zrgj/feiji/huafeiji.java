package com.com.zrgj.feiji;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bujuzuoye.zidan;
import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-13.
 */
public class huafeiji extends Activity {
    int x=300;
    int y=200;
    List<zidan> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        list=new ArrayList<zidan>();
        super.onCreate(savedInstanceState);
        huaplane v=new huaplane(this);
        v.setOnTouchListener(v);
        setContentView(v);
    }



}
