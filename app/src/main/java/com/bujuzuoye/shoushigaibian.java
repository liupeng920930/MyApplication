package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/6.
 */

import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class shoushigaibian extends BaseActivity implements GestureDetector.OnGestureListener{
    ImageView gaibian;
    GestureDetector detector;
    Bitmap bt;
    int w, h;
    float curr=1;
    Matrix matrix;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.shoushigaibian);
        gaibian= (ImageView) findViewById(R.id.gaibian);
        bt= BitmapFactory.decodeResource(getResources(), R.drawable.qq);
        gaibian.setImageBitmap(bt);
        detector=new GestureDetector(this,this);
        matrix=new Matrix();
        w=bt.getWidth();
        h=bt.getHeight();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        velocityX=velocityX>4000?4000:velocityX;
        velocityX=velocityX<-4000?-4000:velocityX;
        curr+=curr*velocityX/4000.0f;
        curr=curr>0.01f?curr:0.01f;
        matrix.reset();
        matrix.setScale(curr,curr,160,200);
//        BitmapDrawable tmp= (BitmapDrawable) gaibian.getDrawable();
//        if(!tmp.getBitmap().isRecycled()){
//            tmp.getBitmap().recycle();
//        }
        Bitmap bt2=Bitmap.createBitmap(bt,0,0,w,h,matrix,true);
        gaibian.setImageBitmap(bt2);
        return true;
    }
}
