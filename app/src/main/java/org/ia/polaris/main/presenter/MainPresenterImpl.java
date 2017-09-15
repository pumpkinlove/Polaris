package org.ia.polaris.main.presenter;

import org.ia.polaris.main.view.IMainView;

/**
 * Created by xu.nan on 2017/9/14.
 */

public class MainPresenterImpl implements IMainPresenter {
    private boolean isLogin;
    private IMainView mainView;

    public MainPresenterImpl(IMainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void loadUserInfo() {

    }

    @Override
    public void loadContentType() {

    }

    @Override
    public void offLineLoading() {

    }

    @Override
    public void checkIsLogin() {
        mainView.closeDrawer();
        if (isLogin) {
            mainView.toUserInfoView();
        } else {
            mainView.toUserView();
        }
    }

    @Override
    public void loadTopicByType(String type) {
        mainView.closeDrawer();
        mainView.toTypePage(type);
    }

    public IMainView getMainView() {
        return mainView;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
