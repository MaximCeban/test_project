package com.example.ceban.maxim.mvprx.ui.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
public abstract class AbstractViewHolder<T> extends RecyclerView.ViewHolder  {

    public AbstractViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
   abstract void bind(T data);
}
