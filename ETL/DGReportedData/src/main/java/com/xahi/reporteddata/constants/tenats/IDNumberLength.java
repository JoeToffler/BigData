package com.xahi.reporteddata.constants.tenats;

/**
 * @author YangPeng
 * @describe 身份证号长度（15位身份证，18位身份证）
 * @date 2019-09-16 10:19
 */
public enum IDNumberLength {
    /**
     * FIFTEEN_ID_CARD 15位
     * EIGHTEEN_ID_CARD 18位
     */
    FIFTEEN_ID_CARD(15),
    EIGHTEEN_ID_CARD(18);

    public int length;

    IDNumberLength(int length) {
        this.length = length;
    }

}
