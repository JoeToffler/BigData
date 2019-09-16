package com.xahi.reporteddata.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 发卡登记信息实体
 * Created by baoyq on 2018/5/02.
 */
@Entity
@Table(name = "t_card_register")
@Getter
public class CardRegister implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 发卡登记信息ID
     */
    @Column(name = "card_reg_id", unique = true, nullable = false, updatable = false)
    private Long cardRegId;

    /**
     * 持卡人姓名
     */
    @Column(name = "people_name", length = 50, nullable = false)
    private String peopleName;

    /**
     * 房屋信息ID
     */
    @Column(name = "house_id", nullable = false)
    private Long houseId;

    /**
     * 持卡人证件号码
     */
    @Column(name = "id_card", length = 50, nullable = false)
    private String cardId;

}