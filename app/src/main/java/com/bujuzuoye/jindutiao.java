package com.bujuzuoye;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 16-5-23.
 */
public class jindutiao extends Activity {
    ImageView img;
    SeekBar see;
    RatingBar rat;
    ProgressBar pb;
    int zhi=0;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                rat.setVisibility(View.GONE);
            }else{
               pb.setProgress(zhi+=10);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jindutiao);
        img= (ImageView) findViewById(R.id.tu);
        see= (SeekBar) findViewById(R.id.seek);
        rat= (RatingBar) findViewById(R.id.rat);
        pb= (ProgressBar) findViewById(R.id.pb);
        see.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                img.setImageAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        rat.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                img.setImageAlpha((int) (rating*255/6));
            }
        });
        (new Thread(){
            @Override
            public void run() {
                while (zhi < 100) {
                    h.sendMessage(new Message());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message s = new Message();
                s.what = 1;
                h.sendMessage(s);

                }

        }).start();
    }

}
