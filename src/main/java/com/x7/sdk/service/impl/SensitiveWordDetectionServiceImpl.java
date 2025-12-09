package com.x7.sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.x7.sdk.enumeration.EncodingType;
import com.x7.sdk.enumeration.MethodName;
import com.x7.sdk.model.request.GetHandleMethodReportEncryptionRequest;
import com.x7.sdk.model.request.GetInfoDetectionEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.SensitiveWordDetectionService;
import com.x7.sdk.util.X7RSAUtil;

public class SensitiveWordDetectionServiceImpl implements SensitiveWordDetectionService {

    private final String gamePrivateKey;
    private final String x7PublicKey;

    private final static String PAYLOAD_TEMPLATE = "POST %s@%s#%s.%s\n\n%s";

    public SensitiveWordDetectionServiceImpl(String gamePrivateKey, String x7PublicKey) {
        this.gamePrivateKey = gamePrivateKey;
        this.x7PublicKey = x7PublicKey;
    }

    /**
     * 信息检测接口请求参数加密
     */
    @Override
    public MethodCommonReqResponse encryptDetectionRequest(GetInfoDetectionEncryptionRequest request) {
        try {
            JSONObject roleJson = new JSONObject();
            roleJson.put("guid", request.getGuid());
            roleJson.put("detectionMessage", request.getDetectionMessage());
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.SENSITIVE_WORLD_CHECK.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    roleJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setBizParams(roleJson.toString());
            response.setApiMethod(MethodName.SENSITIVE_WORLD_CHECK.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Get encryptDetectionRequest failed", e);
        }
    }

    /**
     * 信息检测接口响应参数解密
     */
    @Override
    public SignatureVerifyCommonResponse decryptDetectionResult(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.SENSITIVE_WORLD_CHECK.getMethodName(),
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
            throw new RuntimeException("Get DecryptDetectionResult failed", e);
        }
    }

    /**
     * 信息处理方式接口请求参数加密
     */
    @Override
    public MethodCommonReqResponse encryptReportRequest(GetHandleMethodReportEncryptionRequest request) {
        try {
            JSONObject roleJson = new JSONObject();
            roleJson.put("detectionLogId", request.getDetectionLogId());
            roleJson.put("operateType", request.getOperateType());
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.SENSITIVE_WORLD_HANDEL_WAY.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    roleJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setBizParams(roleJson.toString());
            response.setApiMethod(MethodName.SENSITIVE_WORLD_HANDEL_WAY.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Get EncryptReportRequest failed", e);
        }
    }

    /**
     * 信息处理方式接口响应参数解密
     */
    @Override
    public SignatureVerifyCommonResponse decryptReportResponse(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.SENSITIVE_WORLD_HANDEL_WAY.getMethodName(),
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
            throw new RuntimeException("Get DecryptReportResponse failed", e);
        }
    }

}
