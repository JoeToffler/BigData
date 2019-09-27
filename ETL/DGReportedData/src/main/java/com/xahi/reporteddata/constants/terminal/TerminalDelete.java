package com.xahi.reporteddata.constants.terminal;

/**
 * @author YangPeng
 * @describe 删除标识   1：删除，0：未删除
 * @date 2019-09-26 14:31
 */
public enum TerminalDelete {
    /**
     *
     */
    DELETE("1"), NOTDELETE("0");

    public String code;

    TerminalDelete(String code) {
        this.code = code;
    }
}
