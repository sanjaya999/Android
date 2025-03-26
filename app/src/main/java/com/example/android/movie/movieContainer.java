package com.example.android.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class movieContainer {

    @SerializedName("page")
    @Expose
     int page;

    @SerializedName("results")
    @Expose
    List<MovieResults> resultList;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieResults> getResultList() {
        return resultList;
    }

    public void setResultList(List<MovieResults> resultList) {
        this.resultList = resultList;
    }
}
