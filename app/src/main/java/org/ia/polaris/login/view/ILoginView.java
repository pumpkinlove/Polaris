package org.ia.polaris.login.view;

/**
 * Created by xu.nan on 2017/8/31.
 */

public interface ILoginView {
    void onClearInfo();
    void onLoginResult(boolean result, int code);
    void onSetPbVisibility(boolean show);
}
