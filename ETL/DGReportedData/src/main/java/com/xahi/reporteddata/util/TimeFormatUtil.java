package com.xahi.reporteddata.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YangPeng
 * @describe 时间格式转换工具
 * @date 2019-09-12 9:32
 */
public class TimeFormatUtil {
    /**
     * YYYYMMDD
     */
    public static String toYYYYMMDD(Date date){
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String result= format.format(date);
        return result;
    }

    /**
     * YYYYMMDDHHMISS
     */
    public static String toYYYYMMDDHHMISS(Date date){
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String result= format.format(date);
        return result;
    }

    /**
     * YYYY-MM-DD
     */
    public static String toYYYY_MM_DD(Date date){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result= format.format(date);
        return result;
    }

}
