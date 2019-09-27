package com.xahi.reporteddata.util.request;

import com.xahi.reporteddata.util.TimeFormatUtil;

import java.util.Date;

/**
 * @author YangPeng
 * @describe 数据文件名生成工具
 * @date 2019-09-19 10:43
 */
public class DataFileNameUtil {
    public static String getDataFileName(String collectSystemType, String dataType, String policeCode) {
        StringBuilder sb = new StringBuilder();
        String time = TimeFormatUtil.toYYYYMMDDHHMISS(new Date());
        int random = (int) (Math.random() * 900) + 100;
        StringBuilder append = sb.append(time).append(random).append("_").append(collectSystemType)
                .append("_").append(policeCode).append("_").append(dataType);
        return append.toString();
    }

}
