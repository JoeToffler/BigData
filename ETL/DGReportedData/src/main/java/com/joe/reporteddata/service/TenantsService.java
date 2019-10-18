package com.joe.reporteddata.service;

import com.joe.reporteddata.constants.request.DataCollectSystem;
import com.joe.reporteddata.constants.request.DataType;
import com.joe.reporteddata.constants.request.PoliceCode;
import com.joe.reporteddata.converter.TenantsConverter;
import com.joe.reporteddata.dto.ReportTenetsDTO;
import com.joe.reporteddata.model.Tenant;
import com.joe.reporteddata.util.data.Filter;
import com.joe.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.joe.reporteddata.constants.Symbol.$;

/**
 * @author JoeToffler
 * @describe 出租屋居住人员信息表
 * @date 2019-09-16 17:42
 */
@Service
public class TenantsService {
    @Autowired
    TenantsConverter tenantsConverter;

    @Autowired
    private CommonService commonService;

    private static final String dataType = DataType.XQ_FWXX.code;


    public String reportData(List<Tenant> list) throws Exception {
        List<ReportTenetsDTO> dtos = tenantsConverter.getList(list);
        //数据处理
        List<ReportTenetsDTO> data = Filter.convert(ReportTenetsDTO.class, dtos, $.symbol);
        //生成文件名
        String dataFileName = DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_FWXX.code, PoliceCode.G441900.code);
        return commonService.reportData(data,dataFileName,dataType);
    }

}
