package com.joe.reporteddata.converter;

import com.joe.reporteddata.constants.tenats.CheckInStatus;
import com.joe.reporteddata.model.Building;
import com.joe.reporteddata.repository.BuildingRepository;
import com.joe.reporteddata.repository.HouseRepository;
import com.joe.reporteddata.util.DataDictionaryConverter;
import com.joe.reporteddata.util.StringUtil;
import com.joe.reporteddata.util.TimeFormatUtil;
import com.joe.reporteddata.constants.ConstantInterface;
import com.joe.reporteddata.dto.ReportTenetsDTO;
import com.joe.reporteddata.model.House;
import com.joe.reporteddata.model.Tenant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author JoeToffler
 * @describe 出租屋居住人员信息表数据转换
 * @date 2019-09-11 16:44
 */
@Component
public class TenantsConverter {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    public ReportTenetsDTO toDTO(Tenant tenant) {
        ReportTenetsDTO dongguanTenatsDTO = new ReportTenetsDTO();
        //字段核对文档未体现编号属性，先以tenantId替代
        dongguanTenatsDTO.setBH(tenant.getId().toString());
        dongguanTenatsDTO.setXM(tenant.getName());
        dongguanTenatsDTO.setXB(tenant.getSex() + ConstantInterface.WORD_XING);

        //如果国籍无值则赋默认值
        if (StringUtils.isNotBlank(tenant.getNationality())) {
            dongguanTenatsDTO.setGJ(tenant.getNationality());
        }

        dongguanTenatsDTO.setMZ(tenant.getNation() + ConstantInterface.WORD_ZU);
        dongguanTenatsDTO.setMZDM(DataDictionaryConverter.getMZDM(tenant.getNation()));

        //如果证件类型无值则赋默认值
        if (StringUtils.isNotBlank(tenant.getIdType())) {
            dongguanTenatsDTO.setZJLX(tenant.getIdType());
        }

        dongguanTenatsDTO.setZJHM(tenant.getIdCard());
        dongguanTenatsDTO.setCSRQ(StringUtil.getBirthday(tenant.getIdCard()));
        dongguanTenatsDTO.setHJDZ_DZMC(tenant.getRegisterAddr());

        if (StringUtils.isNotBlank(tenant.getCompanyName())) {
            dongguanTenatsDTO.setDWMC(tenant.getCompanyName());
        }
        if (StringUtils.isNotBlank(tenant.getCompanyNumber())) {
            dongguanTenatsDTO.setDWBH(tenant.getCompanyNumber());
        }

        //获取租客租住房屋
        String houseId = ConstantInterface.HOUSEID_DEFAULT;
        if (StringUtils.isNotBlank(tenant.getHouseId())) {
            houseId = tenant.getHouseId();
        }
        House house = houseRepository.findByHouseId(Long.valueOf(houseId));
        Building building = buildingRepository.findByBuildingId(house.getBuildingId());
        if (building != null) {
            String buildingCode = building.getBuildingCode();
            String fwdz = building.getDetailAddress();
            if (StringUtils.isNotBlank(buildingCode)) {
                dongguanTenatsDTO.setFWBH(buildingCode);
            }
            if (StringUtils.isNotBlank(fwdz)) {
                dongguanTenatsDTO.setFWDZ(fwdz);
            }
        }

        if (StringUtils.isNotBlank(house.getHouseName())) {
            dongguanTenatsDTO.setCZWMC(house.getHouseName());
        }

        //增加画面项目，居住方式?默认是多少
        if (StringUtils.isNotBlank(tenant.getLiveMode())) {
            dongguanTenatsDTO.setJZFS(tenant.getLiveMode());
        }

        if (tenant.getStartRentDate() != null) {
            dongguanTenatsDTO.setRZSJ(StringUtil.toYYYYMMDD(tenant.getStartRentDate()));
        }

        String endRentDate = tenant.getEndRentDate();
        if (endRentDate.isEmpty()) {
            dongguanTenatsDTO.setRZZT(CheckInStatus.CHECKIN.code);
        } else {
            dongguanTenatsDTO.setRZZT(CheckInStatus.LEAVE.code);
        }
        Date date = new Date(Long.valueOf(tenant.getModifyTime()));
        dongguanTenatsDTO.setGXRQ(TimeFormatUtil.toYYYY_MM_DD(date));
        //字典类型，参考附件	增加画面项目
        if (StringUtils.isNotBlank(tenant.getPopulationType())) {
            dongguanTenatsDTO.setRKLB(tenant.getPopulationType());
        }

        if (StringUtils.isNotBlank(tenant.getDomicileRegistration())) {
            dongguanTenatsDTO.setSFJZDJ(tenant.getDomicileRegistration());
        }

        if (StringUtils.isNotBlank(tenant.getEmeryPhone())) {
            dongguanTenatsDTO.setLXDH1(tenant.getEmeryPhone());
        }

        dongguanTenatsDTO.setLXDH2("");
        dongguanTenatsDTO.setJJLXR_XM(tenant.getEmeryContact());
        dongguanTenatsDTO.setJJLXR_LXDH("");

        //1－房主本人、2－房主亲属、3－租户、4—其他
        if (StringUtils.isNotBlank(tenant.getHomeownersRelationship())) {
            dongguanTenatsDTO.setYFZGX_JYQK(tenant.getHomeownersRelationship());
        }

        dongguanTenatsDTO.setBZ("");
        dongguanTenatsDTO.setZJ_TP_ZM("");
        dongguanTenatsDTO.setZJ_TP_FM("");
        dongguanTenatsDTO.setTX_TP("");
        return dongguanTenatsDTO;
    }

    public List<ReportTenetsDTO> getList(List<Tenant> all) {
        List<ReportTenetsDTO> list = new ArrayList<>();
        all.forEach(x -> {
            list.add(toDTO(x));
        });
        return list;
    }

}
