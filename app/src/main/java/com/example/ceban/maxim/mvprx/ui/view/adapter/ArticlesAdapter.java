package com.example.ceban.maxim.mvprx.ui.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.entities.Article;
import com.example.ceban.maxim.mvprx.entities.Source;
import com.example.ceban.maxim.mvprx.ui.view.holder.ArticlesHolder;

import java.util.List;

/**
 *
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesHolder> {
    Context context;
    List<Article> data;

    public ArticlesAdapter(List<Article> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ArticlesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticlesHolder(LayoutInflater.from(context).inflate(R.layout.item_articles_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(ArticlesHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateData(List<Article> articles) {
        data.clear();
        data.addAll(articles);
        notifyDataSetChanged();
    }
}
