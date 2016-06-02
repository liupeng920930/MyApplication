package com.example.administrator.myapplication;/**
 * Created by Administrator on 2016/6/1.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;


public class huabu extends View implements View.OnTouchListener {
    Bitmap bit;
    Canvas can;
    Paint p;
    Path path;
    float prex;
    float prey;
    public huabu(Context context) {
        super(context);
        bit=Bitmap.createBitmap(1080,1920,Bitmap.Config.ARGB_8888);
        can=new Canvas();
        can.setBitmap(bit);
        p = new Paint();
        path=new Path();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        p.setAntiAlias(true);
        p.setDither(true);
        canvas.drawBitmap(bit,0,0,p);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x=event.getX();
        float y= event.getY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
               path.moveTo(x,y);
                prex=x;
                prey=y;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(prex,prey,x,y);
                prex=x;
                prey=y;
                break;
            case MotionEvent.ACTION_UP:
                path.reset();
                break;
        }
        can.drawPath(path,p);
        invalidate();
        return true;
    }
}
