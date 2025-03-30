package com.example.android.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class movieContainer {

    @SerializedName("page")
    @Expose
     int page;

    @SerializedName("results")
    @Expose
    ArrayList<MovieResults> resultList;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<MovieResults> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<MovieResults> resultList) {
        this.resultList = resultList;
    }
}
