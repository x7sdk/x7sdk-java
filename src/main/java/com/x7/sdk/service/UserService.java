package com.x7.sdk.service;

import com.x7.sdk.model.request.GetUserRealNameInfoRequest;
import com.x7.sdk.model.request.LoginCheckRequest;
import com.x7.sdk.model.response.GetUserRealNameInfoResponse;
import com.x7.sdk.model.response.LoginCheckResponse;

public interface UserService {

    /**
     * 登录态校验接口
     */
    public LoginCheckResponse loginCheck(LoginCheckRequest loginCheckRequest);

    /**
     * 获取用户实名信息
     */
    public GetUserRealNameInfoResponse getUserRealNameInfo(GetUserRealNameInfoRequest request);
}
