package com.zrgj.tanqiu;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 16-5-13.
 */
public class Tanqiu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        qiu v=new qiu(this);
        v.setOnTouchListener(v);
        setContentView(v);
    }
}
