package com.joe.reporteddata.controller;

import com.joe.reporteddata.constants.request.DataCollectSystem;
import com.joe.reporteddata.constants.request.DataType;
import com.joe.reporteddata.constants.request.PoliceCode;
import com.joe.reporteddata.converter.RentalHouseConverter;
import com.joe.reporteddata.dto.ReportRentalHouseDTO;
import com.joe.reporteddata.repository.HouseRepository;
import com.joe.reporteddata.util.data.Filter;
import com.joe.reporteddata.util.excel.ExcelLocalDown;
import com.joe.reporteddata.util.excel.ExcelWebDownUp;
import com.joe.reporteddata.util.file.Writer;
import com.joe.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.joe.reporteddata.constants.Symbol.$;

/**
 * @author JoeToffler
 * @describe 出租屋房屋信息表
 * @date 2019-09-19 13:57
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    RentalHouseConverter houseConverter;

    @Autowired
    HouseRepository houseRepository;
    /**
     * 本地写.csv并格式化
     *
     * @throws IOException
     */
    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<ReportRentalHouseDTO> list = houseConverter.getList(houseRepository.findAll());
        List<ReportRentalHouseDTO> l = Filter.convert(ReportRentalHouseDTO.class, list, $.symbol);
        ExcelLocalDown.exportExcel(l, DataType.XQ_YZXX.description, DataType.XQ_YZXX.code, ReportRentalHouseDTO.class, DataType.XQ_YZXX.description);
    }

    /**
     * 本地写.dat文件
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeDat")
    public void writeDat() throws Exception {
        List<ReportRentalHouseDTO> list = houseConverter.getList(houseRepository.findAll());
        List<ReportRentalHouseDTO> result = Filter.convert(ReportRentalHouseDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_YZXX.code, PoliceCode.G441900.code));
    }

    /**
     * Excel To MySQL
     */
    @PostMapping(value = "excelToMySQL")
    public void excelToMySQL(@RequestParam("file") MultipartFile file) throws Exception {
        List<ReportRentalHouseDTO> list = ExcelWebDownUp.importExcel(file, 1, 1, ReportRentalHouseDTO.class);
        List<ReportRentalHouseDTO> result = Filter.convert(ReportRentalHouseDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_YZXX.code, PoliceCode.G441900.code));
    }

}
