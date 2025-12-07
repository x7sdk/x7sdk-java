package com.x7.sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.x7.sdk.enumeration.EncodingType;
import com.x7.sdk.enumeration.MethodName;
import com.x7.sdk.model.request.GetServerLauncherNotifyEncryptionRequest;
import com.x7.sdk.model.request.GetServerLauncherQueryEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.ServerLauncherService;
import com.x7.sdk.util.X7RSAUtil;

public class ServerLauncherServiceImpl implements ServerLauncherService {
    private final String gamePrivateKey;
    private final String x7PublicKey;

    private final static String PAYLOAD_TEMPLATE = "POST %s@%s#%s.%s\n\n%s";

    public ServerLauncherServiceImpl(String gamePrivateKey, String x7PublicKey) {
        this.gamePrivateKey = gamePrivateKey;
        this.x7PublicKey = x7PublicKey;
    }

    /**
     * 开服查询请求参数加密
     */
    @Override
    public MethodCommonReqResponse encryptServerLauncherQueryRequest(GetServerLauncherQueryEncryptionRequest request) {
        try {
            JSONObject roleJson = new JSONObject();
            roleJson.put("startTime", request.getStartTime());
            roleJson.put("endTime", request.getEndTime());
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_SERVER_LAUNCHER_QUERY.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    roleJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setBizParams(roleJson.toString());
            response.setApiMethod(MethodName.X7_SERVER_LAUNCHER_QUERY.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Get encryptServerLauncherQueryRequest failed", e);
        }
    }

    /**
     * 开服查询结果验签
     */
    @Override
    public SignatureVerifyCommonResponse decryptServerLauncherQueryResponse(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_SERVER_LAUNCHER_QUERY.getMethodName(),
                    request.getAppkey(),
                    request.getGameType(),
                    request.getRespTime(),
                    request.getBizResp());
            boolean isVerify = X7RSAUtil.verifyWithSHA2(payload.getBytes(EncodingType.UTF_8.getValue()), x7PublicKey,
                    request.getSignature());
            SignatureVerifyCommonResponse verifyResponse = new SignatureVerifyCommonResponse();
            verifyResponse.setValid(isVerify);
            return verifyResponse;
        } catch (Exception e) {
            throw new RuntimeException("Get decryptServerLauncherQueryResponse failed", e);
        }
    }

    /**
     * 开服通知请求参数加密
     */
    @Override
    public MethodCommonReqResponse encryptServerLauncherNotifyRequest(
            GetServerLauncherNotifyEncryptionRequest request) {
        try {
            JSONObject roleJson = new JSONObject();
            roleJson.put("serverList", request.getServerList());
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_SERVER_LAUNCHER_NOTIFY.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    roleJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setBizParams(roleJson.toString());
            response.setApiMethod(MethodName.X7_SERVER_LAUNCHER_NOTIFY.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Get encryptServerLauncherNotifyRequest failed", e);
        }
    }

    /**
     * 开服通知结果验签
     */
    @Override
    public SignatureVerifyCommonResponse decryptServerLauncherNotifyResponse(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_SERVER_LAUNCHER_NOTIFY.getMethodName(),
                    request.getAppkey(),
                    request.getGameType(),
                    request.getRespTime(),
                    request.getBizResp());
            boolean isVerify = X7RSAUtil.verifyWithSHA2(payload.getBytes(EncodingType.UTF_8.getValue()), x7PublicKey,
                    request.getSignature());
            SignatureVerifyCommonResponse verifyResponse = new SignatureVerifyCommonResponse();
            verifyResponse.setValid(isVerify);
            return verifyResponse;
        } catch (Exception e) {
            throw new RuntimeException("Get decryptServerLauncherNotifyResponse failed", e);
        }
    }
}
