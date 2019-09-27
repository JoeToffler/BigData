package com.xahi.reporteddata.repository;

import com.xahi.reporteddata.model.Building;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-26 15:04
 */
@org.springframework.stereotype.Repository
public interface BuildingRepository extends Repository<Building,Integer> {
    Building findByBuildingId(Long buildingId);
    List<Building> findAll();
}
