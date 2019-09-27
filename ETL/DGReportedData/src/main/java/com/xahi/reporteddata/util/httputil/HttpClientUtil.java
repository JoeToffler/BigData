package com.xahi.reporteddata.util.httputil;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.*;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-16 17:42
 */
public class HttpClientUtil {
    private static String charset = "UTF-8";

    public static String doPost(String url, HashMap<String, String> fields, HashMap<String, File> files) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        // HttpClient请求的相关设置，可以不用配置，用默认的参数，这里设置连接和超时时长(毫秒)
        RequestConfig config = RequestConfig.custom().setConnectTimeout(30000).setSocketTimeout(30000).build();
        try {
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
            URIBuilder builder = new URIBuilder();
            List<NameValuePair> list = addFields(fields);
            builder.setScheme("http").setHost(url).setParameters(list);
            URI uri = builder.build();
            HttpPost httpPost = new HttpPost(uri);

            addFiles(entityBuilder, files);
            HttpEntity reqEntity = entityBuilder.build();
            httpPost.setEntity(reqEntity);
            httpPost.setConfig(config);
            // 执行网络请求并返回结果
            response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                result = streamToString(resEntity.getContent(), charset);
            }
            EntityUtils.consume(resEntity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.close();
            httpClient.close();
        }
        return result;
    }

    /**
     * 此方法是把传进的字节流转化为相应的字符串并返回，此方法一般在网络请求中用到
     *
     * @param inputStream
     * @param charset
     * @return
     * @throws Exception
     */
    private static String streamToString(InputStream inputStream, String charset) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset)) {
            try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\r\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    private static void addFiles(MultipartEntityBuilder entityBuilder, HashMap<String, File> files) {
        if (files == null) {
            return;
        }
        for (String name : files.keySet()) {
            File file = files.get(name);
            FileBody fileBody = new FileBody(file);
            entityBuilder.addPart(name, fileBody);
        }
    }

    private static List<NameValuePair> addFields(HashMap<String, String> fields) {
        List<NameValuePair> list = new ArrayList<>();
        fields.forEach((k, v) -> {
            list.add(new BasicNameValuePair(k, v));
        });
        return list;
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, String> fields = new HashMap(1);
        HashMap<String, File> files = new HashMap(1);
        fields.put("name", "Joe");
        files.put("file", new File("./出租屋门禁终端信息.csv"));
        String a = doPost("http://localhost:5000/tenant/httpclientTest", fields, files);
        System.out.println(a);
    }
}
