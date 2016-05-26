package com.bujuzuoye;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

/**
 * Created by Administrator on 16-5-16.
 */
public class duanxinyanzheng extends BaseActivity {
    int i=6;
    Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.duanxinyanzheng);
        super.onCreate(savedInstanceState);
    }
 android.os.Handler h=new android.os.Handler(){
     @Override
     public void handleMessage(Message msg) {
         super.handleMessage(msg);
         Button b= (Button) findViewById(R.id.button4);
         if(msg.what==0x111&&i!=0){
             b.setEnabled(false);
             b.setText("发送中..."+i);
             i--;
         }else{
             i=6;
             b.setEnabled(true);
             b.setText("重新获取");
             t.cancel();
         }

     }
 };
    public void yanzheng(View view){

       t=new Timer();
        t.schedule( new TimerTask(){
            @Override
            public void run() {
                Message m=new Message();
                m.what=0x111;
                h.sendMessage(m);
            }
        },100,1000);
    }

}
