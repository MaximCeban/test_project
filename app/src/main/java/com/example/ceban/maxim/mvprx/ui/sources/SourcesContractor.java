package com.example.ceban.maxim.mvprx.ui.sources;

import com.example.ceban.maxim.mvprx.entities.Source;
import com.example.ceban.maxim.mvprx.ui.view.adapter.NewsSourceAdapter;

import java.util.List;

public class SourcesContractor {
    public interface Presenter {
        void refreshData();

        void showArticles(Source source);
    }

    public interface View extends NewsSourceAdapter.OnItemClickListener{
        void displayProgressBar(boolean refresh);
        void displayData(List<Source> sources);
    }
}
