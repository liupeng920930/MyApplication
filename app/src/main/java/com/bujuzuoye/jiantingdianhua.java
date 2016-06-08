package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/7.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;
import com.example.administrator.myapplication.R;

public class jiantingdianhua extends Activity {
    TelephonyManager tm;
    SpeechSynthesizer speechSynthesizer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiantingdianhua);
        speechSynthesizer=SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("8224326");
        speechSynthesizer.setApiKey("hBojimyURCyAI2aHVhUhbW0F", "be6109332d081d4228116f1df11d8b17");
        speechSynthesizer.initTts(TtsMode.ONLINE);
        tm= (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        PhoneStateListener listener=new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                switch (state){
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        Toast.makeText(jiantingdianhua.this, incomingNumber+"sd", Toast.LENGTH_SHORT).show();
                        speechSynthesizer.speak(incomingNumber+"给你打电话了");

                        break;
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };
        tm.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }

}
