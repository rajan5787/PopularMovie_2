package com.example.rajan.popularmovie_2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.rajan.popularmovie_2.R;

/**
 * Created by rajan on 7/6/16.
 */
public class viewholder extends RecyclerView.ViewHolder{

    public View root;
    public NetworkImageView imgVMoviePoster;
    public TextView tvMovieName;

    public viewholder(View parent) {
        super(parent);
        root = parent;
        imgVMoviePoster = (NetworkImageView) parent.findViewById(R.id.imgVMoviePoster);
        tvMovieName = (TextView) parent.findViewById(R.id.tvMovieTitle);
    }
}
