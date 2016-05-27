package com.tupianshang;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

/**
 * Created by Administrator on 16-5-17.
 */
public class tupianjubuxianshi extends BaseActivity{
    Bitmap bt1;
    Bitmap bt2;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.tupianjubuxianshi);
        img = (ImageView) findViewById(R.id.imgid);
        img2=(ImageView) findViewById(R.id.jubuimgid);

        bt1= BitmapFactory.decodeResource(getResources(),tu[Math.abs(i)%5]);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x= (int) event.getX();
                int y= (int) event.getY();
                bt2=Bitmap.createBitmap(bt1,x,y,50,50);
                img2.setImageBitmap(bt2);
                return false;
            }
        });

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


}
