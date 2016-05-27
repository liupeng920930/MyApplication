package com.tupianxunhua;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

/**
 * Created by Administrator on 16-5-16.
 */
public class huatu extends BaseActivity {
    int[] a={R.drawable.gallerymin1,R.drawable.gallerymin2,R.drawable.gallerymin3,R.drawable.gallerymin4,R.drawable.gallerymin5};
    int i=1;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.tupianxunhua);
    }

    public void huan(View view){
        ImageView im= (ImageView) findViewById(R.id.imageView);
        im.setImageResource(a[i%5]);
        i++;
    }
}
