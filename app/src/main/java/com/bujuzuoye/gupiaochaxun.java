package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/12.
 */

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class gupiaochaxun extends BaseActivity {
    EditText bianhao,gupian;
    ListView guo;

    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.gupiaola);
        bianhao= (EditText) findViewById(R.id.gupianid);
        guo= (ListView) findViewById(R.id.gupiaoname);
        gupian=(EditText) findViewById(R.id.gupian);
    }

    public void chaxungupiao(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gupiaojiekou gu=  retrofit.create(gupiaojiekou.class);
        Call<gupiaobean> call = gu.getgupian("969d95ec955f519fda3a517fde8b6b26",bianhao.getText().toString(),"0");
        call.enqueue(new Callback<gupiaobean>() {
            @Override
            public void onResponse(Call<gupiaobean> call, Response<gupiaobean> response) {
                gupiaobean gg=response.body();
               String[] gupiao={gg.getRetData().getStockinfo().getName(),gg.getRetData().getStockinfo().getCode(),gg.getRetData().getStockinfo().getDate(),gg.getRetData().getStockinfo().getCurrentPrice()+"",gg.getRetData().getStockinfo().getClosingPrice()+"",
                       gg.getRetData().getStockinfo().getHPrice()+"",gg.getRetData().getStockinfo().getLPrice()+""};
                ArrayAdapter a=new ArrayAdapter(gupiaochaxun.this,android.R.layout.simple_expandable_list_item_1,gupiao);
                guo.setAdapter(a);
                gupian.setText(gg.getRetData().getStockinfo().getName());
            }

            @Override
            public void onFailure(Call<gupiaobean> call, Throwable t) {

            }
        });

    }
}
