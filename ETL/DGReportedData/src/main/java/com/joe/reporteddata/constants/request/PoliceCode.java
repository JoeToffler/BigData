package com.joe.reporteddata.constants.request;

/**
 * @author JoeToffler
 * @describe 区域代码
 * @date 2019-09-19 10:19
 */
public enum PoliceCode {
    /**
     *  区域代码
     */
   G441900("北京","441900");


    public String desc;

    public String code;

    PoliceCode(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}
