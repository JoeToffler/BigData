package com.xahi.reporteddata.constants.tenats;

/**
 * @author YangPeng
 * @describe 居住方式
 * @date 2019-09-16 16:09
 */
public enum LiveMode {
    /**
     * 居住类型(居住描述,对应码)
     */
    SINGLE("单身居住", "1"),
    JOINT("合伙居住", "2"),
    FAMILY("家庭居住", "3"),
    COLLECTIVE("集体居住", "4"),
    OTHER("其他", "9");

    public String desc;

    public String code;

    LiveMode(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}
