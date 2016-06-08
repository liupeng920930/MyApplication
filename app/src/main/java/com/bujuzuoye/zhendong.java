package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/8.
 */

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class zhendong extends Activity {
    Vibrator vibrator;
    long[] zhen={200,400,800,1000};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhendong);
        vibrator= (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
    }
    public void kaishizhen(View view){
        vibrator.vibrate(zhen,0);
    }
    public void tingzhizhen(View view){
        vibrator.cancel();
    }
}
