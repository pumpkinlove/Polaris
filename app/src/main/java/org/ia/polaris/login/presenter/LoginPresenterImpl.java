package org.ia.polaris.login.presenter;

import org.ia.polaris.login.model.IUser;
import org.ia.polaris.login.model.PolarisUser;
import org.ia.polaris.login.view.ILoginView;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xu.nan on 2017/8/31.
 */

public class LoginPresenterImpl implements ILoginPresenter {
    ILoginView iLoginView;
    IUser user;

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void login(String username, String password) {
        user = new PolarisUser(username, password);
        Observable.just(user)
                .map(new Function<IUser, Integer>() {
                    @Override
                    public Integer apply(@NonNull IUser iUser) throws Exception {
                        return iUser.checkUserValidity();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        iLoginView.onLoginResult(true, integer);
                    }
                });

    }

    @Override
    public void clear() {
        iLoginView.onClearInfo();
    }

    @Override
    public void setPbVisibility(boolean show) {
        iLoginView.onSetPbVisibility(show);
    }
}
