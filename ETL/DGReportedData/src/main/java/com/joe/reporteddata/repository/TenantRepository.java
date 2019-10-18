package com.joe.reporteddata.repository;

import com.joe.reporteddata.model.Tenant;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author JoeToffler
 * @describe
 * @date 2019-09-12 10:11
 */
@org.springframework.stereotype.Repository
public interface TenantRepository extends Repository<Tenant, Integer> {
    List<Tenant> findByIdGreaterThan(Long id);
    List<Tenant> findAll();
}
