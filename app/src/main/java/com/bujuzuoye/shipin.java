package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/8.
 */

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

import java.io.File;

public class shipin extends Activity {
    VideoView vv;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipin);
        vv= (VideoView) findViewById(R.id.shipin);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        mc=new MediaController(this);
        File video=new File("/mnt/sdcard/mm.mp4");
        if(video.exists()){
            vv.setVideoPath(video.getAbsolutePath());
            vv.setMediaController(mc);
            mc.setMediaPlayer(vv);
            vv.requestFocus();
        }
    }
}
