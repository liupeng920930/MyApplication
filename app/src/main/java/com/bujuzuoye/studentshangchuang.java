package com.bujuzuoye;/**
 * Created by Administrator on 2016/6/12.
 */

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

import java.io.File;
import java.io.FileNotFoundException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class studentshangchuang extends BaseActivity {
    EditText stuid,stuname,stushengri;
    TextView stupic;
    RequestBody rb;
    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.studentla);
        stuid= (EditText) findViewById(R.id.stuid);
        stuname= (EditText) findViewById(R.id.stuname);
        stushengri= (EditText) findViewById(R.id.stushengri);
        stupic= (TextView) findViewById(R.id.stupic);
        stupic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i, 11);
            }
        });
    }

    @Override

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        Uri u=data.getData();
        ContentResolver cr = this.getContentResolver();
        Cursor cc=cr.query(u, null,null,null,null);
        cc.moveToFirst();
        int i=cc.getColumnIndex(MediaStore.Images.Media.DATA);
        String path=cc.getString(i);

        File file=new File(path);
        stupic.setText(file.getName());
        rb= RequestBody.create(MediaType.parse("multipart/form-data"),file);
    }



    public void tijiao(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.188:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        studentin s=retrofit.create(studentin.class);

       Call<Message> stu=s.uploadStudentInfo(stuid.getText().toString(),stuname.getText().toString(),stushengri.getText().toString(),stupic.getText().toString(),rb);
        Toast.makeText(studentshangchuang.this, "1", Toast.LENGTH_LONG).show();
        stu.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Toast.makeText(studentshangchuang.this, "成功", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(studentshangchuang.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
   }
}
