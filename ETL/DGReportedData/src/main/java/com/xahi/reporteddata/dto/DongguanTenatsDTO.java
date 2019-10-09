package com.xahi.reporteddata.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.xahi.reporteddata.constants.ConstantInterface;
import com.xahi.reporteddata.constants.tenats.*;
import com.xahi.reporteddata.util.TimeFormatUtil;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

import static com.xahi.reporteddata.constants.tenats.IsRegister.REGISTER;

/**
 * @author YangPeng
 * @describe 东莞数据平台-出租屋居住人员信息表
 * @date 2019-09-11 11:31
 */
@Setter
@Getter
public class DongguanTenatsDTO {
    /**
     * 编号
     */
    @Excel(name = "BH", width = 15)
    @NotBlank
    @Size(max = 64)
    private String BH = "0";

    /**
     * 姓名
     */
    @Excel(name = "XM", orderNum = "1", width = 15)
    @NotBlank
    @Size(max = 50)
    private String XM;

    /**
     * 性别
     */
    @Excel(name = "XB", orderNum = "2", width = 15)
    @NotBlank
    @Size(max = 10)
    private String XB;

    /**
     * 国籍
     * 缺省"中国"
     */
    @Excel(name = "GJ", orderNum = "3", width = 15)
    @NotBlank
    @Size(max = 50)
    private String GJ = Nationality.CHN.code;

    /**
     * 民族
     */
    @Excel(name = "MZ", orderNum = "4", width = 15)
    @NotBlank
    @Size(max = 50)
    private String MZ = Nation.HAN.description;

    /**
     * 民族代码
     */
    @Excel(name = "MZDM", orderNum = "5", width = 15)
    @NotBlank
    @Size(max = 20)
    private String MZDM = Nation.HAN.code;

    /**
     * 证件类型
     * 缺省“身份证”
     */
    @Excel(name = "ZJLX", orderNum = "6", width = 15)
    @NotBlank
    @Size(max = 50)
    private String ZJLX = IDType.IDCARD.code;

    /**
     * 证件号码
     */
    @Excel(name = "ZJHM", orderNum = "7", width = 15)
    @NotBlank
    @Size(max = 30)
    private String ZJHM;

    /**
     * 出生日期
     * 从身份证号码获取
     */
    @Excel(name = "CSRQ", orderNum = "8", width = 15)
    @NotBlank
    @Size(max = 8)
    private String CSRQ;

    /**
     * 户籍地址名称
     */
    @Excel(name = "HJDZ_DZMC", orderNum = "9", width = 15)
    @NotBlank
    @Size(max = 100)
    private String HJDZ_DZMC;

    /**
     * 单位名称，非必填
     */
    @Excel(name = "DWMC", orderNum = "10", width = 15)
    @Size(max = 100)
    private String DWMC = "";

    /**
     * 单位id，非必填
     */
    @Excel(name = "DWBH", orderNum = "11", width = 15)
    @Size(max = 64)
    private String DWBH = "";

    /**
     * 房屋标准地址
     */
    @Excel(name = "FWDZ", orderNum = "12", width = 15)
    @NotBlank
    @Size(max = 100)
    private String FWDZ = ConstantInterface.NOT_INPUT;

    /**
     * 房屋编号
     */
    @Excel(name = "FWBH", orderNum = "13", width = 15)
    @NotBlank
    @Size(max = 64)
    private String FWBH = ConstantInterface.FWBH_DEFAULT;

    /**
     * 出租屋名称，非必填
     */
    @Excel(name = "CZWMC", orderNum = "15", width = 15)
    @Size(max = 100)
    private String CZWMC;

    /**
     * 居住方式
     * 1：单身居住，2：合伙居住，3：家庭居住，4：集体居住，9：其他
     */
    @Excel(name = "JZFS", orderNum = "16", width = 15)
    @NotBlank
    @Size(max = 1)
    private String JZFS = LiveMode.SINGLE.code;

    /**
     * 入住时间
     */
    @Excel(name = "RZSJ", orderNum = "17", width = 15)
    @NotBlank
    @Size(max = 8)
    private String RZSJ = TimeFormatUtil.toYYYYMMDD(new Date());

    /**
     * 入住状态
     * 1.入住，2.注销（离开）
     */
    @Excel(name = "RZZT", orderNum = "18", width = 15)
    @NotBlank
    @Size(max = 1)
    private String RZZT = CheckInStatus.CHECKIN.code;

    /**
     * 更新日期
     * 除此登记为入住时间，当入住状态为注销，则为离开时间
     */
    @Excel(name = "GXRQ", orderNum = "19", width = 15)
    @NotBlank
    @Size(max = 10)
    private String GXRQ;

    /**
     * 人口类别
     * 缺省为流动人口
     */
    @Excel(name = "RKLB", orderNum = "20", width = 15)
    @NotBlank
    @Size(max = 64)
    private String RKLB = PopulationType.MIGRANT.code;

    /**
     * 是否居住登记
     */
    @Excel(name = "SFJZDJ", orderNum = "21", width = 15)
    @NotBlank
    @Size(max = 64)
    private String SFJZDJ = REGISTER.desc;

    /**
     * 联系电话1
     */
    @Excel(name = "LXDH1", orderNum = "22", width = 15)
    @NotBlank
    @Size(max = 50)
    private String LXDH1 = ConstantInterface.NOT_INPUT;

    /**
     * 联系电话2
     */
    @Excel(name = "LXDH2", orderNum = "23", width = 15)
    @Size(max = 50)
    private String LXDH2;

    /**
     * 紧急联系人_姓名
     */
    @Excel(name = "JJLXR_XM", orderNum = "24", width = 15)
    @Size(max = 50)
    private String JJLXR_XM;

    /**
     * 紧急联系人_联系电话
     */
    @Excel(name = "JJLXR_LXDH", orderNum = "25", width = 15)
    @Size(max = 18)
    private String JJLXR_LXDH;

    /**
     * 与房屋所有人关系
     */
    @Excel(name = "YFZGX_JYQK", orderNum = "26", width = 15)
    @NotBlank
    @Size(max = 255)
    private String YFZGX_JYQK = HomeownersRelationship.TENANT.code;

    /**
     * 备注
     */
    @Excel(name = "BZ", orderNum = "27", width = 15)
    @NotBlank
    @Size(max = 255)
    private String BZ;

    /**
     * 证件正面图片
     */
    @Excel(name = "ZJ_TP_ZM", orderNum = "28", width = 15)
    private String ZJ_TP_ZM;

    /**
     * 证件反面图片
     */
    @Excel(name = "ZJ_TP_FM", orderNum = "29", width = 15)
    private String ZJ_TP_FM;

    /**
     * 头像图片
     */
    @Excel(name = "TX_TP", orderNum = "30", width = 15)
    private String TX_TP;


    @Override
    public String toString() {
        return BH + XM + XB + GJ + MZ + MZDM + ZJLX + ZJHM + CSRQ + HJDZ_DZMC + DWMC + DWBH + FWDZ + FWBH + CZWMC + JZFS + RZSJ + RZZT + GXRQ + RKLB + SFJZDJ + LXDH1 + LXDH2 + JJLXR_XM + JJLXR_LXDH + YFZGX_JYQK + BZ + ZJ_TP_ZM + ZJ_TP_FM + TX_TP;
    }

}
