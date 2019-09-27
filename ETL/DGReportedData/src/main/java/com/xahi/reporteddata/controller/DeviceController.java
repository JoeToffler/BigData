package com.xahi.reporteddata.controller;

import com.xahi.reporteddata.constants.request.DataCollectSystem;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.request.PoliceCode;
import com.xahi.reporteddata.converter.DongguanRentalAccessTerminalConverter;
import com.xahi.reporteddata.dto.DongguanRentalAccessTerminalDTO;
import com.xahi.reporteddata.repository.DeviceRepository;
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
 * @describe 出租屋门禁终端信息表
 * @date 2019-09-19 13:57
 */
@RestController
@RequestMapping("/accessDevice")
public class DeviceController {
    @Autowired
    DongguanRentalAccessTerminalConverter accessTerminalConverter;

    @Autowired
    DeviceRepository deviceRepository;

    /**
     * 本地写.csv并格式化
     *
     * @throws IOException
     */
    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<DongguanRentalAccessTerminalDTO> list = accessTerminalConverter.getList(deviceRepository.findAll());
        List<DongguanRentalAccessTerminalDTO> l = Filter.convert(DongguanRentalAccessTerminalDTO.class, list, $.symbol);
        DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_MJZD.code, PoliceCode.G441900.code);
        ExcelLocalDown.exportExcel(l, DataType.XQ_MJZD.description, DataType.XQ_MJZD.code, DongguanRentalAccessTerminalDTO.class, DataType.XQ_MJZD.description);
    }

    /**
     * 本地写.dat文件
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeDat")
    public void writeDat() throws Exception {
        List<DongguanRentalAccessTerminalDTO> list = accessTerminalConverter.getList(deviceRepository.findAll());
        List<DongguanRentalAccessTerminalDTO> result = Filter.convert(DongguanRentalAccessTerminalDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_MJZD.code,
                PoliceCode.G441900.code));
    }
}
