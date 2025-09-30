package com.x7.sdk.enumeration;

public enum Domain {
    X7_SDK_PROD("https://api.x7sy.com", "生产环境域名");

    private String url;
    private String desc;

    Domain(String url, String desc) {
        this.url = url;
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public String getDesc() {
        return desc;
    }
}
