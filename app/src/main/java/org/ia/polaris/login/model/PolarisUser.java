package org.ia.polaris.login.model;

/**
 * Created by xu.nan on 2017/8/31.
 */

public class PolarisUser implements IUserBiz {

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
    public int checkUserValidity() {
        try {
            Thread.sleep(3000);
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
