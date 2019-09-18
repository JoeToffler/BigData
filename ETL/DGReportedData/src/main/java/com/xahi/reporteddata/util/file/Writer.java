package com.xahi.reporteddata.util.file;

import org.apache.poi.ss.formula.functions.T;

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
        OutputStreamWriter pw = new OutputStreamWriter(new FileOutputStream("./"+name+".csv"),"UTF-8");
        pw.write(dataToString(data));
        pw.flush();
        pw.close();
    }

    public static <T> void writeDat(List<T> data,String name) throws Exception {
        OutputStreamWriter pw = new OutputStreamWriter(new FileOutputStream("./"+name+".dat"),"UTF-8");
        pw.write(dataToString(data));
        pw.flush();
        pw.close();
    }

    private static <T> String dataToString(List<T> data){
        StringBuilder sb = new StringBuilder();
        data.forEach(x->{
            sb.append(x.toString());
        });
        return sb.toString();
    }
}
