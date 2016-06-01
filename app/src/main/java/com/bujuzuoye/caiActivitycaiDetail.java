package com.bujuzuoye;/**
 * Created by Administrator on 2016/5/30.
 */

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class caiActivitycaiDetail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cai2);

        if(savedInstanceState == null)
        {
            caiDetailFragment f = new caiDetailFragment();
            Bundle b = new Bundle();
            b.putInt("item_id",getIntent().getIntExtra("item_id",0));
            f.setArguments(b);

            getFragmentManager().beginTransaction().replace(R.id.book_detail_container,f).commit();
        }
    }
}
