package com.example.rajan.popularmovie_2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.rajan.popularmovie_2.R;
import com.example.rajan.popularmovie_2.data.AppConstants;
import com.example.rajan.popularmovie_2.httphelper.VolleyHelper;
import com.example.rajan.popularmovie_2.model.Review;

import java.util.ArrayList;

/**
 * Created by rajan on 7/6/16.
 */
public class ReviewsRecyclerAdapter extends RecyclerView.Adapter<ReviewsRecyclerAdapter.ViewHolder> {

private static final String TAG = ReviewsRecyclerAdapter.class.getSimpleName();
private Context mContext;
private ImageLoader imageLoader;
private LayoutInflater layoutInflater;
private ArrayList<Review> reviewArrayList = new ArrayList<>();
private int currentPageIndex = 1;
private boolean isLastPage = false;


private RecyclerItemListener<Review> onItemClickedListener;

public RecyclerItemListener<Review> getOnItemClickedListener() {
        return onItemClickedListener;
        }

public void setOnItemClickedListener(RecyclerItemListener<Review> onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
        }

public ReviewsRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader = VolleyHelper.getInstance(mContext).getImageLoader();
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View convertView = layoutInflater.inflate(R.layout.list_item_review, null);

        ViewHolder viewHolder = new ViewHolder(convertView);

        return viewHolder;
        }



    @Override
public void onBindViewHolder(ViewHolder viewHolder, final int position) {

final Review review = reviewArrayList.get(position);
        viewHolder.tvReviewUserName.setText(review.getAuthor());
        viewHolder.tvReviewContent.setText(review.getContent());


        viewHolder.root.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        if (onItemClickedListener != null) {
        onItemClickedListener.onRecyclerItemSelected(position, review);
        }
        }
        });
        if (onItemClickedListener != null && !isLastPage) {
        int nextPageIndex = onItemClickedListener.getCurrentPage() + 1;
        Log.v(TAG, "Page: " + nextPageIndex + " Current page: " + currentPageIndex + " Item Posi: "
        + position + " Size: " + reviewArrayList.size());
        if (currentPageIndex < AppConstants.ALLOWED_MAX_PAGES && currentPageIndex != nextPageIndex
        && reviewArrayList.size() > 0 && reviewArrayList.size() == (position + 1)) {
        Log.v(TAG, "Page scrolled to end. Posi: " + position);
        onItemClickedListener.onScrolledToLast(position, nextPageIndex);
        }
        }
        }

@Override
public int getItemCount() {
        return reviewArrayList.size();
        }

public static class ViewHolder extends RecyclerView.ViewHolder {

    public View root;
    public TextView tvReviewUserName;
    public TextView tvReviewContent;

    public ViewHolder(View parent) {
        super(parent);
        root = parent;
        tvReviewUserName = (TextView) parent.findViewById(R.id.tvReviewUserName);
        tvReviewContent = (TextView) parent.findViewById(R.id.tvReviewDesc);
    }
}


    public void setDataList(int pageIndex,boolean isLastPage, ArrayList<Review> list) {
        reviewArrayList = list;
        currentPageIndex = pageIndex;
        this.isLastPage = isLastPage;
        notifyDataSetChanged();
    }
}
