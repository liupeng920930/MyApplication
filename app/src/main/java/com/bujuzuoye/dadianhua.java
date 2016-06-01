package com.bujuzuoye;/**
 * Created by Administrator on 2016/5/31.
 */

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.fuleiACtivity.BaseActivity;

public class dadianhua extends BaseActivity {
    TextView pname;
    TextView pphone;
    EditText duanxin;

    @Override
    public void initmycreate(Bundle savedInstanceState) {
        setContentView(R.layout.dadianhua);
        pname = (TextView) findViewById(R.id.name);
        pphone = (TextView) findViewById(R.id.phone);
        duanxin = (EditText) findViewById(R.id.duanxin);
    }

    public void lianxiren(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.setType("vnd.android.cursor.item/phone");
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            CursorLoader cl = new CursorLoader(this, uri, null, null, null, null);
            Cursor c = cl.loadInBackground();
            if (c.moveToFirst()) {
                String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String phone = "";

                Cursor phoneC = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                while (phoneC.moveToNext()) {
                    phone = phone + " " + phoneC.getString(phoneC.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }

                phoneC.close();

                pname.setText(name);
                pphone.setText(phone);
            }
            c.close();
        }
    }
    public  void faxiaoxi(View view){
        Intent ii=new Intent();
        ii.setAction(Intent.ACTION_VIEW);
        ii.setType("vnd.android-dir/mms-sms");
        startActivity(ii);

    }
    public void dadianhua(View view){
        Intent ii=new Intent();
        ii.setAction(Intent.ACTION_DIAL);
        String data="tel:"+pphone.getText();
        ii.setData(Uri.parse(data));
        startActivity(ii);

    }
    public void shangwang(View view){
        Intent ii=new Intent();
        ii.setAction(Intent.ACTION_VIEW);
        ii.setData(Uri.parse("http://www.baidu.com/"));
        ii=Intent.createChooser(ii,null);
        startActivity(ii);

    }
    public void fanhui(View view){
        Intent ii=new Intent();
        ii.setAction(Intent.ACTION_MAIN);
        ii.addCategory(Intent.CATEGORY_HOME);
        startActivity(ii);

    }

}
