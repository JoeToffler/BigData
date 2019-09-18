package com.xahi.reporteddata.util.data;


/**
 * @author YangPeng
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
        String text =
                "111153$黄帅$男性$中国$汉族$01$1$142730199702050759$19970205$山西省夏县水头镇大张村二组北七街08号$$$郭杜北街25号$330$6F8B17FE-FA4F-84C6-E053-0A2B612B84C6$$1$20190726$2$2019-07-26$3$是$未登记$$$$3$$$$";

        String c = "$";
        int count = countChar(text, c);
        System.out.println(count);
    }
}
