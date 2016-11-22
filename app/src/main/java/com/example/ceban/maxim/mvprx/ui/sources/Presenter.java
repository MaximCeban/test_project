package com.example.ceban.maxim.mvprx.ui.sources;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ceban.maxim.mvprx.entities.Source;
import com.example.ceban.maxim.mvprx.rest.NewsSourcesResponse;
import com.example.ceban.maxim.mvprx.rest.RestClient;
import com.example.ceban.maxim.mvprx.ui.topics.ArticlesActivity;
import com.example.ceban.maxim.mvprx.ui.view.adapter.NewsSourceAdapter;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 *
 */

public class Presenter implements SourcesContractor.Presenter {

    private SourcesContractor.View view;
    private Context context;

    public Presenter(SourcesContractor.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void refreshData() {
        new RestClient().getNewsSources().getNewsSources()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError);
    }

    void handleError(Throwable throwable) {
        Log.d("ERROR",throwable.getMessage());
        view.displayProgressBar(false);
        Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    void handleSuccess(NewsSourcesResponse newsSourcesResponse) {
        view.displayData(newsSourcesResponse.getSources());
        view.displayProgressBar(false);
    }

    @Override
    public void showArticles(Source source) {
        Intent intent = new Intent(context, ArticlesActivity.class);
        intent.putExtra(ArticlesActivity.KEY_SOURCE, source);
        context.startActivity(intent);
    }
}
