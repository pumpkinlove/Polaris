package org.ia.polaris.login.presenter;

import org.ia.polaris.login.model.IUser;
import org.ia.polaris.login.model.PolarisUser;
import org.ia.polaris.login.view.ILoginView;

/**
 * Created by xu.nan on 2017/8/31.
 */

public class LoginPresenterImpl implements ILoginPresenter {
    ILoginView iLoginView;
    IUser user;



    @Override
    public void login(String username, String password) {

        int code = user.checkUserValidate();
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
