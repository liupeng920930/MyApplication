package com.bujuzuoye;/**
 * Created by Administrator on 2016/5/27.
 */

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class hengshuping extends BaseActivity {
    GridLayout gl;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.hengshuping);
        gl= (GridLayout) findViewById(R.id.bujiu);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==(Configuration.ORIENTATION_LANDSCAPE)){
            gl.setColumnCount(3);
        }
        if(newConfig.orientation==(Configuration.ORIENTATION_PORTRAIT)){
            Intent i=new Intent(this,hengshuping.class);
            startActivity(i);
        }
    }
}
