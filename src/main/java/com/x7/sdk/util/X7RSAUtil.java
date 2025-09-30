package com.x7.sdk.util;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

public class X7RSAUtil {

    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM_SHA256 = "SHA256withRSA";

    private static final String RSA_TRANSFORMATION = "RSA/ECB/PKCS1Padding";

    private static final int KEY_SIZE = 2048;


    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM_SHA256);
        signature.initSign(privateK);
        signature.update(data);
        return Base64.encodeBase64String(signature.sign());
    }


    /**
     * 校验数字签名-使用SHA2withRSA
     *
     * @param data      已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @param sign      数字签名
     * @return
     * @throws Exception
     */
    public static boolean verifyWithSHA2(byte[] data, String publicKey, String sign)
            throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        //SIGNATURE_ALGORITHM
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM_SHA256);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64.decodeBase64(sign));
    }


    /**
     * RSA公钥解密
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        return cipher.doFinal(encryptedData);
    }

    /**
     * RSA公钥分块解密
     *
     * @param encryptedData 加密的Base64字符串（对应请求中的data字段）
     * @param publicKey 公钥
     * @return 解密后的JSON字符串
     * @throws Exception
     */
    public static String decryptDataByPublicKey(String encryptedData, String publicKey) throws Exception {
        // 处理加密串并格式化公钥
        String encryptedStr = encryptedData.replaceAll("\\s", "+");

        // 解析公钥
        byte[] publicKeyBytes = java.util.Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey testpublicKey = keyFactory.generatePublic(keySpec);

        // 计算分块大小
        int partLen = KEY_SIZE / 8;

        // 分块解密
        byte[] encryptedBytes = java.util.Base64.getDecoder().decode(encryptedStr);
        Cipher cipher = Cipher.getInstance(RSA_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, testpublicKey);

        StringBuilder decryptedBuilder = new StringBuilder();
        for (int i = 0; i < encryptedBytes.length; i += partLen) {
            int end = Math.min(encryptedBytes.length, i + partLen);
            byte[] part = cipher.doFinal(encryptedBytes, i, end - i);
            decryptedBuilder.append(new String(part, StandardCharsets.UTF_8));
        }

        return decryptedBuilder.toString();
    }
}
