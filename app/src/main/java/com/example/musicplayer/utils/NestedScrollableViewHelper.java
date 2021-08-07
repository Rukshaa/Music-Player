package com.example.musicplayer.utils;

import android.view.View;

import androidx.core.widget.NestedScrollView;

import com.sothree.slidinguppanel.ScrollableViewHelper;

public class NestedScrollableViewHelper extends ScrollableViewHelper {
    private View scrollableView;
    private boolean isSlidingUp;

    public int getScrollableViewScrollPosition(View scrollableView, boolean isSlidingUp) {
        this.scrollableView = scrollableView;
        this.isSlidingUp = isSlidingUp;
        View mScrollableView = null;
        if (mScrollableView instanceof NestedScrollView) {
            if(isSlidingUp){
                return mScrollableView.getScrollY();
            } else {
                NestedScrollView nsv = ((NestedScrollView) mScrollableView);
                View child = nsv.getChildAt(0);
                return (child.getBottom() - (nsv.getHeight() + nsv.getScrollY()));
            }
        } else {
            return 0;
        }
    }
}