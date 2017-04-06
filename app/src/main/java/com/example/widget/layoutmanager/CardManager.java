package com.example.widget.layoutmanager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by CJJ on 2017/3/7.
 */

public class CardManager extends RecyclerView.LayoutManager {

    private static final String TAG = "CardManager";

    int cardNumber;
    float scaleRatio = 0.037f;
    int translationStep = 40;


    public CardManager(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

        detachAndScrapAttachedViews(recycler);//每次回调onLayoutChildren都需要先回收view，然后layout children
        int itemCount = getItemCount();



        int anchor = itemCount>cardNumber?itemCount-cardNumber:0;

            //只layout 倒数cardNumber个item
            for (int pos = anchor; pos < itemCount; pos++) {
                View view = recycler.getViewForPosition(pos);
                //把最后cardNumber个view加入RecyclerView
                addView(view);
                //测量View
                measureChildWithMargins(view, 0, 0);
                //让Item 居中放置
                int verticalSpace = getHeight() - getDecoratedMeasuredHeight(view);
                int horizontalSpace = getWidth() - getDecoratedMeasuredWidth(view);
                //当然也可以使用layoutDecorated方法放置
                layoutDecoratedWithMargins(view, horizontalSpace / 2, verticalSpace / 2, getWidth() - horizontalSpace / 2, getHeight() - verticalSpace / 2);


                //pos 越大越靠前，缩放比例越小
                int zIndex = itemCount - pos - 1;
                int yTranslation = translationStep * zIndex;
                float xScale = scaleRatio * zIndex;
                Log.i(TAG, "onLayoutChildren: " + xScale + "---pos:" + pos);
                view.setScaleX(1 - xScale);
                view.setTranslationY(yTranslation);

        }
    }

}
