package com.xahi.reporteddata.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 房屋的数据模型类
 *
 * @author wang.shaohua
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

    /**
     * 房屋名称
     */
    @Column(name = "house_name", length = 50)
    private String houseName;

    /**
     * 房屋地址
     */
    @Column(name = "house_addr")
    private String houseAddr;

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

}
