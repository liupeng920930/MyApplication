package com.bujuzuoye;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

/**
 * Created by Administrator on 16-5-17.
 */
public class duoxunaanniu extends BaseActivity {
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.duoxuananniu);
        rg= (RadioGroup) findViewById(R.id.xingbie);
        cb1= (CheckBox) findViewById(R.id.checkBox);
        cb2= (CheckBox) findViewById(R.id.checkBox2);
        cb3= (CheckBox) findViewById(R.id.checkBox3);

    }
    RadioGroup rg;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    int xingbei;

    public  void  xianshi(View view){
        xingbei=rg.getCheckedRadioButtonId();
        String x="";
        String z="";
        if(xingbei==R.id.nv){
            x="女";
        }else if(xingbei==R.id.nan){
            x="男";
        }
        if(cb1.isChecked()){
            z="专科，";
        }
        if(cb2.isChecked()){
            z=z+"本科，";
        }
        if(cb3.isChecked()){
            z=z+"研究生";
        }
        String xian="你选择的性别是"+x+",学历是"+z;
        Toast.makeText(duoxunaanniu.this, xian, Toast.LENGTH_SHORT).show();
    }

}
