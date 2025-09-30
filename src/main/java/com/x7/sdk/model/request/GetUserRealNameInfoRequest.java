package com.x7.sdk.model.request;

import java.util.Objects;

public class GetUserRealNameInfoRequest {
    /**
     * 请求报文体加密数据
     */
    private String data;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetUserRealNameInfoRequest)) {
            return false;
        }
        GetUserRealNameInfoRequest that = (GetUserRealNameInfoRequest) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }

    @Override
    public String toString() {
        return "GetUserRealNameInfoRequest{" +
                "data='" + data + '\'' +
                '}';
    }
}
