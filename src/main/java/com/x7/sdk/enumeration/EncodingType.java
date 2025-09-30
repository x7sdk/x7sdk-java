package com.x7.sdk.enumeration;

public enum EncodingType {
    UTF_8("UTF-8");

    private final String value;

    EncodingType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
