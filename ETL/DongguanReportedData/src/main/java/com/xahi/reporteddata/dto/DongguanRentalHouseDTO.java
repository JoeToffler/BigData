package com.xahi.reporteddata.dto;

import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author YangPeng
 * @describe 出租房屋信息表
 * @date 2019-09-12 9:21
 */
@Setter
public class DongguanRentalHouseDTO {

    /**
     * 房屋编号，房屋登记的唯一编号（系统创建）
     */
    @Size(max = 100)
    private String FWBH;

    /**
     * 房屋产权证号
     */
    @NotBlank
    @Size(max = 50)
    private String FWCQZH;

    /**
     * 房屋地址，详细全址（标准地址）
     */
    @NotBlank
    @Size(max = 200)
    private String FWDZ;

    /**
     * 标准地址编号
     */
    @NotBlank
    @Size(max = 64)
    private String BZBH;

    /**
     * 出租屋名称，出租屋详细名称（**出租屋），可采用系统建设方的命名
     */
    @NotBlank
    @Size(max = 100)
    private String CZWMC;

    /**
     * 房号，101，102等
     * TODO 说明未写长度，暂定64
     */
    @Size(max = 64)
    private String FJBH;

    /**
     * 备注
     */
    private String BZ;

    /**
     * 采集时间
     * TODO YYYYMMDDHHMISS
     */
    @NotBlank
    @Size(max = 14)
    private String CJSJ;

    /**
     * 房屋所有人1姓名
     */
    @Size(max = 50)
    private String XM1;

    /**
     * 房屋所有人1性别
     */
    @Size(max = 10)
    private String XB1;

    /**
     * 房屋所有人1出生日期
     * TODO 格式YYYYMMDD
     */
    @Size(max = 50)
    private String CSRQ1;

    /**
     * 房屋所有人1民族,民族中文、如汉族
     */
    @Size(max = 50)
    private String MZ1;

    /**
     * 房屋所有人1证件类型，例：居民身份证、居住证、普通护照等
     */
    @Size(max = 50)
    private String ZJLX1;

    /**
     * 房屋所有人1证件号码，配合证件类型使用
     */
    @Size(max = 50)
    private String ZJHM1;

    /**
     * 房屋所有人1联系电话1，固定电话号码、移动电话号码
     */
    @Size(max = 50)
    private String LXDH11;

    /**
     * 房屋所有人1联系电话2，固定电话号码、移动电话号码
     */
    @Size(max = 50)
    private String LXDH12;

    /**
     * 房屋所有人2姓名
     */
    @Size(max = 50)
    private String XM2;

    /**
     * 房屋所有人2证件类型，例：居民身份证、居住证、普通护照等
     */
    @Size(max = 50)
    private String ZJLX2;

    /**
     * 房屋所有人2证件号码，配合证件类型使用
     */
    @Size(max = 30)
    private String ZJHM2;

    /**
     * 房屋所有人2联系电话1，固定电话号码、移动电话号码
     */
    @Size(max = 50)
    private String LXDH21;

    /**
     * 房屋所有人2联系电话2，固定电话号码、移动电话号码
     */
    @Size(max = 50)
    private String LXDH22;


}
