package com.joe.reporteddata.util.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author JoeToffler
 * @describe
 * @date 2019-09-17 9:56
 */
public class ExcelLocalDown {
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName) throws IOException {
        defaultExport(list, pojoClass, fileName, new ExportParams(title, sheetName));
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, ExportParams exportParams) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        downLoadExcel(fileName, workbook);
    }

    private static void downLoadExcel(String fileName, Workbook workbook) throws IOException {
        File f = new File("./" + fileName + ".csv");
        OutputStream out = new FileOutputStream(f);
        workbook.write(out);
        out.close();
    }

    public static void exportExcel(List<Map<String, Object>> list, String fileName) throws IOException {
        defaultExport(list, fileName);
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        downLoadExcel(fileName, workbook);
    }



}
