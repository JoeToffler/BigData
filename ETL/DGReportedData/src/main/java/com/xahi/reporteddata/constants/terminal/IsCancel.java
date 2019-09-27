package com.xahi.reporteddata.constants.terminal;

/**
 * @author YangPeng
 * @describe 是否注销
 * @date 2019-09-19 15:35
 */
public enum IsCancel {

    /**
     *
     */

    CANCEL("注销","1"),NOTCANCEL("未注销","0");

    public String desc;

    public String code;

    IsCancel(String desc,String code){
        this.desc=desc;
        this.code=code;
    }
}
