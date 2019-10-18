package com.joe.reporteddata.controller;

import com.joe.reporteddata.constants.request.DataCollectSystem;
import com.joe.reporteddata.constants.request.DataType;
import com.joe.reporteddata.constants.request.PoliceCode;
import com.joe.reporteddata.converter.RentalAccessRecordsConverter;
import com.joe.reporteddata.dto.ReportRentalAccessRecordsDTO;
import com.joe.reporteddata.repository.RecordRepository;
import com.joe.reporteddata.util.data.Filter;
import com.joe.reporteddata.util.excel.ExcelLocalDown;
import com.joe.reporteddata.util.file.Writer;
import com.joe.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static com.joe.reporteddata.constants.Symbol.$;

/**
 * @author JoeToffler
 * @describe
 * @date 2019-09-23 13:56
 */
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RentalAccessRecordsConverter converter;

    @Autowired
    RecordRepository recordRepository;
    /**
     * 本地写.csv并格式化
     *
     * @throws IOException
     */
    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<ReportRentalAccessRecordsDTO> list = converter.getList(recordRepository.findAll());
        List<ReportRentalAccessRecordsDTO> l = Filter.convert(ReportRentalAccessRecordsDTO.class, list, $.symbol);
        ExcelLocalDown.exportExcel(l, DataType.XQ_MJSKXX.description, DataType.XQ_MJSKXX.code, ReportRentalAccessRecordsDTO.class,
                DataType.XQ_MJSKXX.description);
    }

    /**
     * 本地写.dat文件
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeDat")
    public void writeDat() throws Exception {
        List<ReportRentalAccessRecordsDTO> list = converter.getList(recordRepository.findAll());
        List<ReportRentalAccessRecordsDTO> result = Filter.convert(ReportRentalAccessRecordsDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_MJSKXX.code,
                PoliceCode.G441900.code));
    }
}
