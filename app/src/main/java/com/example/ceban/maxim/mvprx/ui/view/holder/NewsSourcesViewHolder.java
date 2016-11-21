package com.example.ceban.maxim.mvprx.ui.view.holder;

import android.view.View;
import android.widget.ImageView;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.entities.Source;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class NewsSourcesViewHolder extends AbstractViewHolder<Source> {
@BindView(R.id.image)
    ImageView image;
    public NewsSourcesViewHolder(View itemView) {
        super(itemView);
    }
    @Override
    public void bind(Source data) {
        Picasso.with(itemView.getContext()).load(data.getUrlsToLogos().getMedium()).into(image);
    }

}
