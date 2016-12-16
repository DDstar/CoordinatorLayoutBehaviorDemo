package com.ddstar.customcomponent;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DDstar on 2016/12/16.
 */

public class ScrollBehaviorD extends CoordinatorLayout.Behavior {

    public ScrollBehaviorD(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;//竖直滚动就关心
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        offsetUp(child, dyConsumed);
    }

    int offsetTotal = 0;

    public void offsetUp(View child, int dy) {
        int old = offsetTotal;
        int top = offsetTotal - dy;//获取总的移动像素，得到y轴的顶点位置
        top = Math.max(top, -child.getHeight());//往上移最多将整个view移除屏幕就不移动，所以顶点不超过child的高
        top = Math.min(top, 0);//往下移最多整个child移进屏幕内就不移动
        offsetTotal = top;//保存此次顶点位置
        if (old == offsetTotal) {
            return;
        }
        int delta = offsetTotal - old;//此次的顶点位置减去上次的顶点位置，就是本次应该移动的位置，大于0下移，小于0上移
        child.offsetTopAndBottom(delta);//移动child
    }

}
