package com.xahi.reporteddata.service;

import com.xahi.reporteddata.constants.request.DataCollectSystem;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.request.PoliceCode;
import com.xahi.reporteddata.converter.DongguanRentalAccessRecordsConverter;
import com.xahi.reporteddata.dto.DongguanRentalAccessRecordsDTO;
import com.xahi.reporteddata.model.Record;
import com.xahi.reporteddata.util.data.Filter;
import com.xahi.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.xahi.reporteddata.constants.Symbol.$;

/**
 * @author YangPeng
 * @describe 出租屋门禁开门记录信息表
 * @date 2019-09-23 17:47
 */
@Service
public class DongguanRecordService {

    @Autowired
    private DongguanRentalAccessRecordsConverter converter;

    @Autowired
    private DongguanCommonService dongguanCommonService;

    private static final String dataType = DataType.XQ_MJSKXX.code;

    public String reportData(List<Record> list) throws Exception {
        List<DongguanRentalAccessRecordsDTO> dtos = converter.getList(list);
        //数据处理
        List<DongguanRentalAccessRecordsDTO> data = Filter.convert(DongguanRentalAccessRecordsDTO.class, dtos,$.symbol);
        //生成文件名
        String dataFileName = DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, dataType, PoliceCode.G441900.code);
        return dongguanCommonService.reportData(data,dataFileName,dataType);
    }

}
