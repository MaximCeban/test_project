package com.example.ceban.maxim.mvprx.ui.topics;

import android.content.Context;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.entities.Article;
import com.example.ceban.maxim.mvprx.entities.Source;
import com.example.ceban.maxim.mvprx.rest.ArticlesResponse;
import com.example.ceban.maxim.mvprx.rest.RestClient;
import com.example.ceban.maxim.mvprx.ui.view.adapter.ArticlesAdapter;

import java.util.HashMap;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 *
 */

public class Presenter implements ArticlesContractor.Presenter {
    private ArticlesContractor.View view;
    private Context context;
private CompositeSubscription compositeSubscription;
    public Presenter(ArticlesContractor.View view, Context context) {
        this.view = view;
        this.context = context;
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void refreshArticles(Source source) {
        view.displayProgress(true);
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("apiKey", context.getString(R.string.news_api_key));
        queryMap.put("source", source.getId());
      //  queryMap.put("sortBy", "latest");
     compositeSubscription.add(new RestClient().getNewsSources().getArticles(queryMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError));
    }

    private void handleError(Throwable throwable) {
        view.displayProgress(false);
    }

    private void handleSuccess(ArticlesResponse articlesResponse) {

        view.showData(articlesResponse.getArticles());
        view.displayProgress(false);
    }

    @Override
    public void onArticleClick(Article article) {

    }

    @Override
    public void onDestroy() {
        compositeSubscription.unsubscribe();
    }
}
