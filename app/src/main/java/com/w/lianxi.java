package com.w;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 16-5-25.
 */
public class lianxi extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w);
        QuickContactBadge qq= (QuickContactBadge) findViewById(R.id.qu);
        qq.assignContactFromPhone("15134066912",true);

    }
}
