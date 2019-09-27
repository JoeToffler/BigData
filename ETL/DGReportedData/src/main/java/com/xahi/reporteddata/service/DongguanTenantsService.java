package com.xahi.reporteddata.service;

import com.xahi.reporteddata.constants.request.DataCollectSystem;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.request.PoliceCode;
import com.xahi.reporteddata.converter.DongguanTenatsConverter;
import com.xahi.reporteddata.dto.DongguanTenatsDTO;
import com.xahi.reporteddata.model.Tenant;
import com.xahi.reporteddata.util.data.Filter;
import com.xahi.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.xahi.reporteddata.constants.Symbol.$;

/**
 * @author YangPeng
 * @describe 出租屋居住人员信息表
 * @date 2019-09-16 17:42
 */
@Service
public class DongguanTenantsService {
    @Autowired
    DongguanTenatsConverter dongguanTenatsConverter;

    @Autowired
    private DongguanCommonService dongguanCommonService;

    private static final String dataType = DataType.XQ_FWXX.code;


    public String reportData(List<Tenant> list) throws Exception {
        List<DongguanTenatsDTO> dtos = dongguanTenatsConverter.getList(list);
        //数据处理
        List<DongguanTenatsDTO> data = Filter.convert(DongguanTenatsDTO.class, dtos, $.symbol);
        //生成文件名
        String dataFileName = DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_FWXX.code, PoliceCode.G441900.code);
        return dongguanCommonService.reportData(data,dataFileName,dataType);
    }

}
