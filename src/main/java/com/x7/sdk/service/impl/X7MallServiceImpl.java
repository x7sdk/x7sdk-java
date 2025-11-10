package com.x7.sdk.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.x7.sdk.enumeration.EncodingType;
import com.x7.sdk.enumeration.MethodName;
import com.x7.sdk.model.GameRoleInfo;
import com.x7.sdk.model.IssuedProp;
import com.x7.sdk.model.request.GetMallEntranceEncryptionRequest;
import com.x7.sdk.model.request.GetMallIssuedPropsEncryption;
import com.x7.sdk.model.request.GetMallOrderNotifyEncryptionRequest;
import com.x7.sdk.model.request.GetMallQueryPropsEncryption;
import com.x7.sdk.model.request.GetMallRoleEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.X7MallService;
import com.x7.sdk.util.X7RSAUtil;
import java.util.LinkedHashMap;

public class X7MallServiceImpl implements X7MallService {
    private final String gamePrivateKey;
    private final String x7PublicKey;

    private final static String PAYLOAD_TEMPLATE = "POST %s@%s#%s.%s\n\n%s";


    public X7MallServiceImpl(String gamePrivateKey, String x7PublicKey) {
        this.gamePrivateKey = gamePrivateKey;
        this.x7PublicKey = x7PublicKey;
    }

    /**
     * 获取商城入口加密串
     */
    @Override
    public MethodCommonReqResponse getMallEntranceEncryption(GetMallEntranceEncryptionRequest request) {
        try {
            String infoJson = buildRoleInfoJson(request.getRole());
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_ENTRANCE_QUERY.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    infoJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setOsType(request.getOsType());
            response.setBizParams(infoJson);
            response.setApiMethod(MethodName.X7_MALL_ENTRANCE_QUERY.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Get GetMallEntranceEncryptionRequest failed", e);
        }
    }

    /**
     * 验证商城入口返回值
     */
    @Override
    public SignatureVerifyCommonResponse checkMallEntranceResp(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_ENTRANCE_QUERY.getMethodName(),
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
            throw new RuntimeException("Get CheckX7MallEntranceRespRequest failed", e);
        }
    }

    /**
     * 获取商城角色加密串
     */
    @Override
    public MethodCommonReqResponse getMallRoleEncryption(GetMallRoleEncryptionRequest request) {
        try {
            JSONObject roleJson = new JSONObject();
            roleJson.put("roleId", request.getRoleId());
            roleJson.put("guid", request.getGuid());
            String infoJson = roleJson.toJSONString();
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_ROLE_QUERY.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    infoJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setOsType(request.getOsType());
            response.setBizParams(infoJson);
            response.setApiMethod(MethodName.X7_MALL_ROLE_QUERY.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Get GetMallRoleEncryption failed", e);
        }
    }

    @Override
    public SignatureVerifyCommonResponse checkMallRoleResp(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_ROLE_QUERY.getMethodName(),
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
            throw new RuntimeException("Get CheckMallRoleResp failed", e);
        }
    }

    @Override
    public MethodCommonReqResponse getMallOrderNotifyEncryption(GetMallOrderNotifyEncryptionRequest request) {
        try {
            String infoJson = buildOrderNotifyInfoJson(request);
            // 构建签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_ORDER_NOTIFY.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    infoJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setOsType(request.getOsType());
            response.setBizParams(infoJson);
            response.setApiMethod(MethodName.X7_MALL_ORDER_NOTIFY.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        }catch (Exception e) {
            throw new RuntimeException("Get GetMallOrderNotifyEncryptionRequest failed", e);
        }
    }

    @Override
    public SignatureVerifyCommonResponse checkMallOrderNotifyResp(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_ORDER_NOTIFY.getMethodName(),
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
            throw new RuntimeException("Get CheckMallOrderNotifyResp failed", e);
        }
    }

    @Override
    public MethodCommonReqResponse getMallIssuedPropsEncryption(GetMallIssuedPropsEncryption request) {
        try {
            String infoJson = buildIssuedPropsInfoJson(request);
            // 构建签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_ISSUED_PROPS_ENCRYPTION.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    infoJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setOsType(request.getOsType());
            response.setBizParams(infoJson);
            response.setApiMethod(MethodName.X7_MALL_ISSUED_PROPS_ENCRYPTION.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Get GetMallIssuedPropsEncryption failed", e);
        }
    }

    @Override
    public SignatureVerifyCommonResponse checkMallIssuedPropsResp(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_ISSUED_PROPS_ENCRYPTION.getMethodName(),
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
            throw new RuntimeException("Get CheckMallIssuedPropsResp failed", e);
        }
    }

