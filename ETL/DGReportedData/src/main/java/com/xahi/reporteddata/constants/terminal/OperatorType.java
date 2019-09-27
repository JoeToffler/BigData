package com.xahi.reporteddata.constants.terminal;

/**
 * @author YangPeng
 * @describe 运营商标识
 * @date 2019-09-19 15:24
 */
public enum OperatorType {

    /**
     *
     */
    TELECOM("电信","1"),MOBILE("移动","2"),
    UNICOM("联通","3"),GLODON("广电","4"),OTHER("其他", "5");

    public String desc;

    public String code;

    OperatorType(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}
