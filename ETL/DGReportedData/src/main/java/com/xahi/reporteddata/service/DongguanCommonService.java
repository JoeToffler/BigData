package com.xahi.reporteddata.service;

import com.xahi.reporteddata.constants.request.ParamName;
import com.xahi.reporteddata.util.file.Writer;
import com.xahi.reporteddata.util.httputil.HttpClientUtil;
import com.xahi.reporteddata.util.request.MD5Util;
import com.xahi.reporteddata.util.request.UuidRandom;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author YangPeng
 * @describe TODO fileType
 * @date 2019-09-23 18:51
 */
@Log
@Service
public class DongguanCommonService {

    @Value("${dongguan.account.accessId}")
    private String accessId;

    @Value("${dongguan.account.accessPwd}")
    private String accessPwd;

    @Value("${dongguan.report.url}")
    private String url;

    public <T> String reportData(List<T> data,String dataFileName,String dataType) throws Exception {
        Writer.writeDat(data, dataFileName);
        String file = "./" + dataFileName + ".dat";
        //传参设置
        HashMap<String, String> fields = new HashMap<>(5);
        fields.put(ParamName.DATATYPE.desc, dataType);
        fields.put(ParamName.MD5.desc, MD5Util.md5(file));
        fields.put(ParamName.ACCESSID.desc, accessId);
        UUID uuid = UuidRandom.getUuid();
        fields.put(ParamName.RANDOM.desc, uuid.toString());
        fields.put(ParamName.ACCESSTOKEN.desc, MD5Util.getAccessToken(accessPwd, uuid.toString()));
        HashMap<String, File> fileParam = new HashMap<>(1);
        fileParam.put(ParamName.FILEDATA.desc,new File(file));
        String result = HttpClientUtil.doPost(url, fields, fileParam);
        return result;
    }
}
