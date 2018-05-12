package org.landy.builder.domain;

/**
 * @author landyl
 * @create 5:03 PM 05/12/2018
 */
public class UserProfile {

    private String userId;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return " 用户信息：" + userId + "---" + userName;
    }
}
