package com.joe.reporteddata.service;

import com.joe.reporteddata.constants.Symbol;
import com.joe.reporteddata.constants.request.DataCollectSystem;
import com.joe.reporteddata.constants.request.DataType;
import com.joe.reporteddata.constants.request.PoliceCode;
import com.joe.reporteddata.converter.RentalAccessTerminalConverter;
import com.joe.reporteddata.dto.ReportRentalAccessTerminalDTO;
import com.joe.reporteddata.model.Device;
import com.joe.reporteddata.util.data.Filter;
import com.joe.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JoeToffler
 * @describe 出租屋门禁终端信息表
 * @date 2019-09-23 17:47
 */
@Service
public class DeviceService {
    @Autowired
    RentalAccessTerminalConverter converter;

    @Autowired
    private CommonService commonService;

    private static final String dataType = DataType.XQ_MJZD.code;

    public String reportData(List<Device> list) throws Exception {
        List<ReportRentalAccessTerminalDTO> dtos = converter.getList(list);
        //数据处理
        List<ReportRentalAccessTerminalDTO> data = Filter.convert(ReportRentalAccessTerminalDTO.class, dtos, Symbol.$.symbol);
        //生成文件名
        String dataFileName = DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, dataType, PoliceCode.G441900.code);
        return commonService.reportData(data,dataFileName,dataType);
    }
}
