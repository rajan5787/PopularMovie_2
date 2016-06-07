package com.example.rajan.popularmovie_2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by rajan on 7/6/16.
 */
public class TrailerList {

    private String id;

    @SerializedName("results")
    private ArrayList<Trailer> trailerList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Trailer> getTrailerList() {
        return trailerList;
    }

    public void setTrailerList(ArrayList<Trailer> trailerList) {
        this.trailerList = trailerList;
    }

}
