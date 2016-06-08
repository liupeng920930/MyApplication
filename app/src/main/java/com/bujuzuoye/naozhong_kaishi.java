package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/7.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;
import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class naozhong_kaishi extends Activity {
    SpeechSynthesizer speechSynthesizer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiantingdianhua);
        Toast.makeText(naozhong_kaishi.this, "闹钟时间到了", Toast.LENGTH_SHORT).show();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("8224326");
        speechSynthesizer.setApiKey("hBojimyURCyAI2aHVhUhbW0F", "be6109332d081d4228116f1df11d8b17");
        speechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEED, "10");
        speechSynthesizer.initTts(TtsMode.ONLINE);
        speechSynthesizer.speak("亲爱的老师，该下课了！");

    }
}
