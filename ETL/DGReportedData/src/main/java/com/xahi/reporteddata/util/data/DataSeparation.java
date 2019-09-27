package com.xahi.reporteddata.util.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-19 17:28
 */
public class DataSeparation {
    private static final int standard = 2;

    /**
     * 当超过1000000条时进行数据分离
     */
    public static List<List> restult = new ArrayList<>();
    private static <T> List<T> dataRecursive(List<T> list) {
        if (list.size() > standard) {
            List<T> ts = list.subList(0, standard);
            List recu = list.subList(standard,list.size());
            restult.add(ts);
            dataRecursive(recu);
            return ts;
        } else {
            restult.add(list);
            return list;
        }
    }

    static List ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) {
        dataRecursive(ints);
        restult.forEach(x -> {
            x.forEach(y -> {
                System.out.println(y);
            });
            System.out.println("_____________");
        });
    }
}
