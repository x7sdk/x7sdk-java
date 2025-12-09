package com.x7.sdk.service.impl;

import com.x7.sdk.enumeration.EncodingType;
import com.x7.sdk.model.PaymentOrderInfo;
import com.x7.sdk.model.request.PaymentOrderCallbackVerifyRequest;
import com.x7.sdk.model.request.PaymentOrderEncryptedRequest;
import com.x7.sdk.model.response.PaymentOrderCallbackVerifyResponse;
import com.x7.sdk.model.response.PaymentOrderEncryptedResponse;
import com.x7.sdk.service.PaymentService;
import com.x7.sdk.util.MD5Util;
import com.x7.sdk.util.X7RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.codec.binary.Base64;

public class PaymentServiceImpl implements PaymentService {
    private final String x7PublicKey;

    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM_SHA1 = "SHA1withRSA";

    public PaymentServiceImpl(String x7PublicKey) {
        this.x7PublicKey = x7PublicKey;
    }

    /**
     * 获取支付订单加密信息
     * @param request
     * @return
     */
    @Override
    public PaymentOrderEncryptedResponse getPaymentOrderEncrypted(PaymentOrderEncryptedRequest request) {
        PaymentOrderEncryptedResponse response = new PaymentOrderEncryptedResponse();
        String gameSign = generateGameSign(request);
        response.setGameSign(gameSign);
        // 将一些请求参数原样返回
        response.setGameOrderId(request.getGameOrderId());
        response.setGamePrice(request.getGamePrice());
        response.setGameCurrency(request.getGameCurrency());
        response.setGameRoleId(request.getGameRoleId());
        response.setGameRoleName(request.getGameRoleName());
        response.setGameGuid(request.getGameGuid());
        response.setNotifyId(request.getNotifyId());
        response.setGameAccessVersion(request.getGameAccessVersion());
        response.setGameArea(request.getGameArea());
        response.setGameLevel(request.getGameLevel());
        response.setExtendsInfoData(request.getExtendsInfoData());
        response.setSubject(request.getSubject());
        return response;
    }

    /**
     * 订单回调验证签名
     */
    @Override
    public PaymentOrderCallbackVerifyResponse getPaymentOrderCallbackVerify(PaymentOrderCallbackVerifyRequest request) {
        PaymentOrderCallbackVerifyResponse response = new PaymentOrderCallbackVerifyResponse();
        try {
            //1. 签名验证
            boolean isSignatureValid = verifySignData(request);
            response.setValid(isSignatureValid);
            // 如果签名验证失败，直接返回
            if (!isSignatureValid) {
                return response;
            }
            // 2. 签名验证通过，返回解密后的数据
            PaymentOrderInfo paymentOrderInfo = decryptEncrypData(request.getEncrypData());
            response.setPaymentOrderInfo(paymentOrderInfo);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Signature verification failed", e);
        }
    }



    /**
     * 生成game_sign签名
     * 规则：将其他所有字段按字典序生成QueryString，拼接公钥后MD5
     */
    private String generateGameSign(PaymentOrderEncryptedRequest request) {
        Map<String, String> params = new TreeMap<>();

        if (request.getExtendsInfoData() != null) {
            params.put("extends_info_data", request.getExtendsInfoData());
        }
        params.put("game_area", request.getGameArea());
        params.put("game_level", request.getGameLevel());
        params.put("game_orderid", request.getGameOrderId());
        params.put("game_currency", request.getGameCurrency());
        params.put("game_price", request.getGamePrice());
        params.put("game_role_id", request.getGameRoleId());
        params.put("game_role_name", request.getGameRoleName());
        params.put("game_guid", String.valueOf(request.getGameGuid()));
        params.put("notify_id", request.getNotifyId());
        params.put("subject", request.getSubject());
        params.put("game_access_version", request.getGameAccessVersion());

        // 生成QueryString
        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (queryString.length() > 0) {
                queryString.append("&");
            }
            queryString.append(entry.getKey()).append("=").append(entry.getValue());
        }

