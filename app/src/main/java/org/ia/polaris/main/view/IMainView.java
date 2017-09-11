package org.ia.polaris.main.view;

/**
 * Created by xu.nan on 2017/9/11.
 */

public interface IMainView {

    void toLogin();
    void toConfig();
    void nightMode();

    void toHomePage();
    void toTypePage(String type);

    void toMyCollection();
    void onOffLineLoading();

    void showUserInfo();

}
