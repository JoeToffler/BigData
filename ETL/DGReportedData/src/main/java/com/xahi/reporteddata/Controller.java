package com.xahi.reporteddata;

import com.mongodb.client.MongoCollection;
import com.xahi.reporteddata.constants.DataType;
import com.xahi.reporteddata.constants.Nationality;
import com.xahi.reporteddata.converter.DongguanTenatsConverter;
import com.xahi.reporteddata.dto.DongguanTenatsDTO;
import com.xahi.reporteddata.dto.NationalityEnumDTO;
import com.xahi.reporteddata.model.Tenant;
import com.xahi.reporteddata.repository.TenantRepository;
import com.xahi.reporteddata.util.DynamicEnumUtils;
import com.xahi.reporteddata.util.data.Filter;
import com.xahi.reporteddata.util.excel.ExcelLocalDown;
import com.xahi.reporteddata.util.excel.ExcelWebDownUp;
import com.xahi.reporteddata.util.file.Writer;
import lombok.extern.java.Log;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/**
 * @author YangPeng
 * @describe
 * @date 2019-09-12 10:17
 */
@RestController
@Log
public class Controller {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private DongguanTenatsConverter dongguanTenatsConverter;

    /**
     * 测试SpringDataJPA
     *
     * @return
     */
    @GetMapping(value = "/getList")
    public List<Tenant> getList() {
        return tenantRepository.findAll();
    }

    @GetMapping(value = "/getTenantsList")
    public List<DongguanTenatsDTO> getTenantsList() {
        return dongguanTenatsConverter.getList();
    }

    /**
     * 测试SpringDataMongoDB
     *
     * @return
     */
    @GetMapping(value = "/mongodb")
    public MongoCollection<Document> mongodb() {
        MongoCollection<Document> m_doorwaymanagement_record = mongoTemplate.getCollection("m_doorwaymanagement_record");
        return m_doorwaymanagement_record;
    }

    /**
     * 浏览器下载.csv并格式化
     *
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList();
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
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList();
        List<DongguanTenatsDTO> l = Filter.convert(DongguanTenatsDTO.class, list, "$", "\\r\\n", "TX_TP");
        ExcelLocalDown.exportExcel(l, DataType.XQ_FWXX.description, DataType.XQ_FWXX.code, DongguanTenatsDTO.class, DataType.XQ_FWXX.description);
    }

    /**
     * 本地写.csv文件未作格式处理
     *
     * @throws Exception
     */
    @GetMapping(value = "/writeCsv")
    public void writeCsv() throws Exception {
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList();
        List<DongguanTenatsDTO> l = Filter.convert(DongguanTenatsDTO.class, list, "$", "\\r\\n", "TX_TP");
        Writer.writeCsv(l, "tenants_info");
    }

    @PostMapping(value = "/excelToEnum")
    public void excelToEnum(@RequestParam("file") MultipartFile file) {
        List<NationalityEnumDTO> nationalityEnumDTOS = ExcelWebDownUp.importExcel(file, 0, 1, NationalityEnumDTO.class);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nationalityEnumDTOS.size(); i++) {
            NationalityEnumDTO nationalityEnumDTO = nationalityEnumDTOS.get(i);
            String s = nationalityEnumDTO.makeEnum();
            if (i != nationalityEnumDTOS.size() - 1) {
                sb.append(s + ",");
            } else {
                sb.append(s+";");
            }
        }
        System.out.println(sb);
        //DynamicEnumUtils.addEnum(Nationality.class,x.getDesc(),new Class[] {java.lang.String.class},new Object[]{x.getCode()});
    }

}
