package com.example.ceban.maxim.mvprx.ui.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.entities.Source;
import com.example.ceban.maxim.mvprx.ui.view.holder.NewsSourcesViewHolder;

import java.util.List;

public class NewsSourceAdapter extends RecyclerView.Adapter<NewsSourcesViewHolder> {
    private List<Source> sourceList;
    private Context context;
    private OnItemClickListener listener;

    public NewsSourceAdapter(List<Source> sourceList, Context context, OnItemClickListener listener) {
        this.sourceList = sourceList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public NewsSourcesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsSourcesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news_source_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsSourcesViewHolder holder, int position) {
        Source data = sourceList.get(position);
        holder.bind(data);
        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.itemClicked(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sourceList.size();
    }

    public void updateData(List<Source> sources) {
        sourceList.clear();
        sourceList.addAll(sources);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void itemClicked(Source source);
    }
}
