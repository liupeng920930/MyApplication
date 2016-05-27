package com.com.zrgj.feiji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import com.bujuzuoye.zidan;
import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-16.
 */
public class huaplane extends View implements View.OnTouchListener {
    int shoux;
    int shouy;
    int feix=500;
    int feiy=800;
    int x;
    int y;
    int shu=0;
    int zix;
    int ziy;
    Bitmap bitmap;
    Bitmap bitmap2;
    Bitmap bitmap3;
    Bitmap bt;
    List<zidan> list;
    int touy=1000;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            invalidate();
        }
    };
    public huaplane(Context context) {
        super(context);
        list=new ArrayList<zidan>();
        hua();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        final Paint p=new Paint();
        bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.plane);
        bitmap2= BitmapFactory.decodeResource(getResources(), R.drawable.bullet_04);
        bitmap3= BitmapFactory.decodeResource(getResources(), R.drawable.back);
        super.onDraw(canvas);
        bt=Bitmap.createBitmap(bitmap3,70,touy,1080,1920);
        canvas.drawBitmap(bt,0,0,p);
        canvas.drawBitmap(bitmap,feix,feiy,p);
        for(zidan ee:list){
            canvas.drawBitmap(bitmap2,ee.x,ee.y,p);
            ee.y-=40;
        }
        (new Thread(){
            @Override
            public void run() {
                for (int i=0;i<list.size();i++) {
                    if(list.get(i).y<0){
                        list.remove(i);
                    }
                }

            }
        }).start();
        shu++;
        if(touy<=500||touy>1000){
            touy=1000;
        }else{
            touy-=20;
        }
        if(shu%5==0){
            zidan zi=new zidan();
            zi.x=feix-20;
            zi.y=feiy-bitmap.getHeight();
            if(shu>=10000){
                shu=1;
            }
            list.add(zi);
        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
            shoux= (int) event.getX();
            shouy= (int) event.getY();

        if(shoux>feix+bitmap.getWidth()||shoux<feix||shouy>feiy+bitmap.getHeight()||shouy<feiy){

        }else{
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x=shoux-feix;
                y=shouy-feiy;
            case MotionEvent.ACTION_MOVE:
                    feix=shoux-x;
                    feiy=shouy-y;
                    return true;
            }
        }
        return true;
    }
    public void hua(){
        (new Thread(){
            @Override
            public void run() {
                while (true){
                    h.sendMessage(new Message());
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

}
