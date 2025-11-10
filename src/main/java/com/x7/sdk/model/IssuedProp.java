package com.x7.sdk.model;

import java.util.Objects;

public class IssuedProp {
    /**
     * 道具编码 - 必填
     */
    private String propCode;

    /**
     * 道具名称 - 必填
     */
    private String propName;

    /**
     * 道具数量 - 必填
     */
    private String propQuantity;

    public IssuedProp() {
    }

    public IssuedProp(String propCode, String propName, String propQuantity) {
        this.propCode = propCode;
        this.propName = propName;
        this.propQuantity = propQuantity;
    }

    public String getPropCode() {
        return propCode;
    }

    public void setPropCode(String propCode) {
        this.propCode = propCode;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropQuantity() {
        return propQuantity;
    }

    public void setPropQuantity(String propQuantity) {
        this.propQuantity = propQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IssuedProp)) {
            return false;
        }
        IssuedProp that = (IssuedProp) o;
        return Objects.equals(propCode, that.propCode) && Objects.equals(propName, that.propName)
                && Objects.equals(propQuantity, that.propQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propCode, propName, propQuantity);
    }

    @Override
    public String toString() {
        return "IssuedProp{" +
                "propCode='" + propCode + '\'' +
                ", propName='" + propName + '\'' +
                ", propQuantity='" + propQuantity + '\'' +
                '}';
    }
}
