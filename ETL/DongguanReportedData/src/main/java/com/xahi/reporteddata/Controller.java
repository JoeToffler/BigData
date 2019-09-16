package com.xahi.reporteddata;

import com.mongodb.client.MongoCollection;
import com.xahi.reporteddata.model.Tenant;
import com.xahi.reporteddata.repository.TenantRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @GetMapping(value = "/getPage")
    public Page<Tenant> getPage(Pageable pageable) {
        return tenantRepository.findAll(pageable);
    }

    @GetMapping(value = "/getList")
    public List<Tenant> getList() {
        return tenantRepository.findAll();
    }

    @GetMapping(value = "/mongodb")
    public MongoCollection<Document> mongodb() {
        MongoCollection<Document> m_doorwaymanagement_record = mongoTemplate.getCollection("m_doorwaymanagement_record");
        return m_doorwaymanagement_record;
    }
}
