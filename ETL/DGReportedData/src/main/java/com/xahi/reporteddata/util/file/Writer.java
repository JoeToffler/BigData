package com.xahi.reporteddata.util.file;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * @author YangPeng
 * @describe
 * @date 2019-09-17 18:59
 */
public class Writer {
    public static <T> void writeCsv(List<T> data,String name) throws Exception {
        OutputStreamWriter pw = null;
        pw = new OutputStreamWriter(new FileOutputStream("./"+name+".csv"),"UTF-8");
        pw.write(data.toString());
        pw.close();
    }
}
