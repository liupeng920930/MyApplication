package com.zrgj.tanqiu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 16-5-13.
 */
public class qiu extends View implements View.OnTouchListener{
    public qiu(Context context) {
        super(context);
    }
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
           super.handleMessage(msg);
           if (msg.what==0x111){
               if(x<=50){
                   bx=-bx;
               }else if(y<=50){
                  by=-by;
               }else if(x>=1020){
                   bx=-bx;
               }else if(x>=l&&x<=r&&y>=1630){
                   by=-by;
               }else{
                   t.cancel();
               }
               x+=bx;
               y+=by;

           }
            invalidate();

        }
    };

    int r=300;
    int l=0;
    int x=500;
    int y=700;
    int s=10;
    Timer t;
    int bx=(int)(Math.random()*40-20);
    int by=(int)(Math.random()*40-20);
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setStrokeWidth(5);
        p.setColor(Color.GRAY);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x,y,50,p);
        canvas.drawRect(l,1660,r,1700,p);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int hx= (int) event.getX();
       if(x==500){  t=new Timer();
           t.schedule(new TimerTask() {
            @Override
            public void run() {
                Message m=new Message();
                m.what=0x111;
                h.sendMessage(m);

            }
        },100,200);}
        l=hx-150;
        r=hx+150;
        invalidate();
        return true;
    }
}