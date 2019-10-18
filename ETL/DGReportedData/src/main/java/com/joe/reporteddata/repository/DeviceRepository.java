package com.joe.reporteddata.repository;

import com.joe.reporteddata.model.Device;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author JoeToffler
 * @describe
 * @date 2019-09-16 11:02
 */
@org.springframework.stereotype.Repository
public interface DeviceRepository extends Repository<Device,Long> {
    List<Device> findByIdGreaterThan(Integer id);
    List<Device> findAll();
}
