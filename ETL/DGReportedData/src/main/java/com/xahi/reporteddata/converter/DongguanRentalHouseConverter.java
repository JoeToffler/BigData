package com.xahi.reporteddata.converter;

import com.xahi.reporteddata.dto.DongguanRentalHouseDTO;
import com.xahi.reporteddata.model.Building;
import com.xahi.reporteddata.model.House;
import com.xahi.reporteddata.repository.BuildingRepository;
import com.xahi.reporteddata.repository.HouseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangPeng
 * @describe 出租房屋信息表数据转换
 * @date 2019-09-18 17:49
 */
@Component
public class DongguanRentalHouseConverter {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    BuildingRepository buildingRepository;

    public DongguanRentalHouseDTO toDTO(House house){
        DongguanRentalHouseDTO dongguanRentalHouseDTO = new DongguanRentalHouseDTO();
        Building building = buildingRepository.findByBuildingId(house.getBuildingId());
        if (building!=null){
            String buildingCode = building.getBuildingCode();
            if (StringUtils.isNotBlank(buildingCode)){
                dongguanRentalHouseDTO.setFWBH(buildingCode);
            }
        }
        if(StringUtils.isNotBlank(house.getPropertyNo())) {
            dongguanRentalHouseDTO.setFWCQZH(house.getPropertyNo());
        }
        if (StringUtils.isNotBlank(house.getHouseAddr())) {
            dongguanRentalHouseDTO.setFWDZ(house.getHouseAddr());
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

    public List<DongguanRentalHouseDTO> getList(List<House> all) {
        List<DongguanRentalHouseDTO> list = new ArrayList<>();
        all.forEach(x -> {
            list.add(toDTO(x));
        });
        return list;
    }

}
