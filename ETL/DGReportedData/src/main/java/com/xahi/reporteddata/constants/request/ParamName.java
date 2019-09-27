package com.xahi.reporteddata.constants.request;

/**
 * @author YangPeng
 * @describe 参数key
 * @date 2019-09-23 15:02
 */
public enum ParamName {
    /**
     *
     */
    DATATYPE("dataType"),MD5("md5"), ACCESSID("accessId"), RANDOM("random"),
    ACCESSTOKEN("accessToken"),BATCHNUMBER("batchNumber"),FILEDATA("filedata");

    public String desc;

    ParamName(String desc) {
        this.desc = desc;
    }
}
