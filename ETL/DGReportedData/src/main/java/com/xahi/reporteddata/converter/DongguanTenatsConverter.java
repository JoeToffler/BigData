package com.xahi.reporteddata.converter;

import com.xahi.reporteddata.constants.CheckInStatus;
import com.xahi.reporteddata.constants.ConstantInterface;
import com.xahi.reporteddata.constants.IDType;
import com.xahi.reporteddata.constants.LiveMode;
import com.xahi.reporteddata.dto.DongguanTenatsDTO;
import com.xahi.reporteddata.model.House;
import com.xahi.reporteddata.model.Tenant;
import com.xahi.reporteddata.repository.HouseRepository;
import com.xahi.reporteddata.repository.TenantRepository;
import com.xahi.reporteddata.util.DataDictionaryConverter;
import com.xahi.reporteddata.util.StringUtil;
import com.xahi.reporteddata.util.TimeFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YangPeng
 * @describe 数据转换
 * @date 2019-09-11 16:44
 */
@Component
public class DongguanTenatsConverter {

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private HouseRepository houseRepository;

    public DongguanTenatsDTO toDTO(Tenant tenant) {
        DongguanTenatsDTO dongguanTenatsDTO = new DongguanTenatsDTO();
        //字段核对文档未体现编号属性，先以tenantId替代
        dongguanTenatsDTO.setBH(tenant.getId().toString());
        dongguanTenatsDTO.setXM(tenant.getName());
        dongguanTenatsDTO.setXB(tenant.getSex() + ConstantInterface.WORD_XING);

        dongguanTenatsDTO.setGJ(tenant.getNationality());

        dongguanTenatsDTO.setMZ(tenant.getNation() + ConstantInterface.WORD_ZU);
        dongguanTenatsDTO.setMZDM(DataDictionaryConverter.getMZDM(tenant.getNation()));
        dongguanTenatsDTO.setZJLX(IDType.IDCARD.code);
        dongguanTenatsDTO.setZJHM(tenant.getIdCard());
        dongguanTenatsDTO.setCSRQ(StringUtil.getBirthday(tenant.getIdCard()));
        dongguanTenatsDTO.setHJDZ_DZMC(tenant.getRegisterAddr());

        dongguanTenatsDTO.setDWMC("");
        dongguanTenatsDTO.setDWBH("");
        //获取租客租住房屋
        House house = houseRepository.findByHouseId(Long.valueOf(tenant.getHouseId()));
        dongguanTenatsDTO.setFWDZ(house.getHouseAddr());

        //房屋编号，关联房屋信息表FWBH，外部接口?
        dongguanTenatsDTO.setFWBH(house.getHouseId().toString());
        //从分局获取出租屋的标准地址编码，外部接口?
        dongguanTenatsDTO.setBZDZ("标准地址编码");

        dongguanTenatsDTO.setCZWMC(house.getHouseName());
        //增加画面项目，居住方式?默认是多少
        dongguanTenatsDTO.setJZFS(tenant.getLiveMode());
        dongguanTenatsDTO.setRZSJ(StringUtil.toYYYYMMDD(tenant.getStartRentDate()));
        String endRentDate = tenant.getEndRentDate();
        if (endRentDate.isEmpty()) {
            dongguanTenatsDTO.setRZZT(CheckInStatus.CHECKIN.code);
        } else {
            dongguanTenatsDTO.setRZZT(CheckInStatus.LEAVE.code);
        }
        Date date = new Date(Long.valueOf(tenant.getModifyTime()));
        dongguanTenatsDTO.setGXRQ(TimeFormatUtil.toYYYY_MM_DD(date));
        //字典类型，参考附件	增加画面项目
        //需要逻辑判断？
        dongguanTenatsDTO.setRKLB("人口类别");
        //增加画面项目？
        dongguanTenatsDTO.setSFJZDJ("是");
        dongguanTenatsDTO.setLXDH1(tenant.getEmeryPhone());
        dongguanTenatsDTO.setLXDH2("");
        dongguanTenatsDTO.setJJLXR_XM(tenant.getEmeryContact());
        dongguanTenatsDTO.setJJLXR_LXDH("");
        //1－房主本人、2－房主亲属、3－租户、4—其他
        dongguanTenatsDTO.setYFZGX_JYQK(tenant.getHomeownersRelationship());

        dongguanTenatsDTO.setBZ("");
        dongguanTenatsDTO.setZJ_TP_ZM("");
        dongguanTenatsDTO.setZJ_TP_FM("");
        dongguanTenatsDTO.setTX_TP("");
        return dongguanTenatsDTO;
    }

    public List<DongguanTenatsDTO> getList() {
        List<Tenant> all = tenantRepository.findAll();
        List<DongguanTenatsDTO> list = new ArrayList<>();
        all.forEach(x -> {
            list.add(toDTO(x));
        });
        return list;
    }

}
