package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-12.
 */
public class Zidingyi extends View implements View.OnTouchListener {
     Bitmap bit;
    Canvas can;
    Paint p;
    int c[]={Color.BLUE,Color.RED,Color.GREEN,Color.CYAN};
    int i=0;
    public Zidingyi(Context context) {
        super(context);
        bit=Bitmap.createBitmap(1080,1920,Bitmap.Config.ARGB_8888);
        can=new Canvas();
        can.setBitmap(bit);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p = new Paint();
        p.setColor(c[(i++)%4]);
        p.setAntiAlias(true);
        p.setStrokeWidth(5);
        canvas.drawBitmap(bit,0,0,p);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
            float x=event.getX();
            float y= event.getY();
        for (float i = -2; i <= 2; i += 0.001) {
            float iy = (float) Math.sqrt(2 * Math.sqrt(i * i) - i * i);
            double oy =  -2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(i)));
            float ooy = (float) oy;
            can.drawPoint(i * 100 + x, -iy * 100 + y, p);
            can.drawPoint(i * 100 + x, -ooy * 100 + y, p);
        }
            invalidate();
        return true;
    }
}
