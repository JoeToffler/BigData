package com.joe.reporteddata.constants.request;

/**
 * @author JoeToffler
 * @describe 文件类型
 * @date 2019-09-19 10:55
 */
public enum FileType {
    /**
     * 文件类型
     */
    DAT(".dat"), ZIP(".zip");

    public String type;

    FileType(String type) {
        this.type = type;
    }
}
