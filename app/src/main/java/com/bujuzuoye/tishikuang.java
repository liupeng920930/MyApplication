package com.bujuzuoye;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-25.
 */
public class tishikuang extends Activity {
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duoxuantishikuang);
        ed= (EditText) findViewById(R.id.biancheng);
    }
    public void showmsg(View v){
        final String[] str={"c++","java","jsp","html","c"};
        final List list=new ArrayList();
        AlertDialog.Builder b=new AlertDialog.Builder(this)
                .setTitle("语言列表")
                .setIcon(R.drawable.qq)
                .setMultiChoiceItems(str, new boolean[]{false,false,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked){
                            list.add(str[which]+",");
                        }else{
                            list.remove(str[which]+",");
                        }
                    }
                })
                .setPositiveButton("确定",new DialogInterface.OnClickListener(){
                     @Override
                public void onClick(DialogInterface dialog, int which) {
                         String zhi="";
                         for(int i=0;i<list.size();i++){
                             zhi=zhi+list.get(i);
                         }
                       ed.setText(zhi);
                }
                });

                b.create().show();
    }

}
