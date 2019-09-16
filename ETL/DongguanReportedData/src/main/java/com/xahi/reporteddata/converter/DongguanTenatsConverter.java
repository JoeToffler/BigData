package com.xahi.reporteddata.converter;

import com.xahi.reporteddata.dto.DongguanTenatsDTO;
import com.xahi.reporteddata.model.House;
import com.xahi.reporteddata.model.Tenant;
import com.xahi.reporteddata.repository.HouseRepository;
import com.xahi.reporteddata.repository.TenantRepository;
import com.xahi.reporteddata.util.StringUtil;
import com.xahi.reporteddata.util.TimeFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YangPeng
 * @describe 数据转换
 * @date 2019-09-11 16:44
 */
public class DongguanTenatsConverter {

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private HouseRepository houseRepository;

    public DongguanTenatsDTO toDTO() {
        List<Tenant> all = tenantRepository.findAll();
        List<DongguanTenatsDTO> list = new ArrayList<>();

        all.forEach(x -> {
            DongguanTenatsDTO dongguanTenatsDTO = new DongguanTenatsDTO();
            //字段核对文档未体现编号属性，先以tenantId替代
            dongguanTenatsDTO.setBH(x.getId().toString());
            dongguanTenatsDTO.setXM(x.getName());
            dongguanTenatsDTO.setXB(x.getSex());
            //增加画面项目 字典项请查看附录D
            dongguanTenatsDTO.setGJ("国籍");
            dongguanTenatsDTO.setMZ(x.getNation());
            //允许为空的值空串，直接用无字符替代
            //上传时数码转换 字典类型，参考附录D
            dongguanTenatsDTO.setMZDM("民族代码");
            //增加画面项目 字典类型，参考附录D
            dongguanTenatsDTO.setZJLX("证件类型");
            dongguanTenatsDTO.setZJHM(x.getIdCard());
            dongguanTenatsDTO.setCSRQ(StringUtil.getBirthday(x.getIdCard()));
            dongguanTenatsDTO.setHJDZ_DZMC(x.getRegisterAddr());
            dongguanTenatsDTO.setDWMC("");
            dongguanTenatsDTO.setDWBH("");
            //获取租客租住房屋
            House house = houseRepository.findByHouseId(Long.valueOf(x.getHouseId()));
            dongguanTenatsDTO.setFWDZ(house.getHouseAddr());
            dongguanTenatsDTO.setFWBH(house.getHouseId().toString());
            //从分局获取出租屋的标准地址编码
            dongguanTenatsDTO.setBZDZ("地址编码");
            dongguanTenatsDTO.setCZWMC("");
            //增加画面项目
            dongguanTenatsDTO.setJZFS("1");
            dongguanTenatsDTO.setRZSJ(StringUtil.toYYYYMMDD(x.getStartRentDate()));
            String endRentDate = x.getEndRentDate();
            if (endRentDate.isEmpty()) {
                dongguanTenatsDTO.setRZZT("1");
            } else {
                dongguanTenatsDTO.setRZZT("2");
            }
            Date date = new Date(Long.valueOf(x.getModifyTime()));
            dongguanTenatsDTO.setGXRQ(TimeFormatUtil.toYYYY_MM_DD(date));
            //字典类型，参考附件	增加画面项目
            dongguanTenatsDTO.setRKLB("人口类别");
            //增加画面项目
            dongguanTenatsDTO.setSFJZDJ("是");
            dongguanTenatsDTO.setLXDH1(x.getEmeryPhone());
            dongguanTenatsDTO.setLXDH2("");
            dongguanTenatsDTO.setJJLXR_XM(x.getEmeryContact());
            dongguanTenatsDTO.setJJLXR_LXDH("");
            //1－房主本人、2－房主亲属、3－租户、4—其他
            dongguanTenatsDTO.setYFZGX_JYQK("与房主关系");
            dongguanTenatsDTO.setBZ("");
            byte[] i = new byte[10];
            dongguanTenatsDTO.setZJ_TP_ZM(i);
            dongguanTenatsDTO.setZJ_TP_FM(i);
            dongguanTenatsDTO.setTX_TP(i);
        });
        return null;

    }

    public static void main(String[] args) {
        Long timestamp = 1563952871837L;
        Date date = new Date(timestamp);
        System.out.println(date);
    }
}
