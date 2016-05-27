package com.bujuzuoye;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2016/5/27.
 */
public class taobao extends Activity {
    ImageSwitcher is;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taobao);
        is= (ImageSwitcher) findViewById(R.id.taobao);
        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return null;
            }
        });
    }
}
