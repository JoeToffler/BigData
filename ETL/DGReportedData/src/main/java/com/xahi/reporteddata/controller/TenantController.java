package com.xahi.reporteddata.controller;

import com.xahi.reporteddata.constants.request.DataCollectSystem;
import com.xahi.reporteddata.constants.request.DataType;
import com.xahi.reporteddata.constants.request.PoliceCode;
import com.xahi.reporteddata.converter.DongguanTenatsConverter;
import com.xahi.reporteddata.dto.DongguanTenatsDTO;
import com.xahi.reporteddata.dto.PoliceCodeEnumDTO;
import com.xahi.reporteddata.model.Record;
import com.xahi.reporteddata.model.ReportIndex;
import com.xahi.reporteddata.model.Tenant;
import com.xahi.reporteddata.repository.RecordRepository;
import com.xahi.reporteddata.repository.ReportIndexRepository;
import com.xahi.reporteddata.repository.TenantRepository;
import com.xahi.reporteddata.service.DongguanTenantsService;
import com.xahi.reporteddata.util.data.Filter;
import com.xahi.reporteddata.util.excel.ExcelLocalDown;
import com.xahi.reporteddata.util.excel.ExcelWebDownUp;
import com.xahi.reporteddata.util.file.Writer;
import com.xahi.reporteddata.util.request.DataFileNameUtil;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author YangPeng
 * @describe
 * @date 2019-09-12 10:17
 */
@RestController
@RequestMapping("/tenant")
@Log
public class TenantController {

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private DongguanTenatsConverter dongguanTenatsConverter;

    @Autowired
    DongguanTenantsService tenantsService;

    /**
     * 测试SpringDataJPA
     *
     * @return
     */
    @GetMapping(value = "/getList")
    public List<Tenant> getList() {
        return tenantRepository.findAll();
    }

    /**
     * 测试SpringDataMongoDB
     *
     * @return
     */
    @GetMapping(value = "/mongodb")
    public List<Record> mongodb() {
        List<Record> all = recordRepository.findAll();
        return all;
    }

    /**
     * 浏览器下载.csv并格式化
     *
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Tenant> all = tenantRepository.findAll();
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList(all);
        ExcelWebDownUp.exportExcel(list, DataType.XQ_FWXX.description, DataType.XQ_FWXX.code, DongguanTenatsDTO.class,
                DataType.XQ_FWXX.description + ".xlsx", response);
    }

    /**
     * 本地写.csv并格式化
     *
     * @throws IOException
     */
    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<Tenant> all = tenantRepository.findAll();
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList(all);
        List<DongguanTenatsDTO> l = Filter.convert(DongguanTenatsDTO.class, list, "$");
        ExcelLocalDown.exportExcel(l, DataType.XQ_FWXX.description, DataType.XQ_FWXX.code, DongguanTenatsDTO.class, DataType.XQ_FWXX.description);
    }

    /**
     * 本地写.csv文件未作格式处理
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeCsv")
    public void writeCsv() throws Exception {
        List<Tenant> all = tenantRepository.findAll();
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList(all);
        List<DongguanTenatsDTO> l = Filter.convert(DongguanTenatsDTO.class, list, "$");
        Writer.writeCsv(l, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_FWXX.code, PoliceCode.G441900.code));
    }


    @GetMapping(value = "/writeDat")
    public void writeDat() throws Exception {
        List<Tenant> all = tenantRepository.findAll();
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList(all);
        List<DongguanTenatsDTO> result = Filter.convert(DongguanTenatsDTO.class, list, "$");
        Writer.writeDat(result, DataFileNameUtil.getDataFileName(DataCollectSystem.COMMUNITY.code, DataType.XQ_FWXX.code,
                PoliceCode.G441900.code));
    }



    @PostMapping(value = "/excelToEnum")
    public void excelToEnum(@RequestParam("file") MultipartFile file) {
//        List<NationalityEnumDTO> nationalityEnumDTOS = ExcelWebDownUp.importExcel(file, 0, 1, NationalityEnumDTO.class);
        List<PoliceCodeEnumDTO> policeCodeEnumDTOS = ExcelWebDownUp.importExcel(file, 0, 1, PoliceCodeEnumDTO.class);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < policeCodeEnumDTOS.size(); i++) {
            PoliceCodeEnumDTO nationalityEnumDTO = policeCodeEnumDTOS.get(i);
            String s = nationalityEnumDTO.makeEnum();
            if (i != policeCodeEnumDTOS.size() - 1) {
                sb.append(s + ",");
            } else {
                sb.append(s + ";");
            }
    }
        System.out.println(sb);
    }

    @PostMapping(value = "/httpclientTest")
    public String httpclientTest(@RequestParam("name") String name,@RequestParam("file") MultipartFile file){
        return "Httpclient test successfully:"+name;
    }

    @GetMapping(value = "/report`")
    public String reportDataTest() throws Exception {
        String s = tenantsService.reportData(tenantRepository.findAll());
        System.out.println(s);
        return s;
    }

}
