package org.ia.polaris.login.presenter;

import org.ia.polaris.login.model.Callback;
import org.ia.polaris.login.model.IUserModel;
import org.ia.polaris.login.model.PolarisUser;
import org.ia.polaris.login.view.ILoginView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

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
