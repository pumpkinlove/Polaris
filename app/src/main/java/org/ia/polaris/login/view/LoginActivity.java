package org.ia.polaris.login.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ia.polaris.BaseActivity;
import org.ia.polaris.R;
import org.ia.polaris.login.presenter.ILoginPresenter;
import org.ia.polaris.login.presenter.LoginPresenterImpl;
import org.ia.polaris.main.view.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    ProgressDialog progressDialog;
    ILoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initData();
        initView();

    }

    @OnClick(R.id.btn_login)
    void onLoginClicked() {
        loginPresenter.login(etUsername.getText().toString(), etPassword.getText().toString());
    }

    @Override
    protected void initData() {
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在登录...");
        progressDialog.setCancelable(false);
    }

    @Override
    public void clearUsername() {
        etUsername.setText("");
    }

    @Override
    public void clearPassword() {
        etPassword.setText("");
    }

    @Override
    public void showPd() {
        progressDialog.show();
    }

    @Override
    public void hidePd() {
        progressDialog.dismiss();
    }

    @Override
    public void showErrorInfo() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
