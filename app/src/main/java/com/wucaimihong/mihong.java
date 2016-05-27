package com.wucaimihong;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

/**
 * Created by Administrator on 16-5-16.
 */
public class mihong extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics mm=new DisplayMetrics();
        mm=getResources().getDisplayMetrics();
        int w=mm.widthPixels;
        int h=mm.heightPixels;
        float density=mm.density;
        int densityDpi=mm.densityDpi;
        huadeng hua=new huadeng(this);
        setContentView(hua);
    }
}
