package com.bujuzuoye;/**
 * Created by Administrator on 2016/5/30.
 */

import android.os.Bundle;

import com.fuleiACtivity.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cailei {
    public static class cai
    {
        public Integer id;
        public String title;
        public String desc;

        public cai(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    public static List<cai> ITEMS = new ArrayList<cai>();

    public static Map<Integer,cai> ITEM_MAP = new HashMap<Integer,cai>();

    static
    {
        addItem(new cai(1,"鱼香茄子","茄子，没有鱼"));
        addItem(new cai(2,"老婆饼","饼，没有老婆"));
        addItem(new cai(3,"老虎菜","凉菜，没有老虎"));
    }

    private static void addItem(cai c)
    {
        ITEMS.add(c);
        ITEM_MAP.put(c.id,c);
    }
}
