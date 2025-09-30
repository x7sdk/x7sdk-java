package com.x7.sdk.enumeration;

public enum ApiEndpoint {

    USER_CHECK_LOGIN("/user/check_v4_login", "登录验证用户信息", "https://docs.x7sy.com/#/Android接入/必接功能/登录");

    private final String path;
    private final String description;
    private final String docUrl;

    ApiEndpoint(String path, String description, String docUrl) {
        this.path = path;
        this.description = description;
        this.docUrl = docUrl;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public String getDocUrl() {
        return docUrl;
    }
}
