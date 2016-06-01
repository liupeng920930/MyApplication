package com.bujuzuoye;/**
 * Created by Administrator on 2016/5/31.
 */

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class chengshileibiao2 extends Activity {
    String[] s={"辽宁","吉林"};
    String[][] c={{"阜新","沈阳","大连","锦州"},{"吉林市","四平市","长春市"}};
    ExpandableListView city;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chengshiliebiao);
        city= (ExpandableListView) findViewById(R.id.city);
        ExpandableListAdapter a=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return s.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return c[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return s[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return c[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                TextView t=new TextView(chengshileibiao2.this);
                t.setText(s[groupPosition]);
                return t;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView t=new TextView(chengshileibiao2.this);
                t.setText(c[groupPosition][childPosition]);
                return t;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }
        };
        city.setAdapter(a);
        city.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent da=new Intent();
                da.putExtra("cccc",c[groupPosition][childPosition]);
                setResult(111,da);
                finish();
                return true;
            }
        });
    }
}
