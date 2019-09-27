package com.xahi.reporteddata.util.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author YangPeng
 * @describe 压缩文件工具
 * @date 2019-09-19 19:54
 */
public class ZipUtils {

    private static final int  BUFFER_SIZE = 2 * 1024;

    /**
     * 压缩成ZIP
     * @param inPath    文件输入路径
     * @param outPath  压缩文件输出路径
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(String inPath , String outPath)throws Exception {
        File file = new File(inPath);
        FileOutputStream out = new FileOutputStream(new File(outPath));
        ZipOutputStream zos = null ;
        try {
            zos = new ZipOutputStream(out);
                byte[] buf = new byte[BUFFER_SIZE];
                zos.putNextEntry(new ZipEntry(file.getName()));
                int len;
                FileInputStream in = new FileInputStream(file);
                while ((len = in.read(buf)) != -1){
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
                in.close();
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils",e);
        }finally{
            if(zos != null){
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<File> fileList = new ArrayList<>();
        fileList.add(new File("./出租屋门禁终端信息.csv"));
        FileOutputStream fos = new FileOutputStream(new File("./666.zip"));
        ZipUtils.toZip("./出租屋门禁终端信息.csv", "./666.zip");
    }
}
