package com.joe.reporteddata.controller;

import com.joe.reporteddata.constants.request.DataCollectSystem;
import com.joe.reporteddata.constants.request.DataType;
import com.joe.reporteddata.constants.request.PoliceCode;
import com.joe.reporteddata.converter.RentalHouseOpenAuthorizationConverter;
import com.joe.reporteddata.dto.ReportRentalHouseOpenAuthorizationDTO;
import com.joe.reporteddata.repository.CardRegisterRepository;
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
 * @describe 权限
 * @date 2019-09-19 13:57
 */
@RestController
@RequestMapping("/openAuth")
public class HouseOpenAuthorizationController {
    @Autowired
    RentalHouseOpenAuthorizationConverter authorizationConverter;

    @Autowired
    CardRegisterRepository cardRegisterRepository;
    /**
     * 本地写.csv并格式化
     *
     * @throws IOException
     */
    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<ReportRentalHouseOpenAuthorizationDTO> list = authorizationConverter.getList(cardRegisterRepository.findAll());
        List<ReportRentalHouseOpenAuthorizationDTO> l = Filter.convert(ReportRentalHouseOpenAuthorizationDTO.class, list, $.symbol);
        ExcelLocalDown.exportExcel(l, DataType.XQ_MJKKSQXX.description, DataType.XQ_MJKKSQXX.code, ReportRentalHouseOpenAuthorizationDTO.class, DataType.XQ_MJKKSQXX.description);
    }

    /**
     * 本地写.dat文件
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeDat")
    public void writeDat() throws Exception {
        List<ReportRentalHouseOpenAuthorizationDTO> list = authorizationConverter.getList(cardRegisterRepository.findAll());
        List<ReportRentalHouseOpenAuthorizationDTO> result =
                Filter.convert(ReportRentalHouseOpenAuthorizationDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_MJKKSQXX.code,
                PoliceCode.G441900.code));
    }

}
