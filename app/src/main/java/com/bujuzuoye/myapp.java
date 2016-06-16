package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/16.
 */

import android.app.Application;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.fuleiACtivity.BaseActivity;

public class myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
