package com.example.rajan.popularmovie_2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.example.rajan.popularmovie_2.R;
import com.example.rajan.popularmovie_2.data.AppConstants;
import com.example.rajan.popularmovie_2.data.AppURLs;
import com.example.rajan.popularmovie_2.httphelper.VolleyHelper;
import com.example.rajan.popularmovie_2.model.Movie;
import com.example.rajan.popularmovie_2.utilities.Utils;

import java.util.ArrayList;

/**
 * Created by rajan on 7/6/16.
 */
public class MovieRecyclerviewAdapter extends RecyclerView.Adapter<viewholder> {


    private static final String TAG = MovieRecyclerviewAdapter.class.getSimpleName();
    private Context mContext;
    private ImageLoader imageLoader;
    private LayoutInflater layoutInflater;
    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private int currentPageIndex = 1;
    private RecyclerItemListener<Movie> movieRecyclerItemListener;


    public MovieRecyclerviewAdapter(Context mContext) {
        this.mContext = mContext;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader = VolleyHelper.getInstance(mContext).getImageLoader();
    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = layoutInflater.inflate(R.layout.grid_cell, null);



        return new viewholder(convertView);   }

    @Override
    public void onBindViewHolder(viewholder holder, final int position) {

        final Movie movie = movieArrayList.get(position);
        holder.tvMovieName.setText(movie.getTitle());

        if (!Utils.isStringEmpty(movie.getPosterPath())) {
            String url = AppURLs.MOVIE_DB_IMAGE_BASE_URL + movie.getPosterPath();
            holder.imgVMoviePoster.setImageUrl(url, imageLoader);
        } else {
            holder.imgVMoviePoster.setImageResource(R.drawable.no_preview_available);
        }

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (movieRecyclerItemListener != null) {
                    movieRecyclerItemListener.onRecyclerItemSelected(position, movie);
                }
            }
        });

        if (movieRecyclerItemListener != null) {
            int nextPageIndex = movieRecyclerItemListener.getCurrentPage() + 1;
            Log.v(TAG, "Page: " + nextPageIndex + " Current page: " + currentPageIndex + " Item Posi: " + position + " Size: " + movieArrayList.size());
            if (currentPageIndex < AppConstants.ALLOWED_MAX_PAGES && currentPageIndex != nextPageIndex
                    && movieArrayList.size() > 0 && movieArrayList.size() == (position + 1)) {
                Log.v(TAG, "Page scrolled to end. Posi: " + position);
                movieRecyclerItemListener.onScrolledToLast(position, nextPageIndex);
            }
        }
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public void setMovieRecyclerItemListener(RecyclerItemListener<Movie> movieRecyclerItemListener) {
        this.movieRecyclerItemListener = movieRecyclerItemListener;
    }

    public void setDataList(int pageIndex, ArrayList<Movie> list) {
        movieArrayList = list;
        currentPageIndex = pageIndex;
        notifyDataSetChanged();
    }
}

