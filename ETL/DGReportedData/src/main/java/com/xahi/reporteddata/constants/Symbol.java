package com.xahi.reporteddata.constants;

/**
 * @author YangPeng
 * @describe 数据清洗符号
 * @date 2019-09-17 14:43
 */
public enum Symbol {
    /**
     *
     */
    $("$"), FEED("\\r\\n");
    public String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }
}
