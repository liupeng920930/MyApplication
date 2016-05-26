package com.bujuzuoye;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class shoujifenbianlv extends Activity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoujifenbianlv);
        tv1= (TextView) findViewById(R.id.kuandu);
        tv2= (TextView) findViewById(R.id.gaodu);
        tv3= (TextView) findViewById(R.id.midu);
        tv4= (TextView) findViewById(R.id.dpi);
    }
    public  void  huoqu(View v){
        DisplayMetrics h=new DisplayMetrics();
        h=getResources().getDisplayMetrics();
        int w=h.widthPixels;
        int gao=h.heightPixels;
        float d=h.density;
        int dp=h.densityDpi;
        tv1.setText("宽是"+w+"寸");
        tv2.setText("高是"+gao+"寸");
        tv3.setText("手机密度是"+d+"");
        tv4.setText("手机dp是"+dp+"");
    }
}
