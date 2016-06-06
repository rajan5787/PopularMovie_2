package com.example.rajan.popularmovie_2.adapter;

/**
 * Created by rajan on 7/6/2016.
 */
public interface RecyclerItemListener<T> {
    int getCurrentPage();
    void onRecyclerItemSelected(int position, T model);
    void onScrolledToLast(int position, int nextPageIndex);
}
