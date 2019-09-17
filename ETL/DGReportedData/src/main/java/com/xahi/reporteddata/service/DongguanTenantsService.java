package com.xahi.reporteddata.service;

import com.xahi.reporteddata.converter.DongguanTenatsConverter;
import com.xahi.reporteddata.dto.DongguanTenatsDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-16 17:42
 */
@Service
public class DongguanTenantsService {
    @Autowired
    DongguanTenatsConverter dongguanTenatsConverter;

    public void reportData(List<DongguanTenatsDTO> list) {
        int size = list.size();
        int time = 1000000;
        if (size < time) {

        } else {
            for (int i = 0; i < size / time + 1; i++) {

            }
        }
    }



}
