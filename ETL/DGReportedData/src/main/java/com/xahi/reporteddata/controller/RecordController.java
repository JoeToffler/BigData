package com.xahi.reporteddata.controller;

import com.xahi.reporteddata.constants.request.DataCollectSystem;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.request.PoliceCode;
import com.xahi.reporteddata.converter.DongguanRentalAccessRecordsConverter;
import com.xahi.reporteddata.dto.DongguanRentalAccessRecordsDTO;
import com.xahi.reporteddata.repository.RecordRepository;
import com.xahi.reporteddata.util.data.Filter;
import com.xahi.reporteddata.util.excel.ExcelLocalDown;
import com.xahi.reporteddata.util.file.Writer;
import com.xahi.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static com.xahi.reporteddata.constants.Symbol.$;
import static com.xahi.reporteddata.constants.Symbol.FEED;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-23 13:56
 */
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    DongguanRentalAccessRecordsConverter converter;

    @Autowired
    RecordRepository recordRepository;
    /**
     * 本地写.csv并格式化
     *
     * @throws IOException
     */
    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<DongguanRentalAccessRecordsDTO> list = converter.getList(recordRepository.findAll());
        List<DongguanRentalAccessRecordsDTO> l = Filter.convert(DongguanRentalAccessRecordsDTO.class, list, $.symbol);
        ExcelLocalDown.exportExcel(l, DataType.XQ_MJSKXX.description, DataType.XQ_MJSKXX.code, DongguanRentalAccessRecordsDTO.class,
                DataType.XQ_MJSKXX.description);
    }

    /**
     * 本地写.dat文件
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeDat")
    public void writeDat() throws Exception {
        List<DongguanRentalAccessRecordsDTO> list = converter.getList(recordRepository.findAll());
        List<DongguanRentalAccessRecordsDTO> result = Filter.convert(DongguanRentalAccessRecordsDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_MJSKXX.code,
                PoliceCode.G441900.code));
    }
}
