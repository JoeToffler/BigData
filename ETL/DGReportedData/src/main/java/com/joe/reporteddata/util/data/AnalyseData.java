package com.joe.reporteddata.util.data;


/**
 * @author JoeToffler
 * @describe
 * @date 2019-09-18 17:07
 */
public class AnalyseData {
    public static int countChar(String text,String c){
        char[] chars = text.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (String.valueOf(aChar).equals(c)){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String text ="340822197304114819$$340822197304114819$未填写$吴尚勇$XXXX$$$$广东省东莞市塘厦镇平山林场路11号502房$1000003$$";
        String c = "$";
        int count = countChar(text, c);
        System.out.println(count);
    }
}
