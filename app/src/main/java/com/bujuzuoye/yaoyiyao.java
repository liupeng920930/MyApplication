package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/13.
 */

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.*;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class yaoyiyao extends BaseActivity  implements SensorEventListener {
    ImageView img;
    SensorManager manager;
    Bitmap b1;
    Bitmap b2;
    int p=0;
    RotateAnimation av2;
    //速度阀值
    private int mSpeed=3000;
    //时间间隔
    private int mInterval=50;
    //上一次摇晃的时间
    private long LastTime;
    //上一次的x、y、z坐标
    private float LastX,LastY,LastZ;
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        int i=(int)(Math.random()*10);
        String jiang="";
        if(i>=5){
            jiang="中奖啦";
        }else {
            jiang="谢谢惠顾";
        }
        super.handleMessage(msg);
        manager.unregisterListener(yaoyiyao.this);
        android.app.AlertDialog.Builder b = new android.app.AlertDialog.Builder(yaoyiyao.this)
                .setMessage(jiang)
                .setTitle("中奖信息")
                .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        manager.registerListener(yaoyiyao.this,manager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),SensorManager.SENSOR_DELAY_UI);
                    }
                });
             b.create().show();

    }
};
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.yaoyiyao);
        img= (ImageView) findViewById(R.id.tupian);
        b1=BitmapFactory.decodeResource(getResources(), R.drawable.yaoyiyao1);
        img.setImageBitmap(b1);
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    @Override
    protected void onResume() {
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }
    @Override
    protected void onStop() {
        manager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onPause() {
        manager.unregisterListener(this);
        super.onPause();
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        p++;
        long NowTime=System.currentTimeMillis();
        if((NowTime-LastTime)<mInterval)
            return;
        //将NowTime赋给LastTime
        LastTime=NowTime;
        //获取x,y,z
        float NowX=event.values[0];
        float NowY=event.values[1];
        float NowZ=event.values[2];
        //计算x,y,z变化量
        float DeltaX=NowX-LastX;
        float DeltaY=NowY-LastY;
        float DeltaZ=NowZ-LastZ;
        //赋值
        LastX=NowX;
        LastY=NowY;
        LastZ=NowZ;
        //计算
        double NowSpeed = Math.sqrt(DeltaX * DeltaX + DeltaY * DeltaY + DeltaZ * DeltaZ)/mInterval * 10000;
        //判断
        if(NowSpeed>=mSpeed)
        {
            if(p>5) {
                av2 = new RotateAnimation(0, 30, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                av2.setDuration(200);
                av2.setRepeatCount(2);
                av2.setFillAfter(false);
                img.startAnimation(av2);
            }
            if(p>12) {
                p=0;
                h.handleMessage(new Message());
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
