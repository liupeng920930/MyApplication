package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/16.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.fuleiACtivity.BaseActivity;

public class kaiji extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context,kaijihuoqu.class);
        context.startService(i);
    }
}
