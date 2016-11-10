package io.github.seemuch.coordinatorlayoutexperiment;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by shiningsun on 10/23/16.
 */

public class ToolbarBehavior extends CoordinatorLayout.Behavior<Toolbar> {

    public ToolbarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar toolbar, View dependency) {
        return dependency instanceof RecyclerView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Toolbar child, View dependency) {
        Log.e("zhenzheng", "aaaaaaaaaa");
        RecyclerView recyclerView = (RecyclerView) dependency;

        /*
        float translationY = getFabTranslationYForSnackbar(parent, child);
        float percentComplete = -translationY / dependency.getHeight();
        float scaleFactor = 1 - percentComplete;
        */
        int res = recyclerView.computeVerticalScrollOffset();
        Log.e("zhenzheng", "res: " + res);
        /*
        child.setScaleX(scaleFactor);
        child.setScaleY(scaleFactor);
        */
        return true;
    }

    /*
    @Override
    void onNestedScroll (CoordinatorLayout coordinatorLayout,
                         Toolbar child,
                         View target,
                         int dxConsumed,
                         int dyConsumed,
                         int dxUnconsumed,
                         int dyUnconsumed) {

    }
    */
}
