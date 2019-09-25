package com.xahi.reporteddata.util.data;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.xahi.reporteddata.constants.Symbol.$;
import static com.xahi.reporteddata.constants.Symbol.FEED;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-17 10:30
 */
public class Filter {

    /**
     * 数据项由统一分隔符$分开,换行符号统一为\r\n
     *
     * @param clazz   解析类
     * @param ts      解析数据
     * @param c       替换字符
     * @param lc      换行替换的字符
     * @param lastKey 最后key的name
     * @return 解析后的数据
     */
    public static <T> List<T> convert(Class clazz, List<T> ts, String c, String lc, String lastKey) {
        ArrayList<T> list = new ArrayList<>();
        String set = "set";
        String get = "get";
        ts.forEach(t -> {
            Method[] methods = clazz.getMethods();
            Arrays.stream(methods).forEach(method -> {
                if (method.getName().startsWith(set)) {
                    try {
                        Method methodGet = clazz.getMethod(StringUtils.replace(method.getName(), set, get), null);
                        String getStr = "";
                        //如果报NullPointException则getStr=""
                        try {
                            getStr = methodGet.invoke(t, null).toString();
                            //判断是否有字符需要替换
                            getStr = replaceSymbol(getStr);
                        } catch (NullPointerException e) {
                        }
                        if (!method.getName().contains(lastKey)) {
                            getStr = getStr + c;
                            method.invoke(t, getStr);
                        } else {
                            getStr = getStr + c + lc;
                            method.invoke(t, getStr);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            list.add(t);
        });
        return list;
    }


    /**
     * 数据项的内容中原有的分隔符”$”，需由“\$”替换，数据项目中的换行符统一由\\r\\n替代
     *
     * @param input 输入内容
     * @return
     */
    private static String replaceSymbol(String input) {
        if (input.contains($.name()) || input.contains(FEED.symbol)) {
            String output = input.replace($.name(), "\\$");
            output.replace(FEED.symbol, "\\\\r\\\\n");
            return output;
        }
        return input;
    }

}