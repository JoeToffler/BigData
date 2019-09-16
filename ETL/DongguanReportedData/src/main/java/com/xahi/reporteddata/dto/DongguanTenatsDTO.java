package com.xahi.reporteddata.dto;

import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author YangPeng
 * @describe 东莞数据平台-出租屋居住人员信息表
 * @date 2019-09-11 11:31
 */
@Setter
public class DongguanTenatsDTO {
    /**
     * 编号
     * TODO tenantId?
     */
    @NotBlank
    @Size(max = 64)
    private String BH;

    /**
     * 姓名
     */
    @NotBlank
    @Size(max = 50)
    private String XM;

    /**
     * 性别
     */
    @NotBlank
    @Size(max = 10)
    private String XB;

    /**
     * 国籍
     * TODO 增加画面项目 字典项请查看附录D
     */
    @NotBlank
    @Size(max = 50)
    private String GJ;

    /**
     * 民族
     */
    @NotBlank
    @Size(max = 50)
    private String MZ;

    /**
     * 民族代码
     * TODO 上传时数码转换 字典类型，参考附录D
     */
    @NotBlank
    @Size(max = 20)
    private String MZDM;

    /**
     * 证件类型
     * TODO 增加画面项目 字典类型，参考附录D
     */
    @NotBlank
    @Size(max = 50)
    private String ZJLX;

    /**
     * 证件号码
     */
    @NotBlank
    @Size(max = 30)
    private String ZJHM;

    /**
     * 出生日期
     * 从身份证号码获取
     */
    @NotBlank
    @Size(max = 8)
    private String CSRQ;

    /**
     * 户籍地址名称
     */
    @NotBlank
    @Size(max = 100)
    private String HJDZ_DZMC;

    /**
     * 单位名称，非必填
     */
    @Size(max = 100)
    private String DWMC;

    /**
     * 单位id，非必填
     */
    @Size(max = 64)
    private String DWBH;

    /**
     * 房屋标准地址
     */
    @NotBlank
    @Size(max = 100)
    private String FWDZ;

    /**
     * 房屋编号
     * TODO 房屋编号，关联房屋信息表FWBH
     */
    @NotBlank
    @Size(max = 64)
    private String FWBH;

    /**
     * 标准地址编码
     * TODO 从分局获取出租屋的标准地址编码
     */
    @NotBlank
    @Size(max = 64)
    private String BZDZ;

    /**
     * 出租屋名称，非必填
     */
    @Size(max = 100)
    private String CZWMC;

    /**
     * 居住方式
     * 1：单身居住，2：合伙居住，3：家庭居住，4：集体居住，9：其他
     */
    @NotBlank
    @Size(max = 1)
    private String JZFS;

    /**
     * 入住时间
     * TODO 格式YYYYMMDD
     */
    @NotBlank
    @Size(max = 8)
    private String RZSJ;

    /**
     * 入住状态
     * 1.入住，2.注销（离开）
     */
    @NotBlank
    @Size(max = 1)
    private String RZZT;

    /**
     * 更新日期
     * 除此登记为入住时间，当入住状态为注销，则为离开时间
     */
    @NotBlank
    @Size(max = 10)
    private String GXRQ;

    /**
     * 人口类别
     * TODO 字典类型，参考附件
     */
    @NotBlank
    @Size(max = 64)
    private String RKLB;

    /**
     * 是否居住登记
     * TODO 增加画面项目
     */
    @NotBlank
    @Size(max = 64)
    private String SFJZDJ;

    /**
     * 联系电话1
     */
    @NotBlank
    @Size(max = 50)
    private String LXDH1;

    /**
     * 联系电话2
     */
    @Size(max = 50)
    private String LXDH2;

    /**
     * 紧急联系人_姓名
     */
    @Size(max = 50)
    private String JJLXR_XM;

    /**
     * 紧急联系人_联系电话
     */
    @Size(max = 18)
    private String JJLXR_LXDH;

    /**
     * 与房屋所有人关系
     * TODO 按照:1－房主本人、2－房主亲属、3－租户、4—其他的标准填写。
     */
    @NotBlank
    @Size(max = 255)
    private String YFZGX_JYQK;

    /**
     * 备注
     */
    @NotBlank
    @Size(max = 255)
    private String BZ;

    /**
     * 证件正面图片
     */
    private byte[] ZJ_TP_ZM;

    /**
     * 证件反面图片
     */
    private byte[] ZJ_TP_FM;

    /**
     * 头像图片
     */
    private byte[] TX_TP;

}
