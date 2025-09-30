package com.x7.sdk.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x7.sdk.enumeration.ApiEndpoint;
import com.x7.sdk.enumeration.Domain;
import com.x7.sdk.model.UserRealNameInfo;
import com.x7.sdk.model.request.GetUserRealNameInfoRequest;
import com.x7.sdk.model.request.LoginCheckRequest;
import com.x7.sdk.model.response.GetUserRealNameInfoResponse;
import com.x7.sdk.model.response.LoginCheckResponse;
import com.x7.sdk.service.UserService;
import com.x7.sdk.util.HttpUtil;
import com.x7.sdk.util.MD5Util;
import com.x7.sdk.util.X7RSAUtil;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final String x7PublicKey;

    public UserServiceImpl(String x7PublicKey) {
        this.x7PublicKey = x7PublicKey;
    }

    /**
     * 登录态校验
     *
     * @param loginCheckRequest 登录态校验请求体
     * @return 登录态校验响应体
     */
    @Override
    public LoginCheckResponse loginCheck(LoginCheckRequest loginCheckRequest) {
        LoginCheckResponse response = new LoginCheckResponse();
        try {
            String sign = MD5Util.md5(loginCheckRequest.getAppKey() + loginCheckRequest.getTokenKey());
            String url = Domain.X7_SDK_PROD.getUrl()
                    + ApiEndpoint.USER_CHECK_LOGIN.getPath()
                    + "?tokenkey=" + loginCheckRequest.getTokenKey()
                    + "&sign=" + sign;
            byte[] responseData = HttpUtil.get(url);
            String responseStr = new String(responseData, StandardCharsets.UTF_8);
            return JSON.parseObject(responseStr, LoginCheckResponse.class);
        }catch (Exception e) {
            response.setErrorno(-1);
            response.setErrormsg("请求异常: " + e);
            return response;
        }
    }

    /**
     * 获取用户实名信息
     */
    @Override
    public GetUserRealNameInfoResponse getUserRealNameInfo(GetUserRealNameInfoRequest request) {
        try {
            // 1. 使用RSA解密数据
            String decryptedData = X7RSAUtil.decryptDataByPublicKey(request.getData(), x7PublicKey);

            // 2. 解析JSON数据
            JSONObject jsonData = JSON.parseObject(decryptedData);
            JSONArray collectionsArray = jsonData.getJSONArray("collections");

            if (collectionsArray == null || collectionsArray.isEmpty()) {
                GetUserRealNameInfoResponse response = new GetUserRealNameInfoResponse();
                response.setUserRealNameInfoList(new ArrayList<>());
                return response;
            }

            // 3. 转换数据到对象列表
            List<UserRealNameInfo> userRealNameInfoList = new ArrayList<>();

            for (int i = 0; i < collectionsArray.size(); i++) {
                JSONObject item = collectionsArray.getJSONObject(i);

                UserRealNameInfo info = new UserRealNameInfo();
                info.setNo(item.getInteger("no"));
                info.setSi(item.getString("si"));
                info.setBt(item.getInteger("bt"));
                info.setOt(item.getLong("ot"));
                info.setCt(item.getInteger("ct"));
                info.setDi(item.getString("di"));
                info.setPi(item.getString("pi"));

                userRealNameInfoList.add(info);
            }
            // 4. 构建响应对象
            GetUserRealNameInfoResponse response = new GetUserRealNameInfoResponse();
            response.setUserRealNameInfoList(userRealNameInfoList);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("GET userRealNameInfo failed", e);
        }
    }
}
