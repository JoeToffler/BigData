package com.joe.reporteddata.constants.request;

/**
 * @author JoeToffler
 * @describe 上报数据系统类型
 * @date 2019-09-16 15:09
 */
public enum DataCollectSystem {
    /**
     * 英文简写(代码类型，代码)
     */
    COMMUNITY("小区", "125"),
    OTHER("其他", "999");

    public String type;

    public String code;

    DataCollectSystem(String type, String code) {
        this.type = type;
        this.code = code;
    }
}
