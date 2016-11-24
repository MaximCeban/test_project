package com.example.ceban.maxim.mvprx.ui.sources;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.entities.Source;
import com.example.ceban.maxim.mvprx.ui.BaseFragment;
import com.example.ceban.maxim.mvprx.ui.view.adapter.NewsSourceAdapter;

import java.util.List;

import butterknife.BindView;


public class NewsSourcesListFragment extends BaseFragment implements SourcesContractor.View{
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    private NewsSourceAdapter adapter;
    private SourcesContractor.Presenter presenter;
    public NewsSourcesListFragment() {
    }

    public static NewsSourcesListFragment newInstance() {
       return  new NewsSourcesListFragment();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycler_view_layout;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new Presenter(this, getActivity());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeRefreshLayout.setOnRefreshListener(presenter::refreshData);
        presenter.refreshData();
    }


    @Override
    public void displayProgressBar(boolean display) {
        swipeRefreshLayout.setRefreshing(display);
    }

    @Override
    public void displayData(List<Source> sources) {
        if (adapter == null) {
            adapter = new NewsSourceAdapter(sources,getActivity(), this);
            recyclerView.setAdapter(adapter);
        }else{
            adapter.updateData(sources);
        }
        Toast.makeText(getActivity(),"data was updated", Toast.LENGTH_SHORT).show();
        }


    @Override
    public void itemClicked(Source source) {
presenter.showArticles(source);
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
