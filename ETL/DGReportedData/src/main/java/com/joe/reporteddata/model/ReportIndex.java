package com.joe.reporteddata.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author JoeToffler
 * @describe 上传数据索引表
 * @date 2019-09-24 11:43
 */
@Table(name = "t_query_index")
@Entity
@Getter
@Setter
public class ReportIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 出租屋居住人员索引
     */
    @Column(name = "tenant_id")
    private Long tenantId;

    /**
     * 出租屋房屋信息索引
     */
    @Column(name = "house_id")
    private Long houseId;

    /**
     * 门禁授权索引
     */
    @Column(name = "auth_id")
    private Long authId;

    /**
     * 出租屋门禁开门记录索引
     */
    @Column(name = "record_id")
    private Long recordId;

    /**
     * 出租屋门禁终端信息索引
     */
    @Column(name = "device_id")
    private Long deviceId;
}
