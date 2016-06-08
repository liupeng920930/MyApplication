package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/6.
 */

import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class shoushigaibian extends BaseActivity {
    ImageView gaibian;

    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.shoushigaibian);
        gaibian= (ImageView) findViewById(R.id.gaibian);
    }
}
