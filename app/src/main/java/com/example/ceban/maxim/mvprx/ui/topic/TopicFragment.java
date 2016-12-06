package com.example.ceban.maxim.mvprx.ui.topic;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.ui.BaseFragment;

import butterknife.BindView;

public class TopicFragment extends BaseFragment {

    public static final String ARTICLE_URL = "articleUrl";
    @BindView(R.id.web_view)
    WebView webView;
    private String articleUrl;

    public TopicFragment() {
        // Required empty public constructor
    }

    public static TopicFragment newInstance(String stringExtra) {

        Bundle args = new Bundle();
        args.putString(ARTICLE_URL, stringExtra);
        TopicFragment fragment = new TopicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articleUrl = getArguments().getString(ARTICLE_URL);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView.loadUrl(articleUrl);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_topic_layout;
    }

}
