package com.example.administrator.myapplication;

import android.content.Context;
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

    public Zidingyi(Context context) {
        super(context);

    }
    List<bea> list=new ArrayList<bea>();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();



        p.setAntiAlias(true);
        p.setStrokeWidth(5);
     for (bea mm:list) {
         p.setColor(mm.getCol());
         for (float i = -2; i <= 2; i += 0.001) {
             float iy = (float) Math.sqrt(2 * Math.sqrt(i * i) - i * i);
             double oy =  -2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(i)));
             float ooy = (float) oy;
             canvas.drawPoint(i * 100 + mm.getX(), -iy * 100 + mm.getY(), p);
             canvas.drawPoint(i * 100 + mm.getX(), -ooy * 100 + mm.getY(), p);

         }
     }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        bea b=new bea();
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            float x=event.getX();
            float y= event.getY();
            b.setX(x);
            b.setY(y);
            int c=0xff000000+(int)(Math.random()*0xffffff);
            b.setCol(c);
            list.add(b);
            invalidate();
        }

        return true;
    }


}
