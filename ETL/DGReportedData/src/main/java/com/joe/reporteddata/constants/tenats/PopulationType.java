package com.joe.reporteddata.constants.tenats;

/**
 * @author JoeToffler
 * @describe 人口类别
 * @date 2019-09-16 15:13
 */
public enum  PopulationType {
    /**
     * 类别（描述，代码）
     * 常住人口：指的是东莞户籍人口
     * 流动人口：指的是中国公民，非东莞户籍人口
     */
    INHABITANT("常住人口","1"),
    FOREIGN("境外人口","2"),
    MIGRANT("流动人口","3"),
    NOHOME("无户人员","4");

    public String desc;

    public String code;

    PopulationType(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}