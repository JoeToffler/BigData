package com.joe.reporteddata.converter;

import com.joe.reporteddata.model.Building;
import com.joe.reporteddata.repository.BuildingRepository;
import com.joe.reporteddata.repository.HouseRepository;
import com.joe.reporteddata.dto.ReportRentalHouseDTO;
import com.joe.reporteddata.model.House;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JoeToffler
 * @describe 出租房屋信息表数据转换
 * @date 2019-09-18 17:49
 */
@Component
public class RentalHouseConverter {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    BuildingRepository buildingRepository;

    public ReportRentalHouseDTO toDTO(House house){
        ReportRentalHouseDTO dongguanRentalHouseDTO = new ReportRentalHouseDTO();
        Building building = buildingRepository.findByBuildingId(house.getBuildingId());
        if (building!=null){
            String fwdz = building.getDetailAddress();
            String buildingCode = building.getBuildingCode();
            if (StringUtils.isNotBlank(fwdz)) {
                dongguanRentalHouseDTO.setFWDZ(fwdz);
            }
            if (StringUtils.isNotBlank(buildingCode)){
                dongguanRentalHouseDTO.setFWBH(buildingCode);
            }
        }
        if(StringUtils.isNotBlank(house.getPropertyNo())) {
            dongguanRentalHouseDTO.setFWCQZH(house.getPropertyNo());
        }
        if (StringUtils.isNotBlank(house.getHouseCode())) {
            dongguanRentalHouseDTO.setBZBH(house.getHouseCode());
        }
        if (StringUtils.isNotBlank(house.getHouseName())) {
            dongguanRentalHouseDTO.setCZWMC(house.getHouseName());
        }

        dongguanRentalHouseDTO.setFJBH("");
        dongguanRentalHouseDTO.setBZ("");

        if (StringUtils.isNotBlank(house.getModifyTime())) {
            dongguanRentalHouseDTO.setCJSJ(house.getModifyTime());
        }

        dongguanRentalHouseDTO.setXM1("");
        dongguanRentalHouseDTO.setXB1("");
        dongguanRentalHouseDTO.setCSRQ1("");
        dongguanRentalHouseDTO.setMZ1("");
        dongguanRentalHouseDTO.setZJLX1("");
        dongguanRentalHouseDTO.setZJHM1("");
        dongguanRentalHouseDTO.setLXDH11("");
        dongguanRentalHouseDTO.setLXDH12("");
        dongguanRentalHouseDTO.setXM2("");
        dongguanRentalHouseDTO.setZJLX2("");
        dongguanRentalHouseDTO.setZJHM2("");
        dongguanRentalHouseDTO.setLXDH21("");
        dongguanRentalHouseDTO.setLXDH22("");

        return dongguanRentalHouseDTO;
    }

    public List<ReportRentalHouseDTO> getList(List<House> all) {
        List<ReportRentalHouseDTO> list = new ArrayList<>();
        all.forEach(x -> {
            list.add(toDTO(x));
        });
        return list;
    }

}
