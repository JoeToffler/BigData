package com.joe.reporteddata.converter;

import com.joe.reporteddata.dto.ReportRentalAccessRecordsDTO;
import com.joe.reporteddata.model.Building;
import com.joe.reporteddata.model.Record;
import com.joe.reporteddata.repository.BuildingRepository;
import com.joe.reporteddata.repository.HouseRepository;
import com.joe.reporteddata.util.TimeFormatUtil;
import com.joe.reporteddata.repository.RecordRepository;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JoeToffler
 * @describe 出租屋门禁开门记录信息表
 * @date 2019-09-18 17:58
 */
@Log
@Component
public class RentalAccessRecordsConverter {
    @Autowired
    RecordRepository recordRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    HouseRepository houseRepository;

    public ReportRentalAccessRecordsDTO toDTO(Record record) throws ParseException {
        ReportRentalAccessRecordsDTO dto = new ReportRentalAccessRecordsDTO();
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

    public List<ReportRentalAccessRecordsDTO> getList(List<Record> all) {
        List<ReportRentalAccessRecordsDTO> list = new ArrayList<>();
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
