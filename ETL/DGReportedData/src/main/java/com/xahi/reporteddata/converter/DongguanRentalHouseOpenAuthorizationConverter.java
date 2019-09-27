package com.xahi.reporteddata.converter;

import com.xahi.reporteddata.dto.DongguanRentalHouseOpenAuthorizationDTO;
import com.xahi.reporteddata.model.CardRegister;
import com.xahi.reporteddata.model.House;
import com.xahi.reporteddata.repository.CardRegisterRepository;
import com.xahi.reporteddata.repository.HouseRepository;
import com.xahi.reporteddata.util.request.UuidRandom;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangPeng
 * @describe 出租屋门禁开门授权表数据转换
 * @date 2019-09-18 17:51
 */
@Component
public class DongguanRentalHouseOpenAuthorizationConverter {

    @Autowired
    CardRegisterRepository cardRegisterRepository;

    @Autowired
    HouseRepository houseRepository;

    public DongguanRentalHouseOpenAuthorizationDTO toDTO(CardRegister cardRegister) {
        DongguanRentalHouseOpenAuthorizationDTO dto = new DongguanRentalHouseOpenAuthorizationDTO();
        dto.setXXZJBH(cardRegister.getCardId());
        dto.setZJHM(cardRegister.getCardId());
        if (StringUtils.isNotBlank(cardRegister.getPhone())) {
            dto.setLXDH(cardRegister.getPhone());
        }
        if (StringUtils.isNotBlank(cardRegister.getPeopleName())) {
            dto.setSQR_XM(cardRegister.getPeopleName());
        }
        Long houseId = cardRegister.getHouseId();
        if (houseId != null){
            dto.setFWBH(cardRegister.getHouseId().toString());
            House house = houseRepository.findByHouseId(houseId);
            dto.setFWDZ(house.getHouseAddr());
        }
        return dto;
    }

    public List<DongguanRentalHouseOpenAuthorizationDTO> getList(List<CardRegister> all) {
        List<DongguanRentalHouseOpenAuthorizationDTO> list = new ArrayList<>();
        all.forEach(x -> {
            list.add(toDTO(x));
        });
        return list;
    }

}
