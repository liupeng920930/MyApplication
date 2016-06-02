package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/1.
 */

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class donghua extends BaseActivity{
    AnimationDrawable an;
    AlphaAnimation av1;
    RotateAnimation av2;
    AnimationSet av;
    MediaPlayer music;
    ImageView iv;
    ImageView iv2;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.donghua);
        iv = (ImageView) findViewById(R.id.baozha);
        iv2= (ImageView) findViewById(R.id.img);
        an = (AnimationDrawable) iv.getBackground();
        av=new AnimationSet(true);
        av1= new AlphaAnimation(1,0.2f);
        av1.setDuration(3000);
        av1.setFillAfter(true);
        av2=new RotateAnimation(0, 360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        av2.setDuration(3000);
        av2.setFillAfter(true);
        av.addAnimation(av1);
        av.addAnimation(av2);
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                an.start();
                if(music == null)
                {
                    music = MediaPlayer.create(donghua.this,R.raw.bomb);
                }
                music.start();
                return true;
            }
        });
    }
public  void zhuan(View v){
    iv2.startAnimation(av);

}


}
