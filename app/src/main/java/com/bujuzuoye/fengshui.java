package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/13.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class fengshui extends BaseActivity  implements SensorEventListener {
    SensorManager manager;
    RotateAnimation av2;
    Bitmap b;
    ImageView feng;
    float curr=0f;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.fengshui);
        b= BitmapFactory.decodeResource(getResources(), R.drawable.fengshui);
        feng= (ImageView) findViewById(R.id.zhinazhen);
        feng.setImageBitmap(b);
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_UI);
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
        float NowX=event.values[0];
        av2 = new RotateAnimation(curr, -NowX, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        av2.setDuration(200);
        feng.startAnimation(av2);
        curr=-NowX;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
