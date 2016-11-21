package com.example.ceban.maxim.mvprx.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.rest.NewsSourcesResponse;
import com.example.ceban.maxim.mvprx.rest.RestClient;
import com.example.ceban.maxim.mvprx.ui.view.adaptor.NewsSourceAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class NewsSourcesListFragment extends Fragment {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    private NewsSourceAdapter adapter;
    public NewsSourcesListFragment() {
    }

    public static NewsSourcesListFragment newInstance() {
       return  new NewsSourcesListFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_sources_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeRefreshLayout.setOnRefreshListener(this::refreshData);
        refreshData();
    }

    private void refreshData() {
        swipeRefreshLayout.setRefreshing(true);
        new RestClient().getNewsSources().getNewsSources()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError);
    }

    private void handleError(Throwable throwable) {
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    void handleSuccess(NewsSourcesResponse newsSourcesResponse) {
        swipeRefreshLayout.setRefreshing(false);
        if (adapter == null) {
            adapter = new NewsSourceAdapter(newsSourcesResponse.getSources(),getActivity());
            recyclerView.setAdapter(adapter);
        }else{
            adapter.updateData(newsSourcesResponse.getSources());
        }
        Toast.makeText(getActivity(),"data was updated", Toast.LENGTH_SHORT).show();
    }

}
