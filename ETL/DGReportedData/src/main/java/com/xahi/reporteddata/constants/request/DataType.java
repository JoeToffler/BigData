package com.xahi.reporteddata.constants.request;

/**
 * @author YangPeng
 * @describe 数据类型   对应文档10.1附录A
 * @date 2019-09-16 15:03
 */
public enum DataType {
    /**
     * 上报表类型，描述及编号
     */
    XQ_FWXX("出租屋居住人员信息", "101"),
    XQ_YZXX("出租屋房屋信息", "102"),
    XQ_MJKKSQXX("出租屋门禁开授权信息", "103"),
    XQ_MJSKXX("出租屋门禁数据信息", "104"),
    XQ_FKXX("出租屋访客信息", "105"),
    XQ_MJZD("出租屋门禁终端信息", "106"),
    XQ_SQTP("出租屋门禁开授权图片信息", "107"),
    XQ_JCTP("出租屋进出记录图片信息", "108");

    public String description;

    public String code;

    DataType(String description, String code) {
        this.description = description;
        this.code = code;
    }
}
