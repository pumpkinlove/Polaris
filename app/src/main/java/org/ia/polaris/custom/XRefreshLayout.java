package org.ia.polaris.custom;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

/**
 * Created by xu.nan on 2017/9/6.
 */

public class XRefreshLayout extends SwipeRefreshLayout {

    private static final String TAG = XRefreshLayout.class.getSimpleName();



    public XRefreshLayout(Context context) {
        super(context);
    }

    public XRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
