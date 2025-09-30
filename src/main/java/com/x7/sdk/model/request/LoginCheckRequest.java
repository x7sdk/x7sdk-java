package com.x7.sdk.model.request;

import java.util.Objects;

public class LoginCheckRequest {

    /**
     * 由【小7SDK】传递给【游戏客户端】。
     */
    private String tokenKey;

    /**
     * 游戏appKey
     */
    private String appKey;

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LoginCheckRequest)) {
            return false;
        }
        LoginCheckRequest that = (LoginCheckRequest) o;
        return Objects.equals(tokenKey, that.tokenKey) && Objects.equals(appKey, that.appKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenKey, appKey);
    }

    @Override
    public String toString() {
        return "LoginCheckRequest{" +
                "tokenKey='" + tokenKey + '\'' +
                ", appKey='" + appKey + '\'' +
                '}';
    }
}
