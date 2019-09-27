package com.xahi.reporteddata.constants.tenats;

/**
 * @author YangPeng
 * @describe 与房主关系
 * @date 2019-09-16 16:32
 */
public enum HomeownersRelationship {
    /**
     * 英文(描述,编码)
     */
    OWNER("房主本人", "1"),
    KINSFOLK("房主亲属", "2"),
    TENANT("租户", "3"),
    OTHER("其他", "4");

    public String desc;
    public String code;

    HomeownersRelationship(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}
