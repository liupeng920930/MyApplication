package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/8.
 */

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

import java.io.File;
import java.io.IOException;

public class fangshengyin extends Activity {
    MediaPlayer mp;
    MediaRecorder recorder;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fangshengyin);
        mp=new MediaPlayer();

    }
    public void record(View view)
    {
        try{
            file = new File("/mnt/sdcard/sound.amr");
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(file.getAbsolutePath());
            recorder.prepare();
            recorder.start();
        }catch(Exception e){
            Log.e("error",e.getMessage());
        }
    }

    public void stop(View view)
    {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
    }
    public void bofang(View view){
        try {
            mp.setDataSource("/mnt/sdcard/sound.amr");
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
    }
}
