package com.xahi.reporteddata.converter;

import com.xahi.reporteddata.dto.DongguanRentalAccessRecordsDTO;
import com.xahi.reporteddata.model.Building;
import com.xahi.reporteddata.model.Record;
import com.xahi.reporteddata.repository.BuildingRepository;
import com.xahi.reporteddata.repository.HouseRepository;
import com.xahi.reporteddata.repository.RecordRepository;
import com.xahi.reporteddata.util.TimeFormatUtil;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YangPeng
 * @describe 出租屋门禁开门记录信息表
 * @date 2019-09-18 17:58
 */
@Log
@Component
public class DongguanRentalAccessRecordsConverter {
    @Autowired
    RecordRepository recordRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    HouseRepository houseRepository;

    public DongguanRentalAccessRecordsDTO toDTO(Record record) throws ParseException {
        DongguanRentalAccessRecordsDTO dto = new DongguanRentalAccessRecordsDTO();
        dto.setXXZJBH(record.getId().toString());
        dto.setXM(record.getName());
        dto.setZJHM(record.getIdCard());
        dto.setSJLXDM(record.getEvent());
        if (StringUtils.isNotBlank(record.getPointName())) {
            dto.setMDMC(record.getPointName());
        }

        if (StringUtils.isNotBlank(record.getTime())) {
            dto.setSKSJ(TimeFormatUtil.toYYYYMMDDHHMISS(record.getTime()));
        }
        //通过building_id关联t_housemanagement_building
        Long buildingId = record.getBuildingId();
        if (buildingId != null) {
            Building building = buildingRepository.findByBuildingId(buildingId);
            if (building != null){
                dto.setFWDZ(building.getDetailAddress());
                dto.setFWBH(building.getBuildingCode());
            }
        }

        if (StringUtils.isNotBlank(record.getComment())) {
            dto.setBZ(record.getComment());
        }
        return dto;
    }

    public List<DongguanRentalAccessRecordsDTO> getList(List<Record> all) {
        List<DongguanRentalAccessRecordsDTO> list = new ArrayList<>();
        all.forEach(x -> {
            try {
                list.add(toDTO(x));
            } catch (ParseException e) {
                log.info(e.getLocalizedMessage());
            }
        });
        return list;
    }

}
