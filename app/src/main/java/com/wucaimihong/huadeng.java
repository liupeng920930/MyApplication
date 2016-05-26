package com.wucaimihong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 16-5-16.
 */
public class huadeng extends View  {
    public huadeng(Context context) {
        super(context);
    }
    int shu=5;
    Paint p=new Paint();
    Paint p1=new Paint();
    Paint p2=new Paint();
    Paint p3=new Paint();
    Paint p4=new Paint();
    int[] list={Color.BLUE,Color.RED,Color.YELLOW,Color.GREEN,Color.BLACK};
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0x111){
                p.setColor(list[shu%5]);
                p1.setColor(list[(shu+1)%5]);
                p2.setColor(list[(shu+2)%5]);
                p3.setColor(list[(shu+3)%5]);
                p4.setColor(list[(shu+4)%5]);
                shu++;
            }
               invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(shu==5){
        Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Message m=new Message();
                m.what=0x111;
                h.sendMessage(m);

            }
        },100,1500);}

        canvas.drawRect(200,200,900,900,p);
        canvas.drawRect(300,300,800,800,p1);
        canvas.drawRect(400,400,700,700,p2);
        canvas.drawRect(500,500,600,600,p3);
        canvas.drawRect(520,520,580,580,p4);


    }

}
