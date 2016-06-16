package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/16.
 */

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class gpsweizhi extends BaseActivity {
    TextView j, w, g;
    LocationManager lm;

    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.gpsweizhi);
        j = (TextView) findViewById(R.id.jingdu);
        w = (TextView) findViewById(R.id.weidu);
        g = (TextView) findViewById(R.id.haiba);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        updete(l);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 5, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updete(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(gpsweizhi.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(gpsweizhi.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
        if(l!=null){
            j.setText(l.getLongitude()+"");
            w.setText(l.getLatitude()+"");
            g.setText(l.getAltitude()+"");
        }
        else {
            j.setText("请等待...");
            w.setText("请等待...");
            g.setText("请等待...");
        }
    }
}
