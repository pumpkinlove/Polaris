package org.ia.polaris.login.model;

/**
 * Created by xu.nan on 2017/8/31.
 */

public interface IUser {

    public static final int SUCCESS = 0;
    public static final int NO_USER = -1;
    public static final int PWD_ERROR = -2;
    public static final int OTHER_ERROR = -3;

    int checkUserValidity();
}
