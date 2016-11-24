package com.example.ceban.maxim.mvprx.ui.view.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ceban.maxim.mvprx.R;
import com.example.ceban.maxim.mvprx.entities.Article;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class ArticlesHolder extends AbstractViewHolder<Article> {
    @BindView(R.id.iv_article)
    ImageView imageView;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_text)
    TextView tvContent;
    public ArticlesHolder(View itemView) {
        super(itemView);
    }

    @Override
  public  void bind(Article data) {
        Picasso.with(itemView.getContext()).load(data.getUrlToImage()).into(imageView);
        tvAuthor.setText(data.getAuthor());
        tvTitle.setText(data.getTitle());
        tvContent.setText(data.getDescription());
    }
}
