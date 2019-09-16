package com.xahi.reporteddata.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author YangPeng
 * @describe 出租屋门禁开门授权表
 * @date 2019-09-12 9:37
 */
public class DongguanRentalHouseOpenAuthorization {

    /**
     * 信息主键编号，由视频门禁系统在开卡授权（销卡）时产生的唯一编号
     */
    @NotBlank
    @Size(max = 30)
    private String XXZJBH;

    /**
     * 证件类型
     * TODO 参照附录
     */
    @Size(max = 50)
    private String ZJLX;

    /**
     * 证件号码，配合证件类型使用
     */
    @Size(max = 30)
    private String ZJHM;

    /**
     * 联系电话，固定电话号码、移动电话号码
     * TODO 增加画面项目
     */
    @NotBlank
    @Size(max = 18)
    private String LXDH;

    /**
     * 授权人_姓名
     */
    @NotBlank
    @Size(max = 50)
    private String SQR_XM;

    /**
     * 芯片序列号，通过出租屋视频门禁系统读卡器读出的二代身份证或居住证自身带有的全球唯一编号（芯片号）作为卡号
     * TODO 内部处理
     */
    @NotBlank
    @Size(max = 50)
    private String XPXLH;

    /**
     * 申请日期
     * TODO（YYYY-MM-DD）
     */
    @Size(max = 10)
    private String SQRQ;

    /**
     * 停用日期
     * TODO（YYYY-MM-DD）
     */
    @Size(max = 10)
    private String TYRQ;

    /**
     * 授权期限
     * TODO n5类型尚未确定，暂定String
     */
    @Size(max = 50)
    private String SQ_QX;

    /**
     * 房屋标准地址，出租屋的详细地址
     * TODO 从外部接口获得
     */
    @NotBlank
    @Size(max = 100)
    private String FWDZ;

    /**
     * 房屋编号，房屋编号，关联房屋信息表FWBH
     */
    @NotBlank
    @Size(max = 64)
    private String FWBH;

    /**
     * 备注
     */
    @NotBlank
    @Size(max = 255)
    private String BZ;

}
