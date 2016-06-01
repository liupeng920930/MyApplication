package com.bujuzuoye;/**
 * Created by Administrator on 2016/5/31.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class chengshileibiao extends BaseActivity {
    TextView tv;

    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.chegnshi);
        tv = (TextView) findViewById(R.id.citychoos);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(chengshileibiao.this, chengshileibiao2.class);
                startActivityForResult(i, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 111) {
            String ci = data.getStringExtra("cccc");
            tv.setText(ci);
        }
    }
}