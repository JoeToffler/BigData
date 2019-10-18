package com.joe.reporteddata.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.joe.reporteddata.constants.terminal.*;
import com.joe.reporteddata.util.TimeFormatUtil;
import com.joe.reporteddata.constants.ConstantInterface;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author JoeToffler
 * @describe 出租屋门禁终端信息
 * @date 2019-09-18 17:49
 */
@Getter
@Setter
public class ReportRentalAccessTerminalDTO {

    /**
     * 编号   主键
     */
    @Excel(name = "BH", width = 15)
    @NotBlank
    @Size(max = 64)
    private String BH;

    /**
     * 门禁名称
     */
    @Excel(name = "lockName", orderNum = "1", width = 15)
    @NotBlank
    @Size(max = 512)
    private String lockName;

    /**
     * 是否在线(每天) 1：在线，0不在
     */
    @Excel(name = "isOnline", orderNum = "2", width = 15)
    @NotBlank
    @Size(max = 10)
    private String isOnline;

    /**
     * 状态(每天)   1启用，2停用
     */
    @Excel(name = "status", orderNum = "3", width = 15)
    @NotBlank
    @Size(max = 1)
    private String status;

    /**
     * 运营商标识    运营商标识：1电信，2：移动，3：联通，4:广电，5:其他
     */
    @Excel(name = "yys_id", orderNum = "4", width = 15)
    @NotBlank
    @Size(max = 1)
    private String yys_id = OperatorType.UNICOM.code;

    /**
     * 安装日期 格式YYYYMMDD
     */
    @Excel(name = "azrq", orderNum = "5", width = 15)
    @NotBlank
    @Size(max = 8)
    private String azrq = TimeFormatUtil.toYYYYMMDD(new Date());

    /**
     * 门禁设备序列号
     */
    @Excel(name = "lock_seq", orderNum = "6", width = 15)
    @NotBlank
    @Size(max = 100)
    private String lock_seq;

    /**
     * 门禁设备类型   1：视频门禁，2：非视频门禁
     */
    @Excel(name = "lock_type", orderNum = "7", width = 15)
    @NotBlank
    @Size(max = 50)
    private String lock_type = AccessDeviceType.VIDEO.code;

    /**
     * 是否注销     1：注销，0未注销
     */
    @Excel(name = "sfzx", orderNum = "8", width = 15)
    @NotBlank
    @Size(max = 1)
    private String sfzx = IsCancel.NOTCANCEL.code;

    /**
     * 门禁机型号
     */
    @Excel(name = "sbb", orderNum = "9", width = 15)
    @NotBlank
    @Size(max = 64)
    private String sbb = ConstantInterface.SBB_DEFAULT;

    /**
     * 品牌？
     */

    /**
     * 地图坐标
     */
    @Excel(name = "dtzb_lat", orderNum = "10", width = 15)
    @Size(max = 10)
    private String dtzb_lat;

    /**
     * 地图坐标
     */
    @Excel(name = "dtzb_lng", orderNum = "11", width = 15)
    @Size(max = 10)
    private String dtzb_lng;

    /**
     * 标准地址
     */
    @Excel(name = "BZDZ", orderNum = "12", width = 15)
    @NotBlank
    @Size(max = 100)
    private String BZDZ = ConstantInterface.NOT_INPUT;

    /**
     * 房屋编号     房屋编号，关联房屋信息表FWBH
     */
    @Excel(name = "FWBH", orderNum = "13", width = 15)
    @NotBlank
    @Size(max = 64)
    private String FWBH = ConstantInterface.FWBH_DEFAULT;

    /**
     * 门禁类型     1：出租屋，2：小区
     */
    @Excel(name = "Type", orderNum = "14", width = 15)
    @NotBlank
    @Size(max = 1)
    private String type = AccessType.RENTAL.code;

    /**
     * 删除标识     1：删除，0：未删除
     */
    @Excel(name = "DeleteFlag", orderNum = "14", width = 15)
    @NotBlank
    @Size(max = 1)
    private String deleteF = TerminalDelete.NOTDELETE.code;

    @Override
    public String toString() {
        return BH + lockName + isOnline + status + yys_id + azrq + lock_seq + lock_type + sfzx + sbb + dtzb_lat + dtzb_lng + BZDZ + FWBH + type + deleteF;
    }
}
