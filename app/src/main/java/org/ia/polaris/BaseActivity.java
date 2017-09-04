package org.ia.polaris;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xu.nan on 2017/8/31.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void initData();
    protected abstract void initView();
}
