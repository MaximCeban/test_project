package com.example.ceban.maxim.mvprx.ui.view;

import com.example.ceban.maxim.mvprx.entities.Source;

import java.util.List;

public interface NewsSourceView {
    void showData(List<Source> sourceList);
    void setRefresh(boolean isRefresh);
}
