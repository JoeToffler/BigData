package com.xahi.reporteddata.repository;

import com.xahi.reporteddata.model.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * @author YangPeng
 * @describe
 * @date 2019-09-12 10:11
 */
@org.springframework.stereotype.Repository
public interface TenantRepository extends Repository<Tenant, Integer> {
    Page<Tenant> findAll(Pageable pageable);

    List<Tenant> findAll();
}
