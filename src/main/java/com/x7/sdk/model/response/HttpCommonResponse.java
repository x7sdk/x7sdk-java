package com.x7.sdk.model.response;

import java.nio.charset.StandardCharsets;

public class HttpCommonResponse {
    private final byte[] data;
    private final int statusCode;
    private final Exception exception;

    public HttpCommonResponse(byte[] data, int statusCode, Exception exception) {
        this.data = data;
        this.statusCode = statusCode;
        this.exception = exception;
    }

    public byte[] getData() {
        return data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Exception getException() {
        return exception;
    }

    /**
     * 转为 UTF-8 字符串
     */
    public String asString() {
        if (data == null) {
            return null;
        }
        return new String(data, StandardCharsets.UTF_8);
    }

    /**
     * 判断响应是否成功（2xx 状态码）
     */
    public boolean isSuccess() {
        return statusCode >= 200 && statusCode < 300;
    }
}
