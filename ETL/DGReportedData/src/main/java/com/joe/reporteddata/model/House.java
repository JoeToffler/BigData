package com.joe.reporteddata.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 房屋的数据模型类
 */
@Table(name = "t_housemanagement_house")
@Entity
@Getter
public class House implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_id", unique = true, nullable = false, updatable = false)
    private Long houseId;

    @Column(name = "building_id")
    private Long buildingId;

    /**
     * 房屋名称
     */
    @Column(name = "house_name", length = 50)
    private String houseName;

    /**
     * 房屋地址
     */
    @Column(name = "house_addr")
    private String houseAddr = "未填写";

    /**
     * 房产证号
     */
    @Column(name = "property_no", length = 30)
    private String propertyNo;

    /**
     * 修改时间
     */
    @Column(name = "modify_time", length = 20)
    private String modifyTime;

    /**
     * 增加字段
     */

    /**
     * 房屋编号
     */
    @Column(name = "house_code",length = 64)
    private String houseCode;

    /**
     * 标准地址编号
     */
    @Column(name = "addr_no",length = 64)
    private String addrNo;

}
