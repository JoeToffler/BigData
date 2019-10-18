package com.joe.reporteddata.converter;

import com.joe.reporteddata.model.Building;
import com.joe.reporteddata.repository.BuildingRepository;
import com.joe.reporteddata.repository.CardRegisterRepository;
import com.joe.reporteddata.repository.HouseRepository;
import com.joe.reporteddata.dto.ReportRentalHouseOpenAuthorizationDTO;
import com.joe.reporteddata.model.CardRegister;
import com.joe.reporteddata.model.House;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JoeToffler
 * @describe 出租屋门禁开门授权表数据转换
 * @date 2019-09-18 17:51
 */
@Component
public class RentalHouseOpenAuthorizationConverter {

    @Autowired
    CardRegisterRepository cardRegisterRepository;

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    BuildingRepository buildingRepository;

    public ReportRentalHouseOpenAuthorizationDTO toDTO(CardRegister cardRegister) {
        ReportRentalHouseOpenAuthorizationDTO dto = new ReportRentalHouseOpenAuthorizationDTO();
        dto.setXXZJBH(cardRegister.getCardId());
        dto.setZJHM(cardRegister.getCardId());
        if (StringUtils.isNotBlank(cardRegister.getPhone())) {
            dto.setLXDH(cardRegister.getPhone());
        }
        if (StringUtils.isNotBlank(cardRegister.getPeopleName())) {
            dto.setSQR_XM(cardRegister.getPeopleName());
        }
        Long houseId = cardRegister.getHouseId();
        if (houseId != null) {
            dto.setFWBH(cardRegister.getHouseId().toString());
            House house = houseRepository.findByHouseId(houseId);
            Long buildingId = house.getBuildingId();
            if (buildingId != null) {
                Building building = buildingRepository.findByBuildingId(buildingId);
                String detailAddress = building.getDetailAddress();
                if (building != null&&StringUtils.isNotBlank(detailAddress)) {
                    dto.setFWDZ(detailAddress);
                }
            }
        }
        return dto;
    }

    public List<ReportRentalHouseOpenAuthorizationDTO> getList(List<CardRegister> all) {
        List<ReportRentalHouseOpenAuthorizationDTO> list = new ArrayList<>();
        all.forEach(x -> {
            list.add(toDTO(x));
        });
        return list;
    }

}
