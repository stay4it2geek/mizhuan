package com.mizhuan.app.mizhuan.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mizhuan.app.mizhuan.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Context context;
    private RelativeLayout rl_category;

    private RelativeLayout rl_link_tool;

    private RelativeLayout rl_featured;
    private LinearLayout ll_user_teach;
    private TextView tv_search;
    private EditText searchEdit;

    @Override
    protected int layoutInit() {
        return R.layout.activity_main;
    }

    @Override
    protected void binEvent() {
        rl_link_tool = (RelativeLayout) findViewById(R.id.rl_link_tool);
        rl_category = (RelativeLayout) findViewById(R.id.rl_category);
        rl_featured = (RelativeLayout) findViewById(R.id.rl_featured);
        ll_user_teach = (LinearLayout) findViewById(R.id.ll_user_teach);
        tv_search = (TextView) findViewById(R.id.tv_search);
        searchEdit = (EditText) findViewById(R.id.searchEdit);

        rl_category.setOnClickListener(this);
        rl_link_tool.setOnClickListener(this);
        rl_featured.setOnClickListener(this);
        ll_user_teach.setOnClickListener(this);
        tv_search.setOnClickListener(this);
    }

    @Override
    protected void fillData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_link_tool:
                Intent intentLinkTool = new Intent(MainActivity.this, GoLinkActivity.class);
                startActivity(intentLinkTool);
                break;
            case R.id.rl_category:
                Intent intentCategory = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intentCategory);
                break;
            case R.id.rl_featured:
                Intent intentFeatured = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(intentFeatured);
                break;
            case R.id.ll_user_teach:
                Intent intentUserTeach = new Intent(MainActivity.this, NewCourseActivity.class);
                startActivity(intentUserTeach);
                break;
            case R.id.tv_search:
                String search = searchEdit.getText().toString().trim();
                if (search==null||search.equals("")){

                    return;
                }
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("search",search);
                startActivity(intent);
                break;
        }
    }
}
