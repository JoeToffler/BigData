package com.xahi.reporteddata.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.xahi.reporteddata.constants.ConstantInterface;
import com.xahi.reporteddata.constants.record.EventType;
import com.xahi.reporteddata.util.TimeFormatUtil;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author YangPeng
 * @describe 出租屋门禁开门记录信息表
 * @date 2019-09-18 17:48
 */
@Getter
@Setter
public class DongguanRentalAccessRecordsDTO {

    /**
     * 信息主键编号
     */
    @Excel(name = "XXZJBH",width = 15)
    @Size(max = 30)
    private String XXZJBH;

    /**
     * 芯片序列号  通过门禁系统读卡器读出的二代身份证或居住证自身带有的全球唯一编号（芯片号）作为卡号 。
     * 暂定全球36位码
     * TODO 现在未用到读卡器,默认"XXXX"
     */
    @Excel(name = "XPXLH",orderNum = "1",width = 15)
    @NotBlank
    @Size(max = 50)
    private String XPXLH = "XXXX";

    /**
     * 姓名
     */
    @Excel(name = "XM",orderNum = "2",width = 15)
    @NotBlank
    @Size(max = 50)
    private String XM;

    /**
     * 证件号码 与住户信息相结合
     */
    @Excel(name = "ZJHM",orderNum = "3",width = 15)
    @NotBlank
    @Size(max = 30)
    private String ZJHM;

    /**
     * 事件类型代码
     */
    @Excel(name = "SJLXDM",orderNum = "4",width = 15)
    @NotBlank
    @Size(max = 1)
    private String SJLXDM = EventType.OUT.code;

    /**
     * 门点名称 当次刷卡的门、点名称（由出租屋视频门禁建设单位进行统一命名（中文名），规则：小区出入口为：“大门X”，楼内出入口为“X栋X座X号门”等。）
     */
    @Excel(name = "MDMC",orderNum = "5",width = 15)
    @NotBlank
    @Size(max = 100)
    private String MDMC = "门点名称";

    /**
     * 刷卡时间 默认当前时间
     */
    @Excel(name = "SKSJ",orderNum = "6",width = 15)
    @NotBlank
    @Size(max = 14)
    private String SKSJ = TimeFormatUtil.toYYYYMMDDHHMISS(new Date());

    /**
     * 房屋标准地址
     */
    @Excel(name = "FWDZ",orderNum = "7",width = 15)
    @NotBlank
    @Size(max = 100)
    private String FWDZ = ConstantInterface.NOT_INPUT;

    /**
     * 房屋编号
     */
    @Excel(name = "FWBH",orderNum = "8",width = 15)
    @NotBlank
    @Size(max = 64)
    private String FWBH = ConstantInterface.FWBH_DEFAULT;

    /**
     * 备注
     */
    @Excel(name = "BZ",orderNum = "9",width = 15)
    @Size(max = 255)
    private String BZ;

    @Override
    public String toString() {
        return XXZJBH + XPXLH + XM + ZJHM + SJLXDM + MDMC + SKSJ + FWDZ + FWBH + BZ;
    }
}
