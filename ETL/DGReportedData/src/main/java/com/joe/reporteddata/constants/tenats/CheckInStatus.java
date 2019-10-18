package com.joe.reporteddata.constants.tenats;

/**
 * @author JoeToffler
 * @describe 入住状态
 * @date 2019-09-16 16:19
 */
public enum CheckInStatus {
    /**
     * 类型(描述,编码)
     */
    CHECKIN("入住","1"),
    LEAVE("离开","2");
    public String desc;
    public String code;
    CheckInStatus(String desc,String code){
        this.desc=desc;
        this.code=code;
    }
}
