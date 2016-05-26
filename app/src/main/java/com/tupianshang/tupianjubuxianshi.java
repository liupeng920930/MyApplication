package com.tupianshang;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 16-5-17.
 */
public class tupianjubuxianshi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tupianjubuxianshi);
        img = (ImageView) findViewById(R.id.imgid);
        img2=(ImageView) findViewById(R.id.jubuimgid);
    }

    int[] tu = {R.drawable.gallerymin1, R.drawable.gallerymin2, R.drawable.gallerymin3, R.drawable.gallerymin4, R.drawable.gallerymin5};
    ImageView img;
    ImageView img2;
    int res;
    int i = 0;
    int al = 255;
    public void shang(View view) {
        img.setImageResource(tu[Math.abs(++i)%5]);
        res=tu[Math.abs(++i)%5];
    }

    public void xia(View view) {
        img.setImageResource(tu[Math.abs(--i)%5]);
        res=tu[Math.abs(--i)%5];
    }

    public void jia(View view) {
        al += 10;
        if (al < 255) {

            img.setImageAlpha(al);
        } else {
            img.setImageAlpha(255);
            al = 255;
        }

    }

    public void jian(View view) {
        al -= 10;
        if (al > 0) {

            img.setImageAlpha(al);
        } else {
            img.setImageAlpha(0);
            al = 0;
        }

    }
    public void fangda(View view){

    }

}
