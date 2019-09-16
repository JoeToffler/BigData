package com.xahi.reporteddata.repository;

import com.xahi.reporteddata.model.House;
import org.springframework.data.repository.Repository;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-16 11:02
 */
@org.springframework.stereotype.Repository
public interface HouseRepository extends Repository<House,Long> {
    House findByHouseId(Long houseId);
}
