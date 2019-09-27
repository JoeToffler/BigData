package com.xahi.reporteddata.repository;

import com.xahi.reporteddata.model.CardRegister;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-16 11:02
 */
@org.springframework.stereotype.Repository
public interface CardRegisterRepository extends Repository<CardRegister,Long> {
    List<CardRegister> findByIdGreaterThan(Long id);
    List<CardRegister> findAll();
}
