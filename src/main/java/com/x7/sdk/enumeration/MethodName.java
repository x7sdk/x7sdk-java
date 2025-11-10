package com.x7.sdk.enumeration;

public enum MethodName {

    X7_MALL_ENTRANCE_QUERY("x7mall.mallEntry", "获取商城入口"),
    X7_MALL_ROLE_QUERY("x7mall.roleQuery", "查询角色信息"),
    X7_MALL_ORDER_NOTIFY("x7mall.orderNotify", "商城订单通知"),
    X7_MALL_ISSUED_PROPS_ENCRYPTION("x7mall.propIssue", "发放道具方法"),
    X7_MALL_QUERY_PROPS_DECRYPTION("x7mall.propQuery", "查询道具方法");

    private final String methodName;
    private final String description;

    MethodName(String methodName, String description) {
        this.methodName = methodName;
        this.description = description;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getDescription() {
        return description;
    }
}
