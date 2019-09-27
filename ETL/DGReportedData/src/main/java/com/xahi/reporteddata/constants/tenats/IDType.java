package com.xahi.reporteddata.constants.tenats;

/**
 * @author YangPeng
 * @describe 证件类型
 * @date 2019-09-16 15:28
 */
public enum IDType {
    /**
     * 证件类型
     */
    IDCARD("身份证", "1"),
    PASSPORT("护照", "2"),
    GANGAOHOMERETURN("港澳同胞回乡证", "3"),
    TAIWANPASSCARD("台湾居民来往大陆通行证", "4"),
    OTHER("其他", "99");

    public String desc;

    public String code;

    IDType(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}
