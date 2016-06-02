package com.com.zrgj.feiji;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bujuzuoye.zidan;
import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-13.
 */
public class huafeiji extends Activity {
    int x=300;
    int y=200;
    List<zidan> list;
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(music == null)
        {
            music = MediaPlayer.create(huafeiji.this,R.raw.mu);
        }
        music.start();
        list=new ArrayList<zidan>();
        super.onCreate(savedInstanceState);
        huaplane v=new huaplane(this);
        v.setOnTouchListener(v);
        setContentView(v);
    }



}
