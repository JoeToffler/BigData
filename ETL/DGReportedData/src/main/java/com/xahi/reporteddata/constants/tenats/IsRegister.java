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
    REGISTER("是", "1"), NOTREGISTER("否", "0");

    public String desc;

    public String code;

    IsRegister(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}
