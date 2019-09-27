package com.xahi.reporteddata.util.file;

import com.xahi.reporteddata.constants.request.FileType;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import static com.xahi.reporteddata.constants.Symbol.FEED;

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
        OutputStreamWriter pw = new OutputStreamWriter(new FileOutputStream("./"+name+ FileType.DAT.type),"UTF-8");
        pw.write(dataToString(data));
        pw.flush();
        pw.close();
    }

    private static <T> String dataToString(List<T> data){
        StringBuilder sb = new StringBuilder();
        data.forEach(x->{
            sb.append(x.toString()+FEED.symbol);
        });
        return sb.toString();
    }
}
