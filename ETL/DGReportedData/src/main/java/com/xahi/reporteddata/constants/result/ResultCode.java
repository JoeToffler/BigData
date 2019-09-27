package com.xahi.reporteddata.constants.result;

/**
 * @author YangPeng
 * @describe 处理结果
 * @date 2019-09-27 15:44
 */
public enum ResultCode {
    /**
     * 0.系统错误；1.处理成功；2.数据校验不通过
     */
    SYSTEMERR("0"), SUCCESS("1"), CHECKNOTPASS("2");

    public String code;

    ResultCode(String code) {
        this.code = code;
    }
}
