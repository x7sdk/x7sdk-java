package com.x7.sdk.enumeration;

public enum MethodName {

    // 商城
    X7_MALL_ENTRANCE_QUERY("x7mall.mallEntry", "获取商城入口"),
    X7_MALL_ROLE_QUERY("x7mall.roleQuery", "查询角色信息"),
    X7_MALL_ORDER_NOTIFY("x7mall.orderNotify", "商城订单通知"),
    X7_MALL_ISSUED_PROPS_ENCRYPTION("x7mall.propIssue", "发放道具方法"),
    X7_MALL_QUERY_PROPS_DECRYPTION("x7mall.propQuery", "查询道具方法"),

    // 敏感词
    SENSITIVE_WORLD_CHECK("x7Detection.messageDetect", "敏感词检测方法"),
    SENSITIVE_WORLD_HANDEL_WAY("x7Detection.messageDetectReport", "敏感词处理方式方法"),

    // 游戏角色信息
    X7_GAME_ROLE_INFO_QUERY("common.roleQuery", "查询角色信息"),
    X7_GAME_ROLE_INFO_REPORT("common.roleReport", "上报角色信息"),

    // 开服
    X7_SERVER_LAUNCHER_QUERY("common.serverQuery", "查询开服信息"),
    X7_SERVER_LAUNCHER_NOTIFY("common.serverNotify", "开服通知"),

    // 订单
    X7_ORDER_QUERY("common.orderQuery", "查询订单"),

    // ip白名单
    X7_IP_WHITE_LIST_QUERY("common.ipWhiteListQuery", "查询ip白名单");

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
