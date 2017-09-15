package org.ia.polaris.user.model;

/**
 * Created by xu.nan on 2017/8/31.
 */

public interface IUserModel {

    void login(String username, String password, Callback callback);
    void register();

}
