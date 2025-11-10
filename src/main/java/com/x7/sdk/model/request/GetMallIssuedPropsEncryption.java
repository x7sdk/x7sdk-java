package com.x7.sdk.model.request;

import com.x7.sdk.model.IssuedProp;
import java.util.List;
import java.util.Objects;

public class GetMallIssuedPropsEncryption {
    /**
     * 请求时间，ISO8601格式 - 必填
     */
    private String reqTime;

    /**
     * 游戏appkey - 必填
     */
    private String appKey;

    /**
     * 游戏端类型，网游为client，H5游戏为h5 - 必填
     */
    private String gameType;


    private String osType;

    /**
     * 发放订单号 - 必填
     */
    private String issueOrderId;

    /**
     * 发放角色ID - 必填
     */
    private String roleId;

    /**
     * 角色所属小号ID - 必填
     */
    private String guid;

    /**
     * 角色所属区服ID - 必填
     */
    private String serverId;

    /**
     * 角色所属区服名称 - 必填
     */
    private String serverName;

    /**
     * 发放时间，格式为ISO8601 - 必填
     */
    private String issueTime;

    /**
     * 邮件标题 - 必填
     */
    private String mailTitle;

    /**
     * 邮件内容 - 必填
     */
    private String mailContent;

    /**
     * 是否为测试发放 - 必填
     */
    private Boolean isTest;

    /**
     * 发放的道具信息 - 必填
     */
    private List<IssuedProp> issuedProps;

    public GetMallIssuedPropsEncryption() {
    }

    public GetMallIssuedPropsEncryption(String reqTime, String appKey, String gameType, String osType, String issueOrderId,
            String roleId, String guid, String serverId, String serverName, String issueTime, String mailTitle,
            String mailContent, Boolean isTest, List<IssuedProp> issuedProps) {
        this.reqTime = reqTime;
        this.appKey = appKey;
        this.gameType = gameType;
        this.osType = osType;
        this.issueOrderId = issueOrderId;
        this.roleId = roleId;
        this.guid = guid;
        this.serverId = serverId;
        this.serverName = serverName;
        this.issueTime = issueTime;
        this.mailTitle = mailTitle;
        this.mailContent = mailContent;
        this.isTest = isTest;
        this.issuedProps = issuedProps;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getIssueOrderId() {
        return issueOrderId;
    }

    public void setIssueOrderId(String issueOrderId) {
        this.issueOrderId = issueOrderId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public Boolean getTest() {
        return isTest;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }

    public List<IssuedProp> getIssuedProps() {
        return issuedProps;
    }

    public void setIssuedProps(List<IssuedProp> issuedProps) {
        this.issuedProps = issuedProps;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GetMallIssuedPropsEncryption)) {
            return false;
        }
        GetMallIssuedPropsEncryption that = (GetMallIssuedPropsEncryption) o;
        return Objects.equals(reqTime, that.reqTime) && Objects.equals(appKey, that.appKey)
                && Objects.equals(gameType, that.gameType) && Objects.equals(osType, that.osType)
                && Objects.equals(issueOrderId, that.issueOrderId) && Objects.equals(roleId,
                that.roleId) && Objects.equals(guid, that.guid) && Objects.equals(serverId,
                that.serverId) && Objects.equals(serverName, that.serverName) && Objects.equals(
                issueTime, that.issueTime) && Objects.equals(mailTitle, that.mailTitle)
                && Objects.equals(mailContent, that.mailContent) && Objects.equals(isTest, that.isTest)
                && Objects.equals(issuedProps, that.issuedProps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqTime, appKey, gameType, osType, issueOrderId, roleId, guid, serverId, serverName,
                issueTime,
                mailTitle, mailContent, isTest, issuedProps);
    }

    @Override
    public String toString() {
        return "GetMallIssuedPropsEncryption{" +
                "reqTime='" + reqTime + '\'' +
                ", appKey='" + appKey + '\'' +
                ", gameType='" + gameType + '\'' +
                ", osType='" + osType + '\'' +
                ", issueOrderId='" + issueOrderId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", guid='" + guid + '\'' +
                ", serverId='" + serverId + '\'' +
                ", serverName='" + serverName + '\'' +
                ", issueTime='" + issueTime + '\'' +
                ", mailTitle='" + mailTitle + '\'' +
                ", mailContent='" + mailContent + '\'' +
                ", isTest=" + isTest +
                ", issuedProps=" + issuedProps +
                '}';
    }
}
