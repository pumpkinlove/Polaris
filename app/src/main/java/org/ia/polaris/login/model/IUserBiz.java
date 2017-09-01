package org.ia.polaris.login.model;

/**
 * Created by xu.nan on 2017/8/31.
 */

public interface IUserBiz {

    int SUCCESS = 0;
    int NO_USER = -1;
    int PWD_ERROR = -2;
    int OTHER_ERROR = -3;

    int checkUserValidity();
}
