package com.x7.sdk.service;

import com.x7.sdk.model.request.GetMallEntranceEncryptionRequest;
import com.x7.sdk.model.request.GetMallIssuedPropsEncryption;
import com.x7.sdk.model.request.GetMallOrderNotifyEncryptionRequest;
import com.x7.sdk.model.request.GetMallQueryPropsEncryption;
import com.x7.sdk.model.request.GetMallRoleEncryptionRequest;
import com.x7.sdk.model.request.MethodCommonRespVerifyRequestBO;
import com.x7.sdk.model.response.MethodCommonReqResponse;
import com.x7.sdk.model.response.SignatureVerifyCommonResponse;

public interface X7MallService {

    /**
     * 获取商城入口加密信息
     * @param request
     * @return
     */
    MethodCommonReqResponse getMallEntranceEncryption(GetMallEntranceEncryptionRequest request);

    /**
     * 验证商城入口返回值
     */
    SignatureVerifyCommonResponse checkMallEntranceResp(MethodCommonRespVerifyRequestBO request);

    /**
     * 获取商城角色信息加密信息
     */
    MethodCommonReqResponse getMallRoleEncryption(GetMallRoleEncryptionRequest request);

    /**
     * 验证商城角色信息返回值
     */
    SignatureVerifyCommonResponse checkMallRoleResp(MethodCommonRespVerifyRequestBO request);

    /**
     * 获取商城订单通知加密信息
     */
    MethodCommonReqResponse getMallOrderNotifyEncryption(GetMallOrderNotifyEncryptionRequest request);

    /**
     * 验证商城订单通知返回值
     */
    SignatureVerifyCommonResponse checkMallOrderNotifyResp(MethodCommonRespVerifyRequestBO request);

    /**
     * 获取道具发放加密信息
     */
    MethodCommonReqResponse getMallIssuedPropsEncryption(GetMallIssuedPropsEncryption request);

    /**
     * 验证道具发放返回值
     */
    SignatureVerifyCommonResponse checkMallIssuedPropsResp(MethodCommonRespVerifyRequestBO request);

    /**
     * 获取道具查询加密信息
     */
    MethodCommonReqResponse getMallQueryPropsEncryption(GetMallQueryPropsEncryption request);

    /**
     * 验证道具查询返回值
     */
    SignatureVerifyCommonResponse checkMallQueryPropsResp(MethodCommonRespVerifyRequestBO request);
}
