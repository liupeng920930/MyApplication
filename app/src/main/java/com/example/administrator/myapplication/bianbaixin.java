package com.example.administrator.myapplication;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bianbaixin extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Zidingyi v=new Zidingyi(this);
        v.setOnTouchListener(v);
        setContentView(v);
    }



}
