package org.ia.polaris.login.view;

/**
 * Created by xu.nan on 2017/8/31.
 */

public interface ILoginView {
    void clearUsername();
    void clearPassword();
    void showPd();
    void hidePd();
    void showErrorInfo();
    void toMainActivity();
}
