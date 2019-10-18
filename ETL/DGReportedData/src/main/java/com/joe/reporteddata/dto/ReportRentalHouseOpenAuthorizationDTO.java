package com.joe.reporteddata.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.joe.reporteddata.constants.ConstantInterface;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author JoeToffler
 * @describe 出租屋门禁开门授权表
 * @date 2019-09-12 9:37
 */
@Getter
@Setter
public class ReportRentalHouseOpenAuthorizationDTO {

    /**
     * 信息主键编号，由视频门禁系统在开卡授权（销卡）时产生的唯一编号
     */
    @Excel(name = "XXZJBH", width = 15)
    @NotBlank
    @Size(max = 30)
    private String XXZJBH = "";

    /**
     * 证件类型     默认为身份证
     */
    @Excel(name = "ZJLX", orderNum = "1", width = 15)
    @Size(max = 50)
    private String ZJLX = "";

    /**
     * 证件号码，配合证件类型使用
     */
    @Excel(name = "ZJHM", orderNum = "2", width = 15)
    @Size(max = 30)
    private String ZJHM = "";

    /**
     * 联系电话，固定电话号码、移动电话号码
     * TODO 增加画面项目
     */
    @Excel(name = "LXDH", orderNum = "3", width = 15)
    @NotBlank
    @Size(max = 18)
    private String LXDH = "未填写";

    /**
     * 授权人_姓名
     */
    @Excel(name = "SQR_XM", orderNum = "4", width = 15)
    @NotBlank
    @Size(max = 50)
    private String SQR_XM = "佚名";

    /**
     * 芯片序列号，通过出租屋视频门禁系统读卡器读出的二代身份证或居住证自身带有的全球唯一编号（芯片号）作为卡号
     * TODO 暂未使用读卡器
     */
    @Excel(name = "XPXLH", orderNum = "5", width = 15)
    @NotBlank
    @Size(max = 50)
    private String XPXLH = "XXXX";

    /**
     * 申请日期
     * TODO（YYYY-MM-DD）
     */
    @Excel(name = "SQRQ", orderNum = "6", width = 15)
    @Size(max = 10)
    private String SQRQ = "";

    /**
     * 停用日期
     * TODO（YYYY-MM-DD）
     */
    @Excel(name = "TYRQ", orderNum = "7", width = 15)
    @Size(max = 10)
    private String TYRQ = "";

    /**
     * 授权期限
     * TODO n5类型尚未确定，暂定String
     */
    @Excel(name = "SQ_QX", orderNum = "8", width = 15)
    @Size(max = 50)
    private String SQ_QX = "";

    /**
     * 房屋标准地址，出租屋的详细地址
     */
    @Excel(name = "FWDZ", orderNum = "9", width = 15)
    @NotBlank
    @Size(max = 100)
    private String FWDZ = ConstantInterface.NOT_INPUT;

    /**
     * 房屋编号，房屋编号，关联房屋信息表FWBH
     */
    @Excel(name = "FWBH", orderNum = "10", width = 15)
    @NotBlank
    @Size(max = 64)
    private String FWBH = ConstantInterface.FWBH_DEFAULT;

    /**
     * 备注
     */
    @Excel(name = "BZ", orderNum = "11", width = 15)
    @NotBlank
    @Size(max = 255)
    private String BZ = "";

    @Override
    public String toString() {
        return XXZJBH + ZJLX + ZJHM + LXDH + SQR_XM + XPXLH + SQRQ + TYRQ + SQ_QX + FWDZ + FWBH + BZ;
    }
}
