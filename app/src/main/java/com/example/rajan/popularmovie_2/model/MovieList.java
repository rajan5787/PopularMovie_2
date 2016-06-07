package com.example.rajan.popularmovie_2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by rajan on 6/6/2016.
 */
public class MovieList {

    @SerializedName("results")
    private ArrayList<Movie> movieArrayList = new ArrayList<>();

    @SerializedName("page")
    private int currentPage;

    @SerializedName("total_pages")
    private int totalPages;

    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }

    public void setMovieArrayList(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
