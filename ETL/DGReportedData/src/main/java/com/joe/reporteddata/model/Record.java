package com.joe.reporteddata.model;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Transient;
import java.io.Serializable;

@Getter
@Document(collection = "m_doorwaymanagement_record")
public class Record implements Serializable {

    @Id
    private Long id;

    /**
     * ping
     */
    @Field("pin")
    private String pin;

    /**
     * 卡号
     */
    @Field("cardno")
    private String cardNo;

    /**
     * 事件
     */
    @Field("event")
    private String event;

    /**
     * 时间
     */
    @Indexed
    @Field("time")
    private String time;

    /**
     * 出入状态
     */
    @Indexed
    @Field("inoutstatus")
    private String inOutStatus = "1";

    /**
     * 验证类型
     */
    @Field("verifytype")
    @Indexed
    private String verifyType;

    /**
     * 记录id
     */
    @Field("recordid")
    private String recordId;

    /**
     * 姓名
     */
    @Indexed
    @Field("name")
    private String name;

    /**
     * 证件类型(境外人，中国人)
     */
    @Field("cardtype")
    private String cardType = "1";

    /**
     * 证件号
     */
    @Indexed
    @Field("idcard")
    private String idCard;

    /**
     * 人的卡号
     */
    @Field("peoplecard")
    private String peopleCard;

    /**
     * 门的位置
     */
    @Indexed
    @Field("doorlocation")
    private String doorLocation;

    /**
     * 关注人群
     */
    @Field("focuspeople")
    private String focusPeople;

    /**
     * 照片地址
     */
    @Field("photourl")
    private String photoUrl;

    /**
     * 经度
     */
    @Field("longitude")
    private String longitude;

    /**
     * 纬度
     */
    @Field("latitude")
    private String latitude;

    /**
     * 时间
     */
    @Field("createTime")
    private String createTime;

    /**
     * 门的编号
     */
    @Field("eventaddr")
    private String eventaddr;

    /**
     * 设备序列号
     */
    @Field("sn")
    private String sn;

    /**
     * 是否黑名单
     */
    @Field("blacklist")
    private String blacklist;

    /**
     * 设备名称
     */
    @Transient
    private String deviceName;

    /**
     * 设备类型
     */
    @Transient
    private String deviceType;

    /**
     * 性别
     */
    @Indexed
    @Field("sex")
    private String sex;

    /**
     * 电话
     */
    @Indexed
    @Field("phone")
    private String phone;

    /**
     * 视频设备编码
     */
    @Field("video")
    private String video;

    /**
     * 小区ID
     */
    @Indexed
    @Field("commid")
    private Long commId;

    /**
     * 楼栋ID
     */
    @Indexed
    @Field("buildingid")
    private Long buildingId;

    /**
     * 单元ID
     */
    @Indexed
    @Field("unitid")
    private Long unitId;

    /**
     * 新增字段
     */

    /**
     * 门点名称
     */
    @Field("point_name")
    private String pointName = "未录入";

    /**
     * 备注
     */
    @Field("comment")
    private String comment = "备注";
}
