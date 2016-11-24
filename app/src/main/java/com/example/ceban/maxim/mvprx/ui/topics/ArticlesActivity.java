package com.example.ceban.maxim.mvprx.ui.topics;

import android.os.Bundle;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.ui.BaseActivity;

public class ArticlesActivity extends BaseActivity {
    public static final String KEY_SOURCE = "source";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, ArticlesFragment.newInstance(getIntent().getParcelableExtra(KEY_SOURCE))).commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_layout;
    }
}
