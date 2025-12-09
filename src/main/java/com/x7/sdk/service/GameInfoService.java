package com.x7.sdk.service;

import com.x7.sdk.model.request.GameRoleReportResultVerifyRequest;
import com.x7.sdk.model.request.GetGameRoleInfoQueryEncryptionRequest;
import com.x7.sdk.model.request.GetGameRoleReportSignRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.GameRoleReportResultVerifyResponse;
import com.x7.sdk.model.response.GetGameRoleReportSignResponse;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;

public interface GameInfoService {

    /**
     * 获取游戏角色信息接口请求参数加密
     * @param request 获取游戏角色信息接口请求参数
     * @return 加密后的请求参数
     */
    MethodCommonReqResponse encryptGameRoleInfoQueryRequest(GetGameRoleInfoQueryEncryptionRequest request);

    /**
     * 获取游戏角色信息接口返回结果解密
     * @param request 获取游戏角色信息接口返回结果
     * @return 验签结果
     */
    SignatureVerifyCommonResponse decryptGameRoleInfoQueryResponse(MethodCommonRespVerifyRequestBO request);

    /**
     * 上报游戏角色信息接口请求参数加密
     * @param request 获取游戏角色信息接口返回结果
     * @return 验签结果
     */
    GetGameRoleReportSignResponse getGameRoleReportSign(GetGameRoleReportSignRequest request);


    /**
     * 上报游戏角色信息接口返回结果解密
     * @param request 获取游戏角色信息接口返回结果
     * @return 验签结果
     */
    GameRoleReportResultVerifyResponse getGameRoleReportVerifyResult(GameRoleReportResultVerifyRequest request);
}
