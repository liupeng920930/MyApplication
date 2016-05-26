package com.bujuzuoye;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class xuanxiangka extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.xuanxiangka);
        TabHost host = getTabHost();

        TabHost.TabSpec tab1 = host.newTabSpec("tab1").setIndicator("我的主页").setContent(R.id.tab1);
        host.addTab(tab1);

        TabHost.TabSpec tab2 = host.newTabSpec("tab2").setIndicator("我的头像").setContent(R.id.tab2);
        host.addTab(tab2);
    }
}
