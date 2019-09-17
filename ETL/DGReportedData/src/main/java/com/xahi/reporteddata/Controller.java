package com.xahi.reporteddata;

import com.mongodb.client.MongoCollection;
import com.xahi.reporteddata.constants.DataType;
import com.xahi.reporteddata.converter.DongguanTenatsConverter;
import com.xahi.reporteddata.dto.DongguanTenatsDTO;
import com.xahi.reporteddata.model.Tenant;
import com.xahi.reporteddata.repository.TenantRepository;
import com.xahi.reporteddata.service.DongguanTenantsService;
import com.xahi.reporteddata.util.data.Filter;
import com.xahi.reporteddata.util.excel.ExcelLocalDown;
import com.xahi.reporteddata.util.excel.ExcelWebDownUp;
import com.xahi.reporteddata.util.file.Writer;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import static com.xahi.reporteddata.constants.Symbol.$;


/**
 * @author YangPeng
 * @describe
 * @date 2019-09-12 10:17
 */
@RestController
public class Controller {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private DongguanTenatsConverter dongguanTenatsConverter;

    @GetMapping(value = "/getPage")
    public Page<Tenant> getPage(Pageable pageable) {
        return tenantRepository.findAll(pageable);
    }

    @GetMapping(value = "/getList")
    public List<Tenant> getList() {
        return tenantRepository.findAll();
    }

    @GetMapping(value = "/getTenantsList")
    public List<DongguanTenatsDTO> getTenantsList() {
        return dongguanTenatsConverter.getList();
    }

    @GetMapping(value = "/mongodb")
    public MongoCollection<Document> mongodb() {
        MongoCollection<Document> m_doorwaymanagement_record = mongoTemplate.getCollection("m_doorwaymanagement_record");
        return m_doorwaymanagement_record;
    }

    @GetMapping(value = "/exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList();
        ExcelWebDownUp.exportExcel(list, DataType.XQ_FWXX.description, DataType.XQ_FWXX.code, DongguanTenatsDTO.class,
                DataType.XQ_FWXX.description+".xlsx", response);
    }

    @GetMapping(value = "/excelTest")
    public void excelTest() throws IOException {
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList();
        List<DongguanTenatsDTO> l = Filter.convert(DongguanTenatsDTO.class, list, "$","\\r\\n","TX_TP");
        ExcelLocalDown.exportExcel(l, DataType.XQ_FWXX.description, DataType.XQ_FWXX.code, DongguanTenatsDTO.class, DataType.XQ_FWXX.description);
    }

    @GetMapping(value = "/writeCsv")
    public void writeCsv() throws Exception {
        List<DongguanTenatsDTO> list = dongguanTenatsConverter.getList();
        List<DongguanTenatsDTO> l = Filter.convert(DongguanTenatsDTO.class, list, "$","\\r\\n","TX_TP");
        Writer.writeCsv(l,"出租屋居住人员信息");
    }


}
