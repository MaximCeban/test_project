package com.example.ceban.maxim.mvprx.rest;

import com.example.ceban.maxim.mvprx.entities.Article;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class ArticlesResponse extends Response<Article> {

    @SerializedName("source")
    @Expose
    public String source;
    @SerializedName("sortBy")
    @Expose
    public String sortBy;
    @SerializedName("articles")
    @Expose
    public List<Article> articles = new ArrayList<Article>();

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
