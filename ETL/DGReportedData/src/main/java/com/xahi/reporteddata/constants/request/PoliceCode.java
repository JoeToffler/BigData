package com.xahi.reporteddata.constants.request;

/**
 * @author YangPeng
 * @describe 公安机构代码 对应文档10.3附录C《数据采集系统类型》
 * @date 2019-09-19 10:19
 */
public enum PoliceCode {
    /**
     *  公安机构代码
     */
    G440000("广东省公安厅","440000"),G441900("东莞市公安局","441900"),
    G441950("东莞市公安局莞城分局","441950"),G441951("东莞市公安局东城分局","441951"),
    G441952("东莞市公安局南城分局","441952"),G441953("东莞市公安局万江分局","441953"),
    G441954("东莞市公安局石龙分局","441954"),G441955("东莞市公安局虎门分局","441955"),
    G441956("东莞市公安局中堂分局","441956"),G441957("东莞市公安局望牛墩分局","441957"),
    G441958("东莞市公安局石碣分局","441958"),G441959("东莞市公安局高埗分局","441959"),
    G441960("东莞市公安局麻涌分局","441960"),G441961("东莞市公安局长安分局","441961"),
    G441962("东莞市公安局沙田（虎门港）分局","441962"),G441963("东莞市公安局道滘分局","441963"),
    G441964("东莞市公安局洪梅分局","441964"),G441965("东莞市公安局厚街分局","441965"),
    G441966("东莞市公安局寮步分局","441966"),G441967("东莞市公安局大岭山分局","441967"),
    G441968("东莞市公安局大朗分局","441968"),G441969("东莞市公安局黄江分局","441969"),
    G441970("东莞市公安局樟木头分局","441970"),G441971("东莞市公安局清溪分局","441971"),
    G441972("东莞市公安局塘厦分局","441972"),G441973("东莞市公安局谢岗分局","441973"),
    G441974("东莞市公安局凤岗分局","441974"),G441975("东莞市公安局常平分局","441975"),
    G441976("东莞市公安局桥头分局","441976"),G441977("东莞市公安局横沥分局","441977"),
    G441978("东莞市公安局东坑分局","441978"),G441979("东莞市公安局企石分局","441979"),
    G441980("东莞市公安局石排分局","441980"),G441981("东莞市公安局茶山分局","441981"),
    G441982("东莞市公安局松山湖(生态园)分局","441982");

    public String desc;

    public String code;

    PoliceCode(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}