package com.example.ceban.maxim.mvprx.ui.sources;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsSourcesActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, NewsSourcesListFragment.newInstance())
                .commit();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_layout;
    }
}
