package com.joe.reporteddata.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.joe.reporteddata.util.TimeFormatUtil;
import com.joe.reporteddata.constants.ConstantInterface;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author JoeToffler
 * @describe 出租房屋信息表
 * @date 2019-09-12 9:21
 */
@Setter
@Getter
public class ReportRentalHouseDTO {

    /**
     * 房屋编号，房屋登记的唯一编号（系统创建）
     * FWBH为    t_housemanagement_building.building_code
     */
    @Excel(name = "FWBH", width = 15)
    @Size(max = 100)
    private String FWBH = ConstantInterface.FWBH_DEFAULT;

    /**
     * 房屋产权证号
     */
    @Excel(name = "FWCQZH", orderNum = "1", width = 15)
    @NotBlank
    @Size(max = 50)
    private String FWCQZH = ConstantInterface.NOT_INPUT;

    /**
     * 房屋地址，详细全址（标准地址）
     */
    @Excel(name = "FWDZ", orderNum = "2", width = 15)
    @NotBlank
    @Size(max = 200)
    private String FWDZ = ConstantInterface.NOT_INPUT;

    /**
     * 标准地址编号
     */
    @Excel(name = "BZBH", orderNum = "3", width = 15)
    @NotBlank
    @Size(max = 64)
    private String BZBH = ConstantInterface.NOT_INPUT;

    /**
     * 出租屋名称，出租屋详细名称（**出租屋），可采用系统建设方的命名
     */
    @Excel(name = "CZWMC", orderNum = "4", width = 15)
    @NotBlank
    @Size(max = 100)
    private String CZWMC = ConstantInterface.NOT_INPUT;

    /**
     * 房号，101，102等
     */
    @Excel(name = "FJBH", orderNum = "5", width = 15)
    @Size(max = 64)
    private String FJBH;

    /**
     * 备注
     */
    @Excel(name = "BZ", orderNum = "6", width = 15)
    private String BZ;

    /**
     * 采集时间     如果数据库没有数据则先使用当前时间
     */
    @Excel(name = "CJSJ", orderNum = "7", width = 15)
    @NotBlank
    @Size(max = 14)
    private String CJSJ = TimeFormatUtil.toYYYYMMDDHHMISS(new Date());

    /**
     * 房屋所有人1姓名
     */
    @Excel(name = "XM1", orderNum = "8", width = 15)
    @Size(max = 50)
    private String XM1;

    /**
     * 房屋所有人1性别
     */
    @Excel(name = "XB1", orderNum = "9", width = 15)
    @Size(max = 10)
    private String XB1;

    /**
     * 房屋所有人1出生日期
     */
    @Excel(name = "CSRQ1", orderNum = "10", width = 15)
    @Size(max = 50)
    private String CSRQ1;

    /**
     * 房屋所有人1民族,民族中文、如汉族
     */
    @Excel(name = "MZ1", orderNum = "11", width = 15)
    @Size(max = 50)
    private String MZ1;

    /**
     * 房屋所有人1证件类型，例：居民身份证、居住证、普通护照等
     */
    @Excel(name = "ZJLX1", orderNum = "12", width = 15)
    @Size(max = 50)
    private String ZJLX1;

    /**
     * 房屋所有人1证件号码，配合证件类型使用
     */
    @Excel(name = "ZJHM1", orderNum = "13", width = 15)
    @Size(max = 50)
    private String ZJHM1;

    /**
     * 房屋所有人1联系电话1，固定电话号码、移动电话号码
     */
    @Excel(name = "LXDH11", orderNum = "14", width = 15)
    @Size(max = 50)
    private String LXDH11;

    /**
     * 房屋所有人1联系电话2，固定电话号码、移动电话号码
     */
    @Excel(name = "LXDH12", orderNum = "15", width = 15)
    @Size(max = 50)
    private String LXDH12;

    /**
     * 房屋所有人2姓名
     */
    @Excel(name = "XM2", orderNum = "16", width = 15)
    @Size(max = 50)
    private String XM2;

    /**
     * 房屋所有人2证件类型，例：居民身份证、居住证、普通护照等
     */
    @Excel(name = "ZJLX2", orderNum = "17", width = 15)
    @Size(max = 50)
    private String ZJLX2;

    /**
     * 房屋所有人2证件号码，配合证件类型使用
     */
    @Excel(name = "ZJHM2", orderNum = "18", width = 15)
    @Size(max = 30)
    private String ZJHM2;

    /**
     * 房屋所有人2联系电话1，固定电话号码、移动电话号码
     */
    @Excel(name = "LXDH21", orderNum = "19", width = 15)
    @Size(max = 50)
    private String LXDH21;

    /**
     * 房屋所有人2联系电话2，固定电话号码、移动电话号码
     */
    @Excel(name = "LXDH22", orderNum = "20", width = 15)
    @Size(max = 50)
    private String LXDH22;

    @Override
    public String toString() {
        return FWBH + FWCQZH + FWDZ + BZBH + CZWMC + FJBH + BZ + CJSJ + XM1 + XB1 + CSRQ1 + MZ1 + ZJLX1 + ZJHM1 + LXDH11 + LXDH12 + XM2 + ZJLX2 + ZJHM2 + LXDH21 + LXDH22;
    }
}
