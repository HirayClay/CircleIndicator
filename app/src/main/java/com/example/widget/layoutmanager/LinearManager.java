package com.example.widget.layoutmanager;

import android.support.v7.widget.RecyclerView;

/**
 * Created by CJJ on 2017/3/8.
 */

public class LinearManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
    }

    @Override
    public boolean canScrollVertically() {
        return super.canScrollVertically();
    }
}
