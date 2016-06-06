package com.example.rajan.popularmovie_2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.rajan.popularmovie_2.fragment.MovieListFragment;
import com.example.rajan.popularmovie_2.model.Movie;

public class MainActivity extends AppCompatActivity implements MovieListFragment.MovieListCallback {


    private Context mContext;
    private RelativeLayout detailContainer;
    private MovieListFragment movieListFragment;
    private boolean isMultiPane = false;
    private static final String SAVED_INSTANCE_IS_MULTIPANE = "saved_instance_is_multipane";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews(savedInstanceState);

    }

    @Override
    public void onItemClickListener(int position, Movie movie) {


    }

    private void initViews(Bundle savedInstanceState) {

        movieListFragment = (MovieListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_movie_list);




        if (movieListFragment != null) {
            movieListFragment.setMultiPane(isMultiPane);
        }

    }

}
