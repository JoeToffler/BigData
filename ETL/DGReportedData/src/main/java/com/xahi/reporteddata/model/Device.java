package com.xahi.reporteddata.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 设备数据模型类
 *
 * @author wang.shaohua
 */
@Entity
@Table(name = "t_devicemanagement_device")
@Getter
public class Device implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 设备名称
     */
    @Column(name = "device_name", length = 50)
    private String deviceName;

    /**
     * 在线状态
     */
    @Column(name = "online", columnDefinition = "tinyint default 1")
    private Integer online;

    /**
     * 启用禁用状态
     */
    @Column(name = "enable_status", columnDefinition = "tinyint default 1")
    private Integer enableStatus;

    /**
     * 设备序列号
     */
    @Column(name = "device_serial", length = 50)
    private String deviceSerial;

    /**
     * 设备型号
     */
    @Column(name = "device_model", length = 20)
    private String deviceModel;

    /**
     * 设备类型
     */
    @Column(name = "device_type", length = 50)
    private String deviceType;

    /**
     * 位置uid
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "locationId")
    private Location location;

    /**
     * 新增字段
     */

    /**
     * 安装日期
     */
    @Column(name = "install_date",length = 8,nullable = false)
    private String installDate;

    /**
     * 是否注销
     */
    @Column(name = "is_cancel",length = 1,nullable = false)
    private String isCancel;

    /**
     * 门禁类型
     */
    @Column(name = "access_type",length = 1,nullable = false)
    private String accessType;

}
