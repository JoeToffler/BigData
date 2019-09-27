package com.xahi.reporteddata.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-19 10:20
 */
@Getter
@Setter
public class PoliceCodeEnumDTO {

    @Excel(name = "code", width = 15)
    private String code;

    @Excel(name = "desc", orderNum = "1", width = 30)
    private String desc;

    public String makeEnum(){
        return "G"+code+("(\""+desc+"\",\""+code+"\")");
    }
}
