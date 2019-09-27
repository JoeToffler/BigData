package com.xahi.reporteddata.repository;

import com.xahi.reporteddata.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-23 11:23
 */
public interface RecordRepository extends MongoRepository<Record,String> {
    List<Record> findByIdGreaterThan(String id);
}