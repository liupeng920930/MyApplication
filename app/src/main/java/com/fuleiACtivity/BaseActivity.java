package com.fuleiACtivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bujuzuoye.zuoyeji;
import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class BaseActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.baseactivity);
        Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.mytuo);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.normal_btn:
                        AlertDialog.Builder b=new AlertDialog.Builder(BaseActivity.this)
                                .setTitle("作者详情")
                                .setMessage("作者：刘鹏");
                        b.create().show();
                        break;
                    case R.id.fanhui :
                        Intent i=new Intent(BaseActivity.this,zuoyeji.class);
                        startActivity(i);
                        break;
                }
                return false;
            }
        });


    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inf = new MenuInflater(this);
        inf.inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }


}
