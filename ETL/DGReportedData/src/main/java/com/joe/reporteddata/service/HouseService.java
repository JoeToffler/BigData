package com.joe.reporteddata.service;

import com.joe.reporteddata.constants.Symbol;
import com.joe.reporteddata.constants.request.DataCollectSystem;
import com.joe.reporteddata.constants.request.DataType;
import com.joe.reporteddata.constants.request.PoliceCode;
import com.joe.reporteddata.converter.RentalHouseConverter;
import com.joe.reporteddata.dto.ReportRentalHouseDTO;
import com.joe.reporteddata.model.House;
import com.joe.reporteddata.util.data.Filter;
import com.joe.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JoeToffler
 * @describe
 * @date 2019-09-23 17:48
 */
@Service
public class HouseService {

    @Autowired
    private RentalHouseConverter converter;

    @Autowired
    private CommonService commonService;

    private static final String dataType = DataType.XQ_YZXX.code;

    public String reportData(List<House> list) throws Exception {
        List<ReportRentalHouseDTO> dtos = converter.getList(list);
        //数据处理
        List<ReportRentalHouseDTO> data = Filter.convert(ReportRentalHouseDTO.class, dtos, Symbol.$.symbol);
        //生成文件名
        String dataFileName = DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, dataType, PoliceCode.G441900.code);
        return commonService.reportData(data,dataFileName,dataType);
    }
}
