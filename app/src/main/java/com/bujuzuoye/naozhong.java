package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/7.
 */

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

import java.util.Calendar;

public class naozhong extends Activity {
    Button an;
    Calendar curr=Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naozhong);
        an= (Button) findViewById(R.id.nao);
        an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar curr=Calendar.getInstance();
                new TimePickerDialog(naozhong.this, 0, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Intent i=new Intent(naozhong.this,naozhong_kaishi.class);
                        PendingIntent pi=PendingIntent.getActivity(naozhong.this,0,i,0);
                        Calendar c=Calendar.getInstance();
                        c.setTimeInMillis(System.currentTimeMillis());
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        AlarmManager am= (AlarmManager) getSystemService(ALARM_SERVICE);
                        am.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pi);
                        Toast.makeText(naozhong.this, "成功设置", Toast.LENGTH_SHORT).show();
                    }
                },curr.get(Calendar.HOUR_OF_DAY),curr.get(Calendar.MINUTE),false).show();
            }
        });

    }
}
