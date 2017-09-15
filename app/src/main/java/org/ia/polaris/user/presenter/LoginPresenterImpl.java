package org.ia.polaris.user.presenter;

import org.ia.polaris.user.model.Callback;
import org.ia.polaris.user.model.IUserModel;
import org.ia.polaris.user.model.PolarisUser;
import org.ia.polaris.user.view.ILoginView;

/**
 * Created by xu.nan on 2017/8/31.
 */

public class LoginPresenterImpl implements ILoginPresenter {
    ILoginView loginView;
    IUserModel userModel;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        userModel = new PolarisUser();
    }

    @Override
    public void login(String username, String password) {
        userModel.login(username, password, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure() {

            }
        });
    }

}
