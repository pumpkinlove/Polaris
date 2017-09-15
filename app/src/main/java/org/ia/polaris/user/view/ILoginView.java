package org.ia.polaris.user.view;

/**
 * Created by xu.nan on 2017/8/31.
 */

public interface ILoginView {

    void clearUsername();
    void clearPassword();
    void showPd();
    void hidePd();
    void showErrorMsg(int code, String errMsg);
    void goBack();

}