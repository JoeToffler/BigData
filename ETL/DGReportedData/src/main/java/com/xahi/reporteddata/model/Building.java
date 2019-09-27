package com.xahi.reporteddata.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 楼栋的数据模型类
 *
 * @author wang.shaohua
 */
@Entity
@Table(name = "t_housemanagement_building")
@Getter
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "building_id", unique = true, nullable = false, updatable = false)
    private Long buildingId;

    /**
     * 楼宇编号
     */
    @Column(name = "buiding_code")
    private String buildingCode;

    /**
     * 户籍门(楼)详址
     */
    @Column(name = "detail_address", length = 200)
    private String detailAddress;

}
