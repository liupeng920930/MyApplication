package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/6.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;
import com.example.administrator.myapplication.R;


public class yuyinlangdu extends Activity {
    SpeechSynthesizer speechSynthesizer;

    EditText text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yuyinlangdu);
        speechSynthesizer=SpeechSynthesizer.getInstance();
        text= (EditText) findViewById(R.id.text);
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("8224326");
        speechSynthesizer.setApiKey("hBojimyURCyAI2aHVhUhbW0F", "be6109332d081d4228116f1df11d8b17");
        speechSynthesizer.initTts(TtsMode.ONLINE);

    }

    public void du(View view){
        speechSynthesizer.speak(text.getText().toString());
    }
    public void luru(View view){


    }
}