        // 拼接公钥并MD5
        String stringToSign = queryString + x7PublicKey;
        return MD5Util.md5(stringToSign);
    }

    /**
     * 订单回调验证签名
     */
    private boolean verifySignData(PaymentOrderCallbackVerifyRequest request) throws Exception {
        try {
            // 1. 将sign_data进行base64_decode得到raw_sign_data（二进制数据）
            byte[] rawSignData = Base64.decodeBase64(request.getSignData());

            // 2. 将除sign_data以外的其他参数按字典序正序排列，拼接成查询字符串
            TreeMap<String, String> params = new TreeMap<>();

            // 添加除sign_data外的所有参数（使用图片中指定的参数名）
            if (request.getEncrypData() != null) {
                params.put("encryp_data", request.getEncrypData());
            }
            if (request.getExtendsInfoData() != null) {
                params.put("extends_info_data", request.getExtendsInfoData());
            }
            if (request.getGameArea() != null) {
                params.put("game_area", request.getGameArea());
            }
            if (request.getGameLevel() != null) {
                params.put("game_level", request.getGameLevel());
            }
            if (request.getGameOrderId() != null) {
                params.put("game_orderid", request.getGameOrderId());
            }
            if (request.getGameRoleId() != null) {
                params.put("game_role_id", request.getGameRoleId());
            }
            if (request.getGameRoleName() != null) {
                params.put("game_role_name", request.getGameRoleName());
            }
            if (request.getSdkVersion() != null) {
                params.put("sdk_version", request.getSdkVersion());
            }
            if (request.getSubject() != null) {
                params.put("subject", request.getSubject());
            }
            if (request.getXiao7Goid() != null) {
                params.put("xiao7_goid", String.valueOf(request.getXiao7Goid()));
            }
            if (request.getCouponPrice() != null) {
                String formattedPrice = String.format("%.2f", request.getCouponPrice());
                params.put("coupon_price", formattedPrice);
            }

            // 构建查询字符串：key=value&key=value（无需urlencode）
            StringBuilder sourceStrBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (sourceStrBuilder.length() > 0) {
                    sourceStrBuilder.append("&");
                }
                sourceStrBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            }
            String sourceStr = sourceStrBuilder.toString();
            // 验签（使用SHA1withRSA）
            byte[] keyBytes = Base64.decodeBase64(x7PublicKey);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PublicKey publicK = keyFactory.generatePublic(keySpec);
            // 使用SHA1withRSA算法进行签名验证
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM_SHA1);
            signature.initVerify(publicK);
            signature.update(sourceStr.getBytes(EncodingType.UTF_8.getValue()));

            // 验证签名
            return signature.verify(rawSignData);

        } catch (Exception e) {
            throw new Exception("签名验证失败: " + e.getMessage(), e);
        }
    }

    /**
     * 订单解密encryp_data得到关键数据
     */
    private PaymentOrderInfo decryptEncrypData(String encrypData) throws Exception {
        // 1. 将encryp_data进行base64_decode得到raw_encryp_data
        byte[] rawEncrypData = Base64.decodeBase64(encrypData);

        // 2. 使用小7RSA公钥解密得到查询字符串
        byte[] decryptedData = X7RSAUtil.decryptByPublicKey(rawEncrypData, x7PublicKey);
        String queryString = new String(decryptedData, EncodingType.UTF_8.getValue());

        // 解析查询字符串为PaymentOrderInfo对象
        // 查询字符串格式：game_orderid=订单号&guid=游戏用户唯一标识&pay_price=商品金额
        PaymentOrderInfo paymentOrderInfo = new PaymentOrderInfo();
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=", 2);
            if (keyValue.length == 2) {
                switch (keyValue[0]) {
                    case "game_orderid":
                        paymentOrderInfo.setGameOrderId(keyValue[1]);
                        break;
                    case "guid":
                        paymentOrderInfo.setGuid(Integer.valueOf(keyValue[1]));
                        break;
                    case "pay_price":
                        paymentOrderInfo.setPayPrice(Double.valueOf(keyValue[1]));
                        break;
                }
            }
        }

        return paymentOrderInfo;
    }
}
