package com.joe.reporteddata.repository;

import com.joe.reporteddata.model.ReportIndex;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author JoeToffler
 * @describe
 * @date 2019-09-24 13:46
 */
@org.springframework.stereotype.Repository
public interface ReportIndexRepository extends Repository<ReportIndex,Integer> {
    List<ReportIndex> findAll();
    ReportIndex save(ReportIndex reportIndex);
}
