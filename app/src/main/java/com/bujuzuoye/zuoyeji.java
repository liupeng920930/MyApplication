package com.bujuzuoye;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.caipin.caipu;
import com.caipin.chakancaipin;
import com.caipin.shoujiguishudi;
import com.caipin.xiangxicaipin;
import com.com.zrgj.feiji.huafeiji;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.bianbaixin;
import com.tupianshang.tupianjubuxianshi;
import com.tupianxunhua.huatu;
import com.w.lianxi;
import com.wucaimihong.mihong;
import com.zrgj.tanqiu.Tanqiu;

import java.io.Serializable;

/**
 * Created by Administrator on 16-5-25.
 */
public class zuoyeji extends Activity {
    ListView lv;
    String[] zuoye={"短信验证","单选多选按钮","图片十字布局","进度条","qq布局","百度成语搜索","多选提示框",
            "布局电话本","下拉菜单","自动搜索","百度查菜谱","查自己服务器的菜品","手机归属地查询","飞机大战",
            "画心形","图片改变透明度，局部显示","图片循环显示","弥红灯","弹球游戏","图片联系手机联系人","手机分辨率","选项卡"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zuoyeji);
        lv= (ListView) findViewById(R.id.zuoye);
        ArrayAdapter ap=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,zuoye);
        lv.setAdapter(ap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i=new Intent(zuoyeji.this,duanxinyanzheng.class);
                    startActivity(i);
                }
                if(position==1){
                    Intent i=new Intent(zuoyeji.this,duoxunaanniu.class);
                    startActivity(i);
                }
                if(position==2){
                    Intent i=new Intent(zuoyeji.this,huatouxiang.class);
                    startActivity(i);
                }
                if(position==3){
                    Intent i=new Intent(zuoyeji.this,jindutiao.class);
                    startActivity(i);
                }
                if(position==4){
                    Intent i=new Intent(zuoyeji.this,qq.class);
                    startActivity(i);
                }
                if(position==5){
                    Intent i=new Intent(zuoyeji.this,sousuodanci.class);
                    startActivity(i);
                }
                if(position==6){
                    Intent i=new Intent(zuoyeji.this,tishikuang.class);
                    startActivity(i);
                }
                if(position==7){
                    Intent i=new Intent(zuoyeji.this,tongxunlu.class);
                    startActivity(i);
                }
                if(position==8){
                    Intent i=new Intent(zuoyeji.this,xialacaidan.class);
                    startActivity(i);
                }
                if(position==9){
                    Intent i=new Intent(zuoyeji.this,zidongsousuo.class);
                    startActivity(i);
                }
                if(position==10){
                    Intent i=new Intent(zuoyeji.this,caipu.class);
                    startActivity(i);
                }
                if(position==11){
                    Intent i=new Intent(zuoyeji.this,chakancaipin.class);
                    startActivity(i);
                }
                if(position==12){
                    Intent i=new Intent(zuoyeji.this,shoujiguishudi.class);
                    startActivity(i);
                }
                if(position==13){
                    Intent i=new Intent(zuoyeji.this,huafeiji.class);
                    startActivity(i);

                }
                if(position==14){
                    Intent i=new Intent(zuoyeji.this,bianbaixin.class);
                    startActivity(i);
                }
                if(position==15){
                    Intent i=new Intent(zuoyeji.this,tupianjubuxianshi.class);
                    startActivity(i);
                }
                if(position==16){
                    Intent i=new Intent(zuoyeji.this,huatu.class);
                    startActivity(i);
                }
                if(position==17){
                    Intent i=new Intent(zuoyeji.this,mihong.class);
                    startActivity(i);
                }
                if(position==18){
                    Intent i=new Intent(zuoyeji.this,Tanqiu.class);
                    startActivity(i);
                }
                if(position==19){
                    Intent i=new Intent(zuoyeji.this,lianxi.class);
                    startActivity(i);
                }
                if(position==20){
                    Intent i=new Intent(zuoyeji.this,shoujifenbianlv.class);
                    startActivity(i);
                }
                if(position==21){
                    Intent i=new Intent(zuoyeji.this,xuanxiangka.class);
                    startActivity(i);
                }
            }
        });

    }
}
