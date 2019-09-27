package com.xahi.reporteddata.repository;

import com.xahi.reporteddata.model.ReportIndex;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-24 13:46
 */
@org.springframework.stereotype.Repository
public interface ReportIndexRepository extends Repository<ReportIndex,Integer> {
    /**
     * @return
     */
    List<ReportIndex> findAll();

    ReportIndex save(ReportIndex reportIndex);
}
