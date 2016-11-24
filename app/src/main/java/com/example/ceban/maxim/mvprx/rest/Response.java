package com.example.ceban.maxim.mvprx.rest;

import java.util.List;

public abstract class Response<T> {
    private String status;
    private List<T> sources;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<T> getSources() {
        return sources;
    }

    public void setSources(List<T> sources) {
        this.sources = sources;
    }
}
