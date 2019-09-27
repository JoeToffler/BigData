package com.xahi.reporteddata.controller;

import com.xahi.reporteddata.constants.request.DataCollectSystem;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.request.PoliceCode;
import com.xahi.reporteddata.converter.DongguanRentalHouseOpenAuthorizationConverter;
import com.xahi.reporteddata.dto.DongguanRentalHouseOpenAuthorizationDTO;
import com.xahi.reporteddata.repository.CardRegisterRepository;
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

/**
 * @author YangPeng
 * @describe 权限
 * @date 2019-09-19 13:57
 */
@RestController
@RequestMapping("/openAuth")
public class HouseOpenAuthorizationController {
    @Autowired
    DongguanRentalHouseOpenAuthorizationConverter authorizationConverter;

    @Autowired
    CardRegisterRepository cardRegisterRepository;
    /**
     * 本地写.csv并格式化
     *
     * @throws IOException
     */
    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<DongguanRentalHouseOpenAuthorizationDTO> list = authorizationConverter.getList(cardRegisterRepository.findAll());
        List<DongguanRentalHouseOpenAuthorizationDTO> l = Filter.convert(DongguanRentalHouseOpenAuthorizationDTO.class, list, $.symbol);
        ExcelLocalDown.exportExcel(l, DataType.XQ_MJKKSQXX.description, DataType.XQ_MJKKSQXX.code, DongguanRentalHouseOpenAuthorizationDTO.class, DataType.XQ_MJKKSQXX.description);
    }

    /**
     * 本地写.dat文件
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeDat")
    public void writeDat() throws Exception {
        List<DongguanRentalHouseOpenAuthorizationDTO> list = authorizationConverter.getList(cardRegisterRepository.findAll());
        List<DongguanRentalHouseOpenAuthorizationDTO> result =
                Filter.convert(DongguanRentalHouseOpenAuthorizationDTO.class, list, $.symbol);
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_MJKKSQXX.code,
                PoliceCode.G441900.code));
    }

}
