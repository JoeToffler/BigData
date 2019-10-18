package com.joe.reporteddata.util.request;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.IOException;

import static com.joe.reporteddata.util.request.FileMD5Util.getFileMD5String;
import static com.joe.reporteddata.util.request.UuidRandom.getUuid;

/**
 * @author JoeToffler
 * @describe
 * @date 2019-09-18 16:20
 */
public class MD5Util {
    /**
     * MD5方法
     * @param text 明文
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text) {
        //加密后的字符串
        String encodeStr = DigestUtils.md5Hex(text);
        return encodeStr;
    }

    public static String getAccessToken(String accessPwd,String uuid) {
        return md5(md5(accessPwd) + uuid);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("./20101026102620891_125_441900_101.dat");
        String fileMD5 = getFileMD5String(file);
        System.out.println("file(md5):"+fileMD5);

        String uuid = getUuid().toString();
        String token = getAccessToken("test",uuid);
        System.out.println("uuid(random):"+uuid);
        System.out.println("token(accessToken):"+token);
    }
}
