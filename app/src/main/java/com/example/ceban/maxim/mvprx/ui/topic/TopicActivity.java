package com.example.ceban.maxim.mvprx.ui.topic;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.ui.BaseActivity;

public class TopicActivity extends BaseActivity {
    public static final String ARTICLE_URL = "topicUrl";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, TopicFragment.newInstance(getIntent().getStringExtra(ARTICLE_URL))).commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_layout;
    }
}
