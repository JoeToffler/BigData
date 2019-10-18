package com.joe.reporteddata.util.enumutils;

/**
 * @author JoeToffler
 * @describe 季节(测试枚举)
 * @date 2019-09-18 11:51
 */
public enum Season {
    /**
     *
     */
    SPRING("spring", SeasonPattern.BEAR), SUMMER("summer", SeasonPattern.HOT), AUTUMN("autumn", SeasonPattern.WITHERED);

    private final String key;
    // 季节特征
    private final SeasonPattern sp;

    private Season(String key, SeasonPattern sp) {
        this.key = key;
        this.sp = sp;
    }

    public String getKey() {
        return this.key;
    }

    public SeasonPattern getSeasonPattern() {
        return sp;
    }

}
