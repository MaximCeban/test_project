package com.example.ceban.maxim.mvprx.ui.topics;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.entities.Article;
import com.example.ceban.maxim.mvprx.entities.Source;
import com.example.ceban.maxim.mvprx.ui.BaseFragment;
import com.example.ceban.maxim.mvprx.ui.view.adapter.ArticlesAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends BaseFragment implements ArticlesContractor.View {
    public static final String SOURCE = "source";
    private Source source;
    private ArticlesContractor.Presenter presenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    ArticlesAdapter adapter;

    public ArticlesFragment() {
        // Required empty public constructor
    }

    public static ArticlesFragment newInstance(Source source) {
        Bundle args = new Bundle(1);
        args.putParcelable(SOURCE, source);

        ArticlesFragment fragment = new ArticlesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        source = getArguments().getParcelable(SOURCE);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new Presenter(this, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.refreshArticles(source));
        presenter.refreshArticles(source);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycler_view_layout;
    }

    @Override
    public void displayProgress(boolean display) {
        swipeRefreshLayout.setRefreshing(display);
    }

    @Override
    public void showData(List<Article> articles) {
        if (adapter == null) {
            adapter = new ArticlesAdapter(articles,getActivity());
            recyclerView.setAdapter(adapter);
        }else{
            adapter.updateData(articles);
        }

    }
}
