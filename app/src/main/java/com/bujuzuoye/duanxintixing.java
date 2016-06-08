package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/7.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;
import com.fuleiACtivity.BaseActivity;

public class duanxintixing extends BroadcastReceiver {
   // SpeechSynthesizer speechSynthesizer;
    @Override
    public void onReceive(Context context, Intent intent) {
//        speechSynthesizer.setContext(context);
//        speechSynthesizer.setAppId("8224326");
//        speechSynthesizer.setApiKey("hBojimyURCyAI2aHVhUhbW0F", "be6109332d081d4228116f1df11d8b17");
//        speechSynthesizer.initTts(TtsMode.ONLINE);
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            abortBroadcast();
            StringBuilder sb=new StringBuilder();
            Bundle bundle=intent.getExtras();
            if(bundle!=null){
                Object[] pdus= (Object[]) bundle.get("pdus");
                SmsMessage[] sm=new SmsMessage[pdus.length];
                for(int i=0;i<pdus.length;i++){
                    sm[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
                }
                for(SmsMessage me:sm){
                    sb.append("短信来源");
                    sb.append(me.getDisplayOriginatingAddress());
                    sb.append("\n-----内容-----\n");
                    sb.append(me.getDisplayMessageBody());
                }
            }
            Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();
           // speechSynthesizer.speak(sb.toString());
        }
    }
}
