package com.x7.sdk.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.x7.sdk.model.UserInfo;
import java.util.Objects;

/**
 * 登录态校验请求实体类 包含登录态校验返回的错误码、错误信息以及用户信息
 */
public class LoginCheckResponse {

    /**
     * 错误码，0表示成功，-1表示失败，在errormsg中有详细的失败原因。
     */
    @JSONField(name = "errorno")
    private int errorno;

    /**
     * 错误信息，当errorno为0的时候这里是空的，当errorno不为0的时候这里返回了错误信息。
     */
    @JSONField(name = "errormsg")
    private String errormsg;

    /**
     * 用户信息
     */
    @JSONField(name = "data")
    private UserInfo data;

    public int getErrorno() {
        return errorno;
    }

    public void setErrorno(int errorno) {
        this.errorno = errorno;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LoginCheckResponse)) {
            return false;
        }
        LoginCheckResponse that = (LoginCheckResponse) o;
        return errorno == that.errorno && Objects.equals(errormsg, that.errormsg) && Objects.equals(
                data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorno, errormsg, data);
    }

    @Override
    public String toString() {
        return "LoginCheckResponse{" +
                "errorno=" + errorno +
                ", errormsg='" + errormsg + '\'' +
                ", data=" + data +
                '}';
    }
}
