package com.xahi.reporteddata.converter;

import com.xahi.reporteddata.dto.DongguanRentalAccessTerminalDTO;
import com.xahi.reporteddata.model.Building;
import com.xahi.reporteddata.model.Device;
import com.xahi.reporteddata.model.Location;
import com.xahi.reporteddata.repository.BuildingRepository;
import com.xahi.reporteddata.repository.DeviceRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangPeng
 * @describe 出租屋门禁终端信息 数据转换
 * @date 2019-09-18 17:58
 */
@Component
public class DongguanRentalAccessTerminalConverter {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    BuildingRepository buildingRepository;

    public DongguanRentalAccessTerminalDTO toDTO(Device device) {
        DongguanRentalAccessTerminalDTO dto = new DongguanRentalAccessTerminalDTO();
        dto.setBH(device.getId().toString());
        dto.setLockName(device.getDeviceName());
        dto.setIsOnline(device.getOnline().toString());
        dto.setStatus(device.getEnableStatus().toString());
        if (StringUtils.isNotBlank(device.getInstallDate())) {
            dto.setAzrq(device.getInstallDate());
        }
        dto.setLock_seq(device.getDeviceSerial());
        dto.setLock_type(device.getDeviceType());
        if (StringUtils.isNotBlank(device.getIsCancel())) {
            dto.setSfzx(device.getIsCancel());
        }
        if (StringUtils.isNotBlank(device.getDeviceModel())) {
            dto.setSbb(device.getDeviceModel());
        }
        Location location = device.getLocation();
        if (location != null) {
            Long buildingId = location.getBuildingId();
            if (buildingId != null) {
                Building building = buildingRepository.findByBuildingId(buildingId);
                if (building != null) {
                    dto.setFWBH(building.getBuildingCode());
                    dto.setBZDZ(building.getDetailAddress());
                }
            }
        }
        if (StringUtils.isNotBlank(device.getAccessType())) {
            dto.setType(device.getAccessType());
        }
        return dto;
    }

    public List<DongguanRentalAccessTerminalDTO> getList(List<Device> all) {
        List<DongguanRentalAccessTerminalDTO> list = new ArrayList<>();
        all.forEach(x -> {
            list.add(toDTO(x));
        });
        return list;
    }
}
