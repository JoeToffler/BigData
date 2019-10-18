package com.joe.reporteddata.converter;

import com.joe.reporteddata.model.Building;
import com.joe.reporteddata.model.Location;
import com.joe.reporteddata.repository.BuildingRepository;
import com.joe.reporteddata.repository.DeviceRepository;
import com.joe.reporteddata.dto.ReportRentalAccessTerminalDTO;
import com.joe.reporteddata.model.Device;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JoeToffler
 * @describe 出租屋门禁终端信息 数据转换
 * @date 2019-09-18 17:58
 */
@Component
public class RentalAccessTerminalConverter {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    BuildingRepository buildingRepository;

    public ReportRentalAccessTerminalDTO toDTO(Device device) {
        ReportRentalAccessTerminalDTO dto = new ReportRentalAccessTerminalDTO();
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

    public List<ReportRentalAccessTerminalDTO> getList(List<Device> all) {
        List<ReportRentalAccessTerminalDTO> list = new ArrayList<>();
        all.forEach(x -> {
            list.add(toDTO(x));
        });
        return list;
    }
}
