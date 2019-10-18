package com.joe.reporteddata.constants.terminal;

/**
 * @author JoeToffler
 * @describe 门禁设备类型
 * @date 2019-09-19 15:43
 */
public enum AccessDeviceType {

    /**
     *
     */
    VIDEO("视频门禁","1"),NOTVIDEO("非视频门禁","2");

    public String desc;

    public String code;

    AccessDeviceType(String desc,String code){
        this.desc=desc;
        this.code=code;
    }
}
