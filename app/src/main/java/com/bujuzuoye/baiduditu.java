package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/16.
 */

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class baiduditu extends Activity {
    MapView ditu;
    BaiduMap mBaiduMap;
    LocationManager lm;
    double jin;
    double wei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baiduditu);
        ditu= (MapView) findViewById(R.id.baidu);
        mBaiduMap = ditu.getMap();
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        huaxian();
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
                if (ActivityCompat.checkSelfPermission(baiduditu.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(baiduditu.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ditu.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ditu.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ditu.onResume();
    }

    public void updete(Location l){
        if(l!=null){
            LatLng point = new LatLng(wei,jin);
            CoordinateConverter converter  = new CoordinateConverter();
            converter.from(CoordinateConverter.CoordType.GPS);
            converter.coord(point);
            LatLng desLatLng = converter.convert();

            jin =l.getLongitude();
            wei=l.getLatitude();

            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.drawable.ditubiaozhu);
            OverlayOptions option = new MarkerOptions()
                    .position(desLatLng)
                    .icon(bitmap);
            mBaiduMap.addOverlay(option);
        }
        else {
            LatLng point = new LatLng(41.404, 123.886);
            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.drawable.ditubiaozhu);
            OverlayOptions option = new MarkerOptions()
                    .position(point)
                    .icon(bitmap);
            mBaiduMap.addOverlay(option);
        }
    }

    public void huaxian(){
        List<LatLng> points = new ArrayList<LatLng>();


        points.add(new LatLng(39.965,116.404));
        points.add(new LatLng(39.925,116.454));
        points.add(new LatLng(39.955,116.494));
        points.add(new LatLng(39.905,116.554));
        points.add(new LatLng(39.965,116.604));

//构建分段颜色索引数组
        List<Integer> colors = new ArrayList<>();
        colors.add(Integer.valueOf(Color.BLUE));

        OverlayOptions ooPolyline = new PolylineOptions().width(10)
                .colorsValues(colors).points(points);

        Polyline mPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);


    }
}
