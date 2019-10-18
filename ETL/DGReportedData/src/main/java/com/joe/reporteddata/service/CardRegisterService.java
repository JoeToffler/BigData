package com.joe.reporteddata.service;

import com.joe.reporteddata.constants.Symbol;
import com.joe.reporteddata.constants.request.DataCollectSystem;
import com.joe.reporteddata.constants.request.DataType;
import com.joe.reporteddata.constants.request.PoliceCode;
import com.joe.reporteddata.converter.RentalHouseOpenAuthorizationConverter;
import com.joe.reporteddata.dto.ReportRentalHouseOpenAuthorizationDTO;
import com.joe.reporteddata.model.CardRegister;
import com.joe.reporteddata.util.data.Filter;
import com.joe.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JoeToffler
 * @describe 出租屋门禁开门授权表
 * @date 2019-09-23 17:49
 */
@Service
public class CardRegisterService {

    @Autowired
    private RentalHouseOpenAuthorizationConverter converter;

    @Autowired
    private CommonService commonService;

    private static final String dataType = DataType.XQ_MJKKSQXX.code;

    public String reportData(List<CardRegister> list) throws Exception {
        List<ReportRentalHouseOpenAuthorizationDTO> dtos = converter.getList(list);
        //数据处理
        List<ReportRentalHouseOpenAuthorizationDTO> data = Filter.convert(ReportRentalHouseOpenAuthorizationDTO.class, dtos, Symbol.$.symbol);
        //生成文件名
        String dataFileName = DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, dataType, PoliceCode.G441900.code);
        return commonService.reportData(data, dataFileName, dataType);
    }
}
