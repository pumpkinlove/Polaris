package org.ia.polaris.login.presenter;

import org.ia.polaris.login.model.IUserBiz;
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
    ILoginView iLoginView;
    IUserBiz user;

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void login(String username, String password) {
        iLoginView.showPd();
        user = new PolarisUser(username, password);
        Observable.just(user)
                .map(new Function<IUserBiz, Integer>() {
                    @Override
                    public Integer apply(@NonNull IUserBiz iUserBiz) throws Exception {
                        return iUserBiz.checkUserValidity();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer loginResult) throws Exception {
                        iLoginView.hidePd();
                        if (0 == loginResult) {
                            iLoginView.toMainActivity();
                        } else {
                            iLoginView.showErrorInfo();
                        }
                    }
                });

    }

}
