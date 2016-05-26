package com.bujuzuoye;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleAdapter;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 16-5-23.
 */
public class zidongsousuo  extends Activity {
    String[] a={"aab","abc","bbc","bac","cca","cba","das"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zizongsousuo);
        AutoCompleteTextView au= (AutoCompleteTextView) findViewById(R.id.auto);
        ArrayAdapter ss=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,a);
        au.setAdapter(ss);
    }
}
