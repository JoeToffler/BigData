package com.xahi.reporteddata.constants.tenats;

/**
 * @author YangPeng
 * @describe 是否居住登记
 * @date 2019-09-24 10:38
 */
public enum IsRegister {
    /**
     * 是否居住登记
     */
    REGISTER("1"), NOTREGISTER("0");

    public String code;

    IsRegister(String code) {
        this.code = code;
    }
}
