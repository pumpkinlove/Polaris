package org.ia.polaris.login.model;

/**
 * Created by xu.nan on 2017/8/31.
 */

public class PolarisUser implements IUser {
    public static final int SUCCESS = 0;
    public static final int NO_USER = -1;
    public static final int PWD_ERROR = -2;
    public static final int OTHER_ERROR = -3;

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
    public int checkUserValidate() {
        try {
            if ("".equals(username)) {
                if ("".equals(password)) {
                    return SUCCESS;
                }
                return PWD_ERROR;
            } else {
                return NO_USER;
            }
        } catch (Exception e) {
            return OTHER_ERROR;
        }
    }
}
