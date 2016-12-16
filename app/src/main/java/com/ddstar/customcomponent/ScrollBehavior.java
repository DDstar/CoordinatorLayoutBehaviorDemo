package com.ddstar.customcomponent;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by DDstar on 2016/12/15.
 */

public class ScrollBehavior extends CoordinatorLayout.Behavior<View> {

    int screenH = 0;
    int offsetTotal = 0;

    public ScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WindowManager winM = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        winM.getDefaultDisplay().getMetrics(displayMetrics);
        offsetTotal = screenH = displayMetrics.heightPixels;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        Log.e("onStartNestedScroll", "onStartNestedScroll");
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;//竖直滚动就关心
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        offSetDown(child, dyConsumed);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        Log.e("onNestedFling", "onNestedFling");
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    private void offSetDown(View child, int dy) {
        int old = offsetTotal;
        int top = offsetTotal + dy;
        top = Math.min(top, screenH + child.getHeight());
        top = Math.max(top, screenH);
        offsetTotal = top;
        if (old == offsetTotal) {
            return;
        }
        int delta = top - old;
        child.offsetTopAndBottom(delta);
    }
}
