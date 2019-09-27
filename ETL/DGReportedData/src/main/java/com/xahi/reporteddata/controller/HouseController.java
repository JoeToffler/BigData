package com.xahi.reporteddata.controller;

import com.xahi.reporteddata.constants.request.DataCollectSystem;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.request.PoliceCode;
import com.xahi.reporteddata.converter.DongguanRentalHouseConverter;
import com.xahi.reporteddata.dto.DongguanRentalHouseDTO;
import com.xahi.reporteddata.repository.HouseRepository;
import com.xahi.reporteddata.util.data.Filter;
import com.xahi.reporteddata.util.excel.ExcelLocalDown;
import com.xahi.reporteddata.util.excel.ExcelWebDownUp;
import com.xahi.reporteddata.util.file.Writer;
import com.xahi.reporteddata.util.request.DataFileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.xahi.reporteddata.constants.Symbol.$;
import static com.xahi.reporteddata.constants.Symbol.FEED;

/**
 * @author YangPeng
 * @describe 出租屋房屋信息表
 * @date 2019-09-19 13:57
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    DongguanRentalHouseConverter houseConverter;

    @Autowired
    HouseRepository houseRepository;
    /**
     * 本地写.csv并格式化
     *
     * @throws IOException
     */
    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<DongguanRentalHouseDTO> list = houseConverter.getList(houseRepository.findAll());
        List<DongguanRentalHouseDTO> l = Filter.convert(DongguanRentalHouseDTO.class, list, $.symbol);
        ExcelLocalDown.exportExcel(l, DataType.XQ_YZXX.description, DataType.XQ_YZXX.code, DongguanRentalHouseDTO.class, DataType.XQ_YZXX.description);
    }

    /**
     * 本地写.dat文件
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeDat")
    public void writeDat() throws Exception {
        List<DongguanRentalHouseDTO> list = houseConverter.getList(houseRepository.findAll());
        List<DongguanRentalHouseDTO> result = Filter.convert(DongguanRentalHouseDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_YZXX.code, PoliceCode.G441900.code));
    }

    /**
     * Excel To MySQL
     */
    @PostMapping(value = "excelToMySQL")
    public void excelToMySQL(@RequestParam("file") MultipartFile file) throws Exception {
        List<DongguanRentalHouseDTO> list = ExcelWebDownUp.importExcel(file, 1, 1, DongguanRentalHouseDTO.class);
        List<DongguanRentalHouseDTO> result = Filter.convert(DongguanRentalHouseDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_YZXX.code, PoliceCode.G441900.code));
    }

}
