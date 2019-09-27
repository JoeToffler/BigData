package com.xahi.reporteddata.service;

import com.xahi.reporteddata.constants.request.DataCollectSystem;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.request.PoliceCode;
import com.xahi.reporteddata.converter.DongguanRentalHouseConverter;
import com.xahi.reporteddata.dto.DongguanRentalHouseDTO;
import com.xahi.reporteddata.model.House;
import com.xahi.reporteddata.util.data.Filter;
import com.xahi.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.xahi.reporteddata.constants.Symbol.$;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-23 17:48
 */
@Service
public class DongguanHouseService {

    @Autowired
    private DongguanRentalHouseConverter converter;

    @Autowired
    private DongguanCommonService dongguanCommonService;

    private static final String dataType = DataType.XQ_YZXX.code;

    public String reportData(List<House> list) throws Exception {
        List<DongguanRentalHouseDTO> dtos = converter.getList(list);
        //数据处理
        List<DongguanRentalHouseDTO> data = Filter.convert(DongguanRentalHouseDTO.class, dtos, $.symbol);
        //生成文件名
        String dataFileName = DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, dataType, PoliceCode.G441900.code);
        return dongguanCommonService.reportData(data,dataFileName,dataType);
    }
}