    @Override
    public MethodCommonReqResponse getMallQueryPropsEncryption(GetMallQueryPropsEncryption request) {
        try {
            JSONObject roleJson = new JSONObject();
            roleJson.put("propCode", request.getPropCode());
            String infoJson = roleJson.toJSONString();
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_QUERY_PROPS_DECRYPTION.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    infoJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setOsType(request.getOsType());
            response.setBizParams(infoJson);
            response.setApiMethod(MethodName.X7_MALL_QUERY_PROPS_DECRYPTION.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        }catch (Exception e) {
            throw new RuntimeException("Get GetMallQueryPropsEncryption failed", e);
        }
    }

    @Override
    public SignatureVerifyCommonResponse checkMallQueryPropsResp(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_MALL_QUERY_PROPS_DECRYPTION.getMethodName(),
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
            throw new RuntimeException("Get CheckMallIssuedPropsResp failed", e);
        }
    }


    /**
     * 构建角色信息JSON字符串
     */
    private String buildRoleInfoJson(GameRoleInfo request) {
        JSONObject roleJson = new JSONObject();

        // 必填字段
        roleJson.put("roleId", request.getRoleId());
        roleJson.put("guid", request.getGuid());
        roleJson.put("roleName", request.getRoleName());
        roleJson.put("serverId", request.getServerId());
        roleJson.put("serverName", request.getServerName());
        roleJson.put("roleLevel", request.getRoleLevel());
        roleJson.put("roleCE", request.getRoleCE());
        roleJson.put("roleStage", request.getRoleStage());
        roleJson.put("roleRechargeAmount", String.format("%.2f", request.getRoleRechargeAmount()));
        JSONObject bizParams = new JSONObject();
        bizParams.put("role", roleJson);
        return bizParams.toJSONString();
    }

    /**
     * 构建订单信息JSON字符串
     */
    private String buildOrderNotifyInfoJson(GetMallOrderNotifyEncryptionRequest request) {
        JSONObject orderJson = new JSONObject();

        // 严格按照图片中bizParams字段顺序构建
        orderJson.put("orderId", request.getOrderId());
        orderJson.put("x7Goid", request.getX7Gold());
        orderJson.put("guid", request.getGuid());
        orderJson.put("roleId", request.getRoleId());
        orderJson.put("roleName", request.getRoleName());
        orderJson.put("serverId", request.getServerId());
        orderJson.put("serverName", request.getServerName());
        orderJson.put("activityName", request.getActivityName());
        orderJson.put("subject", request.getSubject());
        orderJson.put("price", request.getPrice());
        orderJson.put("couponValue", request.getCouponValue());
        orderJson.put("payPrice", request.getPayPrice());
        orderJson.put("createTime", request.getCreateTime());
        orderJson.put("successTime", request.getSuccessTime());

        return orderJson.toJSONString();
    }

    /**
     * 构建发放道具信息JSON字符串
     */
    private String buildIssuedPropsInfoJson(GetMallIssuedPropsEncryption request) {
        JSONObject bizJson = new JSONObject(new LinkedHashMap<>());

        // 严格按照图片中bizParams字段顺序构建
        bizJson.put("issueOrderId", request.getIssueOrderId());
        bizJson.put("roleId", request.getRoleId());
        bizJson.put("guid", request.getGuid());
        bizJson.put("serverId", request.getServerId());
        bizJson.put("serverName", request.getServerName());
        bizJson.put("issueTime", request.getIssueTime());
        bizJson.put("mailTitle", request.getMailTitle());
        bizJson.put("mailContent", request.getMailContent());
        bizJson.put("isTest", request.getTest());

        // 处理发放的道具信息数组
        JSONArray issuedPropsArray = new JSONArray();
        if (request.getIssuedProps() != null && !request.getIssuedProps().isEmpty()) {
            for (IssuedProp prop : request.getIssuedProps()) {
                JSONObject propJson = new JSONObject();
                propJson.put("propCode", prop.getPropCode());
                propJson.put("propName", prop.getPropName());
                propJson.put("propQuantity", prop.getPropQuantity());
                issuedPropsArray.add(propJson);
            }
        }
        bizJson.put("issuedProps", issuedPropsArray);
        return bizJson.toJSONString();
    }
}
