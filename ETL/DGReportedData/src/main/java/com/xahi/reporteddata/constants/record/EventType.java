package com.xahi.reporteddata.constants.record;

/**
 * @author YangPeng
 * @describe 事件类型
 * @date 2019-09-19 15:08
 */
public enum EventType {
    /**
     *
     */
    IN("进门", "1"), OUT("出门", "2");

    public String desc;

    public String code;

    EventType(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}
