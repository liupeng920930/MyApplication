package com.com.zrgj.feiji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bujuzuoye.zidan;
import com.example.administrator.myapplication.R;

import java.lang.reflect.Field;
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
    int b=0;
    Bitmap bitmap;
    Bitmap bitmap2;
    Bitmap bitmap3;
    Bitmap bitmap4;
    Bitmap bitmap5;
    AnimationDrawable an;
    Context context;
    List<zidan> list;
    List<diji> list1;
    Matrix m;
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
        this.context=context;
        m=new Matrix();
        m.setScale(0.35f,0.35f);
        bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.plane);
        bitmap2= BitmapFactory.decodeResource(getResources(), R.drawable.bullet_04);
        bitmap3=Bitmap.createBitmap(bitmap2,0,0,bitmap2.getWidth(),bitmap2.getHeight(),m,false);
        bitmap4= BitmapFactory.decodeResource(getResources(), R.drawable.dijitupian);
        bitmap5=Bitmap.createBitmap(bitmap4,0,0,bitmap4.getWidth(),bitmap4.getHeight(),m,false);
        list=new ArrayList<zidan>();
        list1=new ArrayList<diji>();
        hua();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        final Paint p=new Paint();
        super.onDraw(canvas);
        for (int i=list1.size()-1;i>=0;i--) {
            if(b==1){
                b=0;
                break;
            }
            if(list1.get(i).y>1500){
                list1.remove(i);
                break;
            }
            for (int j=list.size()-1;j>=0;j--) {
                if((list.get(j).x)<(list1.get(i).x+200)&&(list.get(j).x)>(list1.get(i).x-70)&&(list.get(j).y)>(list1.get(i).y-20)&&(list.get(j).y)<(list1.get(i).y+80))
                {
                  //  int x= (int) list1.get(i).x;
                  //  int y= (int) list1.get(i).y;
                    list1.remove(i);
                    list.remove(j);
                    b=1;
                    break;
                }
                if(list.get(j).y<0)
                {
                    list.remove(j);
                    break;
                }

            }


        }

       // bt=Bitmap.createBitmap(bitmap3,70,touy,1080,1920);
        //canvas.drawBitmap(bt,0,0,p);
        canvas.drawBitmap(bitmap,feix,feiy,p);

        for(zidan ee:list){
            canvas.drawBitmap(bitmap3,ee.x,ee.y,p);
            ee.y-=35;
        }
        if(list1.size()==0){

        }
        else {
            for (diji ee : list1) {
                canvas.drawBitmap(bitmap5, ee.x, ee.y, p);
                ee.y += 15;
            }
        }
        shu++;
        if(touy<=500||touy>1000){
            touy=1000;
        }else{
            touy-=20;
        }
        if(shu%4==0){
            zidan zi=new zidan();
            zi.x=feix+105;
            zi.y=feiy-100;
            if(shu>=10000){
                shu=1;
            }
            list.add(zi);
        }
        if(shu%40==0){
            diji zi=new diji();
            zi.x= (float) (Math.random()*850);
            zi.y=5;
            if(shu>=10000){
                shu=1;
            }
            list1.add(zi);
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
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
class myview extends ImageView{

    public myview(Context context) {
        super(context);
    }
    public void setl(int top,int left){
        this.setFrame(left,top,left+40,top+40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        try {
            Field field=AnimationDrawable.class.getDeclaredField("mCurFrame");
            field.setAccessible(true);
            int curFrame=field.getInt(an);
            if(curFrame==an.getNumberOfFrames()-1){
                setVisibility(View.INVISIBLE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDraw(canvas);
    }
}
}
