package com.joe.reporteddata.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JoeToffler
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
     * YYYYMMDDHHMISS
     */
    public static String toYYYYMMDDHHMISS(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date1= format.parse(date);
        String result = format.format(date1);
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

    public static void main(String[] args) throws ParseException {
        String a = "2019-07-09 16:18:30";
        System.out.println(toYYYYMMDDHHMISS(new Date()));
        System.out.println(toYYYYMMDDHHMISS("20190926141755"));
    }
}
