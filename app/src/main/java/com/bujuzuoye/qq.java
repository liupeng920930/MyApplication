package com.bujuzuoye;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

/**
 * Created by Administrator on 16-5-16.
 */
public class qq extends BaseActivity {
    EditText name;
    EditText pwd;
    CheckBox zidong;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    boolean zhen;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.qq);
        sp = getSharedPreferences("qq",MODE_PRIVATE);
        editor = sp.edit();
        name= (EditText) findViewById(R.id.name);
        pwd= (EditText) findViewById(R.id.pwd);
        zidong= (CheckBox) findViewById(R.id.zidong);
        zhen=sp.getBoolean("zidong",false);
        if(zhen){
            Intent i=new Intent(qq.this,duanxinyanzheng.class);
            startActivity(i);
        }
    }

    public  void denglu(View v){
        String n=name.getText().toString();
        String m=pwd.getText().toString();

        if(n.equals("admin")&&m.equals("123")){
            if(zidong.isChecked()){
                editor.putBoolean("zidong",true);
                editor.commit();
            }else
            {
                editor.putBoolean("zidong",false);
                editor.commit();
            }
            Intent i=new Intent(qq.this,duanxinyanzheng.class);
            startActivity(i);
        }

    }
}
