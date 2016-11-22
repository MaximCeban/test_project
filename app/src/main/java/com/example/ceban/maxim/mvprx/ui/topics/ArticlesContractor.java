package com.example.ceban.maxim.mvprx.ui.topics;

import com.example.ceban.maxim.mvprx.entities.Article;
import com.example.ceban.maxim.mvprx.entities.Source;

import java.util.List;

public class ArticlesContractor {
    public interface View {
        void displayProgress(boolean display);

        void showData(List<Article> articles);
    }

    public interface Presenter {
        void refreshArticles(Source source);

        void onArticleClick(Article article);
    }
}
