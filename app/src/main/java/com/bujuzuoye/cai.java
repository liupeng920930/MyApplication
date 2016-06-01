package com.bujuzuoye;/**
 * Created by Administrator on 2016/5/30.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class cai extends Activity implements caiListFragment.Callback {
    boolean twoPan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cai1);

        if(findViewById(R.id.book_detail_container)!=null)
        {
            twoPan = true;
        }
    }


    @Override
    public void onItemSelected(Integer id) {
        if(twoPan)
        {
            Bundle b = new Bundle();
            b.putInt("item_id",id);

            caiDetailFragment f = new caiDetailFragment();
            f.setArguments(b);

            getFragmentManager().beginTransaction().replace(R.id.book_detail_container,f).commit();
        }else{
            Intent i = new Intent(this,caiActivitycaiDetail.class);
            i.putExtra("item_id",id);
            startActivity(i);
        }
    }
}
