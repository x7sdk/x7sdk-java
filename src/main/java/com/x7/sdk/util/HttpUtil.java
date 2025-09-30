package com.x7.sdk.util;

import com.x7.sdk.model.response.HttpCommonResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * HTTP 工具类
 */
public class HttpUtil {

    // 基础配置常量
    private static final int DEFAULT_CONNECT_TIMEOUT = 5000;
    private static final int DEFAULT_READ_TIMEOUT = 10000;
    private static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded;charset=UTF-8";


    /**
     * 发送 HTTP 请求（核心方法）
     * @param url 请求URL
     * @param method 请求方法（GET/POST/PUT/DELETE 等）
     * @param body 请求体字节数组
     * @param headers 请求头
     * @return 响应封装对象
     */
    public static HttpCommonResponse makeRequest(String url, String method, byte[] body, Map<String, String> headers) {
        HttpURLConnection connection = null;
        try {
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();

            // 基础配置
            connection.setRequestMethod(method);
            connection.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT);
            connection.setReadTimeout(DEFAULT_READ_TIMEOUT);
            connection.setDoInput(true);
            connection.setUseCaches(false); // 禁用缓存

            // 设置请求头
            if (headers != null && !headers.isEmpty()) {
                Set<Map.Entry<String, String>> entrySet = headers.entrySet();
                for (Map.Entry<String, String> entry : entrySet) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            // 处理请求体
            if (body != null && body.length > 0) {
                connection.setDoOutput(true);
                try (OutputStream os = connection.getOutputStream()) {
                    os.write(body);
                    os.flush();
                }
            }

            // 获取响应
            int statusCode = connection.getResponseCode();
            byte[] responseData = readResponseStream(connection, statusCode);

            return new HttpCommonResponse(responseData, statusCode, null);

        } catch (IOException e) {
            int statusCode = -1;
            if (connection != null) {
                try {
                    statusCode = connection.getResponseCode();
                } catch (IOException ignored) {}
            }
            return new HttpCommonResponse(null, statusCode,
                    new IOException("请求异常 [URL: " + url + ", 方法: " + method + "]", e));
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * 发送 GET 请求
     */
    public static byte[] get(String url) throws IOException {
        HttpCommonResponse response = makeRequest(url, "GET", null, null);
        handleResponseError(response, url);
        return response.getData();
    }

    /**
     * 发送 POST 表单请求
     */
    public static byte[] postForm(String url, Map<String, String> formParams) throws IOException {
        String formBody = encodeFormParams(formParams);
        byte[] body = formBody.getBytes(StandardCharsets.UTF_8);

        Map<String, String> headers = new HashMap<>(1);
        headers.put("Content-Type", CONTENT_TYPE_FORM);

        HttpCommonResponse response = makeRequest(url, "POST", body, headers);
        handleResponseError(response, url);
        return response.getData();
    }

    /**
     * 读取响应流
     */
    private static byte[] readResponseStream(HttpURLConnection connection, int statusCode) throws IOException {
        InputStream inputStream;
        if (statusCode >= 400) {
            inputStream = connection.getErrorStream();
            // 处理可能的空错误流
            if (inputStream == null) {
                inputStream = connection.getInputStream();
            }
        } else {
            inputStream = connection.getInputStream();
        }

        try (InputStream is = inputStream;
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            return outputStream.toByteArray();
        }
    }

    /**
     * 编码表单参数
     */
    private static String encodeFormParams(Map<String, String> params) {
        return params.entrySet().stream()
                .map(entry -> {
                    try {
                        String key = entry.getKey();
                        String value = URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.name());
                        return key + "=" + value;
                    } catch (Exception e) {
                        throw new RuntimeException("参数编码失败: " + entry.getKey(), e);
                    }
                })
                .collect(Collectors.joining("&"));
    }

    /**
     * 处理响应错误（增强错误信息）
     */
    private static void handleResponseError(HttpCommonResponse response, String url) throws IOException {
        if (response.getException() != null) {
            throw new IOException("请求失败 [URL: " + url + ", 状态码: " + response.getStatusCode() + "]",
                    response.getException());
        }

        if (response.getStatusCode() >= 400) {
            String errorMsg = response.asString() != null ? response.asString() : "无错误详情";
            throw new IOException("HTTP 错误 [URL: " + url + ", 状态码: " + response.getStatusCode() + "], 详情: " + errorMsg);
        }
    }
}
