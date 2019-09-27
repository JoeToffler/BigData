package com.xahi.reporteddata.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 房屋的数据模型类
 *
 * @author wang.shaohua
 */
@Table(name = "t_app_tenant")
@Entity
@Getter
public class Tenant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tid", unique = true, nullable = false, updatable = false)
    private Long tid;

    /**
     * 房屋id，关联House
     */
    @Column(name = "house_id", length = 20)
    private String houseId;

    /**
     * 名称
     */
    @Column(name = "name", length = 32)
    private String name;

    /**
     * 民族
     */
    @Column(name = "nation", length = 20)
    private String nation;

    /**
     * 租客性别
     */
    @Column(name = "sex", length = 2)
    private String sex;

    /**
     * 身份证
     */
    @Column(name = "idCard", length = 50)
    private String idCard;

    /**
     * 户籍地址
     */
    @Column(name = "register_addr", length = 200)
    private String registerAddr;

    /**
     * 租客开始出租日期
     */
    @Column(name = "start_rent_date", length = 20)
    private String startRentDate;

    /**
     * 租客到期出租日期
     */
    @Column(name = "end_rent_date", length = 20)
    private String endRentDate;

    /**
     * 备注
     */
    @Column(name = "note", length = 500)
    private String note;

    /**
     * 出租状态
     */
    @Column(name = "rent_status", length = 2)
    private String rentStatus;

    /**
     * 修改时间
     */
    @Column(name = "modify_time", length = 50)
    private String modifyTime;

    /**
     * 电话
     */
    @Column(name = "phone", length = 20)
    private String phone;

    /**
     * 紧急联系人
     */
    @Column(name = "emery_contact", length = 50)
    private String emeryContact;

    /**
     * 紧急联系人电话
     */
    @Column(name = "emery_phone", length = 20)
    private String emeryPhone;

    /**
     * 新增字段
     */

    /**
     * 国籍
     */
    @Column(name = "nationality",length = 50)
    private String nationality;

    /**
     * 证件类型
     */
    @Column(name = "id_type",length = 50)
    private String idType;

    /**
     * 单位名称 非必填
     */
    @Column(name = "company_name",length = 100)
    private String companyName;

    /**
     * 单位编号 非必填
     */
    @Column(name = "company_number",length = 100)
    private String companyNumber;

    /**
     * 居住方式
     */
    @Column(name = "live_mode",length = 1)
    private String liveMode;


    /**
     * 人口类别
     */
    @Column(name = "population_type",length = 64)
    private String populationType;

    /**
     * 是否居住登记
     */
    @Column(name = "domicile_registration",length = 64)
    private String domicileRegistration;

    /**
     * 与房屋所有人关系
     */
    @Column(name = "homeowners_relationship")
    private String homeownersRelationship;

}
