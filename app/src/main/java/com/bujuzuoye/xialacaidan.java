package com.bujuzuoye;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

/**
 * Created by Administrator on 16-5-23.
 */
public class xialacaidan extends BaseActivity {
    String[] i={"java","jsp","mysql","c","c++"};
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.xialacaidan);
        Spinner s= (Spinner) findViewById(R.id.xiala);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,i);
        s.setAdapter(aa);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String aa="你选择地是"+i[position];
                Toast.makeText(xialacaidan.this, aa, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
