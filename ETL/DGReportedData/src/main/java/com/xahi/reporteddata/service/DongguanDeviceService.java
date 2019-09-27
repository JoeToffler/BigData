package com.xahi.reporteddata.service;

import com.xahi.reporteddata.constants.request.DataCollectSystem;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.request.PoliceCode;
import com.xahi.reporteddata.converter.DongguanRentalAccessTerminalConverter;
import com.xahi.reporteddata.dto.DongguanRentalAccessTerminalDTO;
import com.xahi.reporteddata.model.Device;
import com.xahi.reporteddata.util.data.Filter;
import com.xahi.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.xahi.reporteddata.constants.Symbol.$;

/**
 * @author YangPeng
 * @describe 出租屋门禁终端信息表
 * @date 2019-09-23 17:47
 */
@Service
public class DongguanDeviceService {
    @Autowired
    DongguanRentalAccessTerminalConverter converter;

    @Autowired
    private DongguanCommonService dongguanCommonService;

    private static final String dataType = DataType.XQ_MJZD.code;

    public String reportData(List<Device> list) throws Exception {
        List<DongguanRentalAccessTerminalDTO> dtos = converter.getList(list);
        //数据处理
        List<DongguanRentalAccessTerminalDTO> data = Filter.convert(DongguanRentalAccessTerminalDTO.class, dtos, $.symbol);
        //生成文件名
        String dataFileName = DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, dataType, PoliceCode.G441900.code);
        return dongguanCommonService.reportData(data,dataFileName,dataType);
    }
}
