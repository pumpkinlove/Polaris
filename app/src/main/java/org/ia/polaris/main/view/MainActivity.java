package org.ia.polaris.main.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import org.ia.polaris.BaseActivity;
import org.ia.polaris.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.tb_main)
    Toolbar tbMain;
    @BindView(R.id.nav_main)
    NavigationView navMain;
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    @BindView(R.id.fl_main)
    FrameLayout flMain;

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
        initToggle();
        initNavigation();

        getFragmentManager().beginTransaction().replace(R.id.fl_main, new HomePageFragment()).commit();

    }

    private void initToolBar() {
        setSupportActionBar(tbMain);
    }

    private void initToggle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dlMain, tbMain, R.string.openDrawerDesc, R.string.closeDrawerDesc);
        dlMain.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initNavigation() {
        navMain.setNavigationItemSelectedListener(this);
        NavigationMenuView navigationMenuView = (NavigationMenuView) navMain.getChildAt(0);
        if (navigationMenuView != null) {
            navigationMenuView.setVerticalScrollBarEnabled(false);  //去除滚动条
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
