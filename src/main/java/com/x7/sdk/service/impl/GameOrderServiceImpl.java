package com.x7.sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.x7.sdk.enumeration.EncodingType;
import com.x7.sdk.enumeration.MethodName;
import com.x7.sdk.model.request.GetPaymentOrderQueryEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.GameOrderService;
import com.x7.sdk.util.X7RSAUtil;

public class GameOrderServiceImpl implements GameOrderService {

    private final String gamePrivateKey;
    private final String x7PublicKey;

    private final static String PAYLOAD_TEMPLATE = "POST %s@%s#%s.%s\n\n%s";

    public GameOrderServiceImpl(String gamePrivateKey, String x7PublicKey) {
        this.gamePrivateKey = gamePrivateKey;
        this.x7PublicKey = x7PublicKey;
    }

    /**
     * 获取订单查询接口请求参数加密
     * @param request 获取订单查询接口请求参数
     * @return 加密后的请求参数
     */
    @Override
    public MethodCommonReqResponse encryptPaymentOrderQueryRequest(GetPaymentOrderQueryEncryptionRequest request) {
        try {
            JSONObject roleJson = new JSONObject();
            roleJson.put("startTime", request.getStartTime());
            roleJson.put("endTime", request.getEndTime());
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_ORDER_QUERY.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    roleJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setBizParams(roleJson.toString());
            response.setApiMethod(MethodName.X7_ORDER_QUERY.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Get encryptPaymentOrderQueryRequest failed", e);
        }
    }

    /**
     * 获取订单查询接口响应参数解密
     * @param request 获取订单查询接口响应参数
     * @return 解密后的响应参数
     */
    @Override
    public SignatureVerifyCommonResponse decryptPaymentOrderQueryResponse(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_ORDER_QUERY.getMethodName(),
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
            throw new RuntimeException("Get decryptPaymentOrderQueryResponse failed", e);
        }
    }
}
