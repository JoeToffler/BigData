package com.xahi.reporteddata.constants.terminal;

/**
 * @author YangPeng
 * @describe 门禁类型
 * @date 2019-09-19 15:39
 */
public enum AccessType {
    /**
     *
     */

    RENTAL("出租屋","1"),COMMUNITY("小区","2");

    public String desc;

    public String code;

    AccessType(String desc,String code){
        this.desc=desc;
        this.code=code;
    }
}
