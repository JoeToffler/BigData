package com.xahi.reporteddata.util.enumutils;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-18 11:51
 */
public class DynamicTest {
    public static void main(String[] args) {
        System.out.println("原始数据：");
        for (Season season : Season.values()) {
            System.out.println(season);
        }
        System.out.println("-----------------------------");
        DynamicEnumUtils.addEnum(Season.class, "WINTER", new Class[] {
                java.lang.String.class, SeasonPattern.class }, new Object[] {
                "winter", SeasonPattern.SNOW });
        System.out.println("添加后的数据：");
        for (Season season : Season.values()) {
            System.out.println(season);
        }
        System.out.println("-----------------------------");
        Season season = Season.valueOf("WINTER");
        System.out.println("新添加的枚举类型可以正常使用：");
        System.out.println(season.name());
        System.out.println(season.getKey());
        System.out.println(season.getSeasonPattern());
    }
}
