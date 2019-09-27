package com.xahi.reporteddata.util;

import org.apache.commons.lang3.StringUtils;

import static com.xahi.reporteddata.constants.tenats.IDNumberLength.EIGHTEEN_ID_CARD;
import static com.xahi.reporteddata.constants.tenats.IDNumberLength.FIFTEEN_ID_CARD;
import static com.xahi.reporteddata.constants.tenats.Sex.FEMALE;
import static com.xahi.reporteddata.constants.tenats.Sex.MALE;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-16 10:13
 */
public class StringUtil {
    /**
     * 通过身份证截取生日
     */
    public String getBrithdayByIDNumber(String idNumber) {
//idNumber.split(5,8);
        return null;
    }

    /**
     * 根据身份证号获取性别
     *
     * @param IDCard
     * @return
     */
    public static String getSex(String IDCard) {
        String sex = "";
        if (StringUtils.isNotBlank(IDCard)) {
            //15位身份证号
            if (IDCard.length() == FIFTEEN_ID_CARD.length) {
                if (Integer.parseInt(IDCard.substring(14, 15)) % 2 == 0) {
                    sex = FEMALE.sex;
                } else {
                    sex = MALE.sex;
                }
                //18位身份证号
            } else if (IDCard.length() == EIGHTEEN_ID_CARD.length) {
                // 判断性别
                if (Integer.parseInt(IDCard.substring(16).substring(0, 1)) % 2 == 0) {
                    sex = FEMALE.sex;
                } else {
                    sex = MALE.sex;
                }
            }
        }
        return sex;
    }

    /**
     * 获取出生日期  yyyyMMdd
     *
     * @param IDCard
     * @return
     */
    public static String getBirthday(String IDCard) {
        String birthday = "";
        String year = "";
        String month = "";
        String day = "";
        if (StringUtils.isNotBlank(IDCard)) {
            //15位身份证号
            if (IDCard.length() == FIFTEEN_ID_CARD.length) {
                // 身份证上的年份(15位身份证为1980年前的)
                year = "19" + IDCard.substring(6, 8);
                //身份证上的月份
                month = IDCard.substring(8, 10);
                //身份证上的日期
                day = IDCard.substring(10, 12);
                //18位身份证号
            } else if (IDCard.length() == EIGHTEEN_ID_CARD.length) {
                // 身份证上的年份
                year = IDCard.substring(6).substring(0, 4);
                // 身份证上的月份
                month = IDCard.substring(10).substring(0, 2);
                //身份证上的日期
                day = IDCard.substring(12).substring(0, 2);
            }
            birthday = year + month + day;
        }
        return birthday;
    }

    /**
     * @param date yy-mm-dd
     * @return YYYYMMDD
     */
    public static String toYYYYMMDD(String date) {
        String[] split = date.split("-");
        return split[0]+split[1]+split[2];
    }

}
