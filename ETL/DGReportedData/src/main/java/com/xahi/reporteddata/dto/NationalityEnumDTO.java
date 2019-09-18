package com.xahi.reporteddata.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-18 9:41
 */
@Setter
@Getter
public class NationalityEnumDTO {

    @Excel(name = "code",width = 15)
    private String code;

    @Excel(name = "desc",orderNum = "1",width = 15)
    private String desc;

    public String makeEnum(){
        return code+("(\""+desc+"\")");
    }
}
