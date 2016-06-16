package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/16.
 */

import android.Manifest;
import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.fuleiACtivity.BaseActivity;

public class kaijihuoqu extends Service {
    LocationManager lm;
    double jin;
    double wei;
    baiduhelper bd;
    SQLiteDatabase db;
    Location l;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        bd=new baiduhelper(this,"baidu",null,1);
        db=bd.getReadableDatabase();
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 5, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updete(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(kaijihuoqu.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(kaijihuoqu.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                updete(l);
            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });
    }

    public void updete(Location l){
        if(l!=null)
        {
            jin =l.getLongitude();
            wei=l.getLatitude();
            ContentValues c=new ContentValues();
            c.put("jindu",jin);
            c.put("weidu",wei);
            db.insert("baidu",null,c);
        }else
        {
        }
    }
}
