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

}
