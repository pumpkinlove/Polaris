package org.ia.polaris.main.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.ia.polaris.BaseActivity;
import org.ia.polaris.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tb_main)
    Toolbar tbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initToolBar();
    }

    private void initToolBar() {
        tbMain.setTitle("首页");
        tbMain.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(tbMain);
    }
}
