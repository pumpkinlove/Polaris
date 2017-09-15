package org.ia.polaris.user.model;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xu.nan on 2017/8/31.
 */

public class PolarisUser implements IUserModel {

    private String username;
    private String password;

    public PolarisUser() {
    }

    public PolarisUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void login(String username, String password, final Callback callback) {
        this.username = username;
        this.password = password;

        Observable
                .just(this)
                .map(new Function<PolarisUser, String>() {
                    @Override
                    public String apply(@NonNull PolarisUser user) throws Exception {
                        return user.username;
                    }
                })
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        callback.onSuccess();
                    }
                });
    }

    @Override
    public void register() {

    }
}
