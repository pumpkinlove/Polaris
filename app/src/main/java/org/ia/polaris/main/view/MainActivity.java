package org.ia.polaris.main.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.ia.polaris.BaseActivity;
import org.ia.polaris.R;
import org.ia.polaris.main.presenter.IMainPresenter;
import org.ia.polaris.main.presenter.MainPresenterImpl;
import org.ia.polaris.user.view.UserFragment;
import org.ia.polaris.user.view.UserInfoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, IMainView {

    @BindView(R.id.tb_main)
    Toolbar tbMain;
    @BindView(R.id.nav_main)
    NavigationView navMain;
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    @BindView(R.id.fl_main)
    FrameLayout flMain;

    private IMainPresenter mainPresenter;

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
        mainPresenter = new MainPresenterImpl(this);
    }

    @Override
    protected void initView() {
        initToolBar();
        initToggle();
        initNavigation();

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, new HomePageFragment()).commit();

        View headView = navMain.getHeaderView(0);
        LinearLayout ll_user_nav = (LinearLayout) headView.findViewById(R.id.ll_user_nav);
        ll_user_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.checkIsLogin();
            }
        });


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

        navMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mainPresenter.loadTopicByType(item.getTitle().toString());
                return false;
            }
        });
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

    @Override
    public void toUserView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, new UserFragment()).commit();
    }

    @Override
    public void toUserInfoView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, new UserInfoFragment()).commit();
    }

    @Override
    public void toConfig() {

    }

    @Override
    public void nightMode() {

    }

    @Override
    public void toHomePage() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, new HomePageFragment()).commit();
    }

    @Override
    public void toTypePage(String type) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, new TypeFragment()).commit();
    }

    @Override
    public void toMyCollection() {

    }

    @Override
    public void onOffLineLoading() {

    }

    @Override
    public void showUserInfo(Bitmap userIcon, String username) {

    }

    @Override
    public void showNotLogin() {

    }

    @Override
    public void openDrawer() {
        dlMain.openDrawer(navMain);
    }

    @Override
    public void closeDrawer() {
        dlMain.closeDrawer(navMain);
    }
}
