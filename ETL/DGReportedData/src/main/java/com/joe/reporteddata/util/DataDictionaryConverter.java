package com.joe.reporteddata.util;

import com.joe.reporteddata.constants.tenats.Nation;

/**
 * @author JoeToffler
 * @describe 常用数据类型标准及转换
 * @date 2019-09-16 14:00
 */
public class DataDictionaryConverter {

    /**
     * 通过民族获取民族代码
     * @param nation
     * @return
     */
    public static String getMZDM(String nation) {
        Nation[] values = Nation.values();
        if (nation.equals(Nation.HAN.description))return Nation.HAN.code;
        for (Nation value : values) {
            if (nation.equals(value.description)) {
                return value.code;
            }
        }
        //默认返回汉族
        return Nation.HAN.code;
    }

    /**
     * 通过户籍地址判断人口类别
     * @param residenceAddress
     * @return
     */
    public static String getRKLB(String residenceAddress){
        return null;
    }
}
