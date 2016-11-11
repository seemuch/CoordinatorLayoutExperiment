package io.github.seemuch.coordinatorlayoutexperiment;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MyBehavior extends CoordinatorLayout.Behavior<View> {
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View toolbar, View dependency) {
        return dependency instanceof RecyclerView;
    }


    @Override
    public boolean onStartNestedScroll (CoordinatorLayout coordinatorLayout,
                                 View child,
                                 View directTargetChild,
                                 View target,
                                 int nestedScrollAxes) {

        int vertical = (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL);
        int horizontal = (nestedScrollAxes & ViewCompat.SCROLL_AXIS_HORIZONTAL);

        return (vertical != 0 && horizontal == 0);
    }

    @Override
    public void onNestedPreScroll (CoordinatorLayout coordinatorLayout,
                            View child,
                            View target,
                            int dx,
                            int dy,
                            int[] consumed) {

        float currY = child.getY();
        if (currY <= 0 && dy >= 0) {
            return;
        }
        child.setY(currY - dy);
        // consumed[1] = 1000000000;
    }

}
