package com.xahi.reporteddata.constants;

/**
 * @author YangPeng
 * @describe 民族
 * @date 2019-09-16 14:03
 */
public enum Nation {
    /**
     * 类型(描述，编码)
     */
    HAN("汉", "01"), MENGGU("蒙古", "02"), HUI("回", "03"),
    ZANG("藏", "04"), WEIWUER("维吾尔", "05"), MIAO("苗", "06"),
    YI("彝", "07"), ZHUANG("壮", "08"), BUYI("布依", "09"),
    CHAOXIAN("朝鲜", "10"), MAN("满", "11"), DONG("侗", "12"),
    YAO("瑶", "13"), BAI("白", "14"), TUJIA("土家", "15"),
    HANI("哈尼", "16"), KAZAK("哈萨克", "17"), DAI("傣", "18"),
    LI("黎", "19"), LISU("傈僳", "20"), WA("佤", "21"),
    SHE("畲", "22"), GAOSHAN("高山", "23"), LAHU("拉祜", "24"),
    SUI("水", "25"), DONGXIANG("东乡", "26"), NAXI("纳西", "27"),
    JINGPO("景颇", "28"), KEERKEZI("柯尔克孜", "29"), TU("土", "30"),
    DAHANER("达斡尔", "31"), MULAO("仫佬", "32"), QIANG("羌", "33"),
    BULANG("布朗", "34"), SALA("撒拉", "35"), MAONAN("毛南", "36"),
    GELAO("仡佬", "37"), XIBO("锡伯", "38"), ACHANG("阿昌", "39"),
    PUMI("普米", "40"), TAJIKE("塔吉克", "41"), NU("怒", "42"),
    WUZIBIEKE("乌孜别克", "43"), ELUOSI("俄罗斯", "44"), EWENKI("鄂温克", "45"),
    DEANG("德昂", "46"), BONAN("保安", "47"), YUGU("裕固", "48"),
    JING("京", "49"), TATAER("塔塔尔", "50"), DULONG("独龙", "51"),
    ELUNCHUN("鄂伦春", "52"), HEZHEN("赫哲", "53"), MONBA("门巴", "54"),
    LUOBA("珞巴", "55"), JINUO("基诺", "56");

    public String description;

    public String code;

    Nation(String description, String code) {
        this.description = description;
        this.code = code;
    }
}
