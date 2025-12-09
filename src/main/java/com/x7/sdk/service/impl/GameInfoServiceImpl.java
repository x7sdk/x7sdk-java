package com.x7.sdk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.x7.sdk.enumeration.EncodingType;
import com.x7.sdk.enumeration.MethodName;
import com.x7.sdk.model.GameRoleInfo;
import com.x7.sdk.model.request.GameRoleReportResultVerifyRequest;
import com.x7.sdk.model.request.GetGameRoleInfoQueryEncryptionRequest;
import com.x7.sdk.model.request.GetGameRoleReportSignRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.GameRoleReportResultVerifyResponse;
import com.x7.sdk.model.response.GetGameRoleReportSignResponse;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;
import com.x7.sdk.service.GameInfoService;
import com.x7.sdk.util.X7RSAUtil;

public class GameInfoServiceImpl implements GameInfoService {

    private final String gamePrivateKey;
    private final String x7PublicKey;

    private final static String GAME_ROLE_REPORT_METHOD = "common.roleReport";
    private final static String PAYLOAD_TEMPLATE = "POST %s@%s#%s.%s\n\n%s";

    public GameInfoServiceImpl(String gamePrivateKey, String x7PublicKey) {
        this.gamePrivateKey = gamePrivateKey;
        this.x7PublicKey = x7PublicKey;
    }


    /**
     * 角色信息查询接口请求参数加密
     */
    @Override
    public MethodCommonReqResponse encryptGameRoleInfoQueryRequest(GetGameRoleInfoQueryEncryptionRequest request) {
        try {
            JSONObject roleJson = new JSONObject();
            roleJson.put("roleId", request.getRoleId());
            roleJson.put("guids", request.getGuids());
            roleJson.put("serverId", request.getServerId());
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_GAME_ROLE_INFO_QUERY.getMethodName(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    roleJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            MethodCommonReqResponse response = new MethodCommonReqResponse();
            response.setSignature(sign);
            response.setBizParams(roleJson.toString());
            response.setApiMethod(MethodName.X7_GAME_ROLE_INFO_QUERY.getMethodName());
            response.setReqTime(request.getReqTime());
            response.setAppKey(request.getAppKey());
            response.setGameType(request.getGameType());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Get encryptGameRoleInfoQueryRequest failed", e);
        }
    }

    /**
     * 角色信息查询接口响应参数解密
     */
    @Override
    public SignatureVerifyCommonResponse decryptGameRoleInfoQueryResponse(MethodCommonRespVerifyRequestBO request) {
        try {
            String payload = String.format(PAYLOAD_TEMPLATE,
                    MethodName.X7_GAME_ROLE_INFO_QUERY.getMethodName(),
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
            throw new RuntimeException("Get decryptGameRoleInfoQueryResponse failed", e);
        }
    }

    /**
     * 获取游戏角色上报签名
     */
    @Override
    public GetGameRoleReportSignResponse getGameRoleReportSign(GetGameRoleReportSignRequest request) {
        try {
            GetGameRoleReportSignResponse signResponse = new GetGameRoleReportSignResponse();
            String roleInfoJson = buildRoleInfoJson(request.getRole());
            signResponse.setApiMethod(GAME_ROLE_REPORT_METHOD);
            signResponse.setAppKey(request.getAppKey());
            signResponse.setReqTime(request.getReqTime());
            signResponse.setBizParams(roleInfoJson);
            signResponse.setGameType(request.getGameType());
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    GAME_ROLE_REPORT_METHOD,
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    roleInfoJson);
            String sign = X7RSAUtil.sign(payload.getBytes(EncodingType.UTF_8.getValue()), gamePrivateKey);
            signResponse.setSignature(sign);
            return signResponse;
        } catch (Exception e) {
            throw new RuntimeException("Get getGameRoleReportSign failed", e);
        }
    }

    /**
     * 验证游戏角色上报结果
     */
    @Override
    public GameRoleReportResultVerifyResponse getGameRoleReportVerifyResult(GameRoleReportResultVerifyRequest request) {
        try {
            GameRoleReportResultVerifyResponse verifyResponse = new GameRoleReportResultVerifyResponse();
            // 生成签名payload
            String payload = String.format(PAYLOAD_TEMPLATE,
                    request.getApiMethod(),
                    request.getAppKey(),
                    request.getGameType(),
                    request.getReqTime(),
                    request.getBizResp());
            boolean isValid = X7RSAUtil.verifyWithSHA2(payload.getBytes(EncodingType.UTF_8.getValue()), x7PublicKey,
                    request.getSignature());
            verifyResponse.setValid(isValid);
            return verifyResponse;
        } catch (Exception e) {
            throw new RuntimeException("Get GameRoleReportResultVerifyRequest failed", e);
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

        // 选填字段
        if (request.getRoleLevel() != null) {
            roleJson.put("roleLevel", request.getRoleLevel());
        }
        if (request.getRoleCE() != null) {
            roleJson.put("roleCE", request.getRoleCE());
        }
        if (request.getRoleStage() != null) {
            roleJson.put("roleStage", request.getRoleStage());
        }
        if (request.getRoleRechargeAmount() != null) {
            roleJson.put("roleRechargeAmount", String.format("%.2f", request.getRoleRechargeAmount()));
        }
        if (request.getRoleGuild() != null) {
            roleJson.put("roleGuild", request.getRoleGuild());
        }
        JSONObject bizParams = new JSONObject();
        bizParams.put("role", roleJson);
        return bizParams.toJSONString();
    }


}
