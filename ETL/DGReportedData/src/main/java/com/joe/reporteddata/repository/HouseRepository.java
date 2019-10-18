package com.joe.reporteddata.repository;

import com.joe.reporteddata.model.House;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author JoeToffler
 * @describe
 * @date 2019-09-16 11:02
 */
@org.springframework.stereotype.Repository
public interface HouseRepository extends Repository<House,Long> {
    List<House> findByIdGreaterThan(Long id);
    House findByHouseId(Long houseId);
    List<House> findAll();
}
