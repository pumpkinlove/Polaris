package org.ia.polaris.main.view;

import android.graphics.Bitmap;

/**
 * Created by xu.nan on 2017/9/11.
 */

public interface IMainView {

    void toUserView();
    void toUserInfoView();

    void toConfig();
    void nightMode();

    void toHomePage();
    void toTypePage(String type);

    void toMyCollection();
    void onOffLineLoading();

    void showUserInfo(Bitmap userIcon, String username);
    void showNotLogin();

    void openDrawer();
    void closeDrawer();

}
