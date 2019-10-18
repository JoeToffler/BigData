package com.joe.reporteddata.controller;

import com.joe.reporteddata.constants.request.DataCollectSystem;
import com.joe.reporteddata.constants.request.DataType;
import com.joe.reporteddata.constants.request.PoliceCode;
import com.joe.reporteddata.converter.RentalAccessTerminalConverter;
import com.joe.reporteddata.dto.ReportRentalAccessTerminalDTO;
import com.joe.reporteddata.repository.DeviceRepository;
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
 * @describe 出租屋门禁终端信息表
 * @date 2019-09-19 13:57
 */
@RestController
@RequestMapping("/accessDevice")
public class DeviceController {
    @Autowired
    RentalAccessTerminalConverter accessTerminalConverter;

    @Autowired
    DeviceRepository deviceRepository;

    /**
     * 本地写.csv并格式化
     *
     * @throws IOException
     */
    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<ReportRentalAccessTerminalDTO> list = accessTerminalConverter.getList(deviceRepository.findAll());
        List<ReportRentalAccessTerminalDTO> l = Filter.convert(ReportRentalAccessTerminalDTO.class, list, $.symbol);
        DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_MJZD.code, PoliceCode.G441900.code);
        ExcelLocalDown.exportExcel(l, DataType.XQ_MJZD.description, DataType.XQ_MJZD.code, ReportRentalAccessTerminalDTO.class, DataType.XQ_MJZD.description);
    }

    /**
     * 本地写.dat文件
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeDat")
    public void writeDat() throws Exception {
        List<ReportRentalAccessTerminalDTO> list = accessTerminalConverter.getList(deviceRepository.findAll());
        List<ReportRentalAccessTerminalDTO> result = Filter.convert(ReportRentalAccessTerminalDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_MJZD.code,
                PoliceCode.G441900.code));
    }
}
