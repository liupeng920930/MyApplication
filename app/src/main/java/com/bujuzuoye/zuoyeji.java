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
import com.com.zrgj.feiji.xitongshizhe;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.bianbaixin;
import com.example.administrator.myapplication.huaban;
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
    String[] zuoye={"1.短信验证","2.单选多选按钮","3.图片十字布局","4.进度条","5.qq布局","6.百度成语搜索","7.多选提示框",
            "8.布局电话本","9.下拉菜单","10.自动搜索","11.百度查菜谱","12.查自己服务器的菜品","13.手机归属地查询","14.飞机大战",
            "15.画心形","16.图片改变透明度，局部显示","17.图片循环显示","18.弥红灯","19.弹球游戏","20.图片联系手机联系人","21.手机分辨率",
            "22.选项卡","23.国际化图片","24.横竖屏布局","25.背景音乐设置","26.手机平板适配","27.带返回的intent跳转","28.按钮点击发短信，打电话，上网",
    "29.手势画板","30.动画","31.下载","32.菜品信息","33.文件浏览器","34.百度语音合成","35.数据共享","36.来电播报","37.群发短信","38.设置闹钟","39.视频",
    "40.开始摇摆","41.放声音","42.放自己录得视频","42.查询股票","43.上传文件"};
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
                if(position==22){
                    Intent i=new Intent(zuoyeji.this,guojihua.class);
                    startActivity(i);
                }
                if(position==23){
                    Intent i=new Intent(zuoyeji.this,hengshuping.class);
                    startActivity(i);
                }
                if(position==24){
                    Intent i=new Intent(zuoyeji.this,xitongshizhe.class);
                    startActivity(i);
                }
                if(position==25){
                    Intent i=new Intent(zuoyeji.this,cai.class);
                    startActivity(i);
                }
                if(position==26){
                    Intent i=new Intent(zuoyeji.this,chengshileibiao.class);
                    startActivity(i);
                }
                if(position==27){
                    Intent i=new Intent(zuoyeji.this,dadianhua.class);
                    startActivity(i);
                }
                if(position==28){
                    Intent i=new Intent(zuoyeji.this,huaban.class);
                    startActivity(i);
                }
                if(position==29){
                    Intent i=new Intent(zuoyeji.this,donghua.class);
                    startActivity(i);
                }
                if(position==30){
                    Intent i=new Intent(zuoyeji.this,wenjianxiazai.class);
                    startActivity(i);
                }
                if(position==31){
                    Intent i=new Intent(zuoyeji.this,xueshengshuju.class);
                    startActivity(i);
                }
                if(position==32){
                    Intent i=new Intent(zuoyeji.this,wenjianliulanqi.class);
                    startActivity(i);
                }
                if(position==33){
                    Intent i=new Intent(zuoyeji.this,yuyinlangdu.class);
                    startActivity(i);
                }
                if(position==34){
                    Intent i=new Intent(zuoyeji.this,shujugongsiang_content.class);
                    startActivity(i);
                }
                if(position==35){
                    Intent i=new Intent(zuoyeji.this,jiantingdianhua.class);
                    startActivity(i);
                }
                if(position==36){
                    Intent i=new Intent(zuoyeji.this,duanxinqunfa.class);
                    startActivity(i);
                }
                if(position==37){
                    Intent i=new Intent(zuoyeji.this,naozhong.class);
                    startActivity(i);
                }
                if(position==38){
                    Intent i=new Intent(zuoyeji.this,shipin.class);
                    startActivity(i);
                }
                if(position==39){
                    Intent i=new Intent(zuoyeji.this,zhendong.class);
                    startActivity(i);
                }
                if(position==40){
                    Intent i=new Intent(zuoyeji.this,fangshengyin.class);
                    startActivity(i);
                }
                if(position==41){
                    Intent i=new Intent(zuoyeji.this,bofangshipin.class);
                    startActivity(i);
                }
                if(position==42){
                    Intent i=new Intent(zuoyeji.this,gupiaochaxun.class);
                    startActivity(i);
                }
                if(position==43){
                    Intent i=new Intent(zuoyeji.this,studentshangchuang.class);
                    startActivity(i);
                }
            }
        });

    }
}
