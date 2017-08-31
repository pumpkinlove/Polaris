package org.ia.polaris;

import android.app.Activity;

/**
 * Created by xu.nan on 2017/8/31.
 */

public abstract class BaseActivity extends Activity {
    protected abstract void initData();
    protected abstract void initView();
}
