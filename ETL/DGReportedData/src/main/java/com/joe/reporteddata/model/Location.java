package com.joe.reporteddata.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 位置的数据模型类
 */
@Getter
@Entity
@Table(name = "t_devicemanagement_location")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private Long locationId;

    /**
     * 所属楼id
     */
    @Column(name = "building_id")
    private Long buildingId;
}
