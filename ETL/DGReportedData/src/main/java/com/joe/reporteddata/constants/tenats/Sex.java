package com.joe.reporteddata.constants.tenats;

/**
 * @author JoeToffler
 * @describe 男/女
 * @date 2019-09-16 10:43
 */
public enum Sex {
    /**
     * 性别
     */
    UNKNOWN("未知的性别", "0"),
    MALE("男", "1"),
    FEMALE("女", "2"),
    UNSPECIFIED("未说明性别", "9");

    public String sex;

    public String code;

    Sex(String sex, String code) {
        this.sex = sex;
        this.code = code;
    }
}
