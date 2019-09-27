package com.xahi.reporteddata.constants.record;

/**
 * @author YangPeng
 * @describe 是否合法
 * @date 2019-09-19 15:10
 */
public enum IsLegal {

    /**
     *
     */
    LEGAL("合法","1"),ILLEGAL("非法","2");
    public String desc;

    public String code;

    IsLegal (String desc, String code){
        this.desc = desc;
        this.code = code;
    }
}
