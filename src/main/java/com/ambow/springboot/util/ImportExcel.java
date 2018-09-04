package com.ambow.springboot.util;

import com.ambow.springboot.entity.Buy;
import jxl.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImportExcel {

    public List<Buy> ImportExcel(File file) {
        // TODO Auto-generated method stub
        List<Buy> list = new ArrayList<Buy>();
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file);
            Workbook wb = Workbook.getWorkbook(is);
            // 页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int i = 0; i < sheet_size; i++) {
                // 读取每个sheet列数据，每一行组成一个对象，每一列为对象的一个属性，第一行为列名
                for (int j = 1; j < wb.getSheet(i).getRows(); j++) {
                    // sheet.getColumns()返回该页的总列数
                    Buy u = new Buy();
                    for (int k = 0; k < wb.getSheet(i).getColumns(); k++) {
                        if (wb.getSheet(i).getCell(k, 0).getContents().equals("name")) {
                            if (isNumeric(wb.getSheet(i).getCell(k, j).getContents())) {
                                u.setName(wb.getSheet(i).getCell(k, j).getContents());
                            } else {
                                u.setName("");
                            }
                        } if (wb.getSheet(i).getCell(k, 0).getContents().equals("num")) {
                            if (isNumeric(wb.getSheet(i).getCell(k, j).getContents())) {
                                u.setNum(wb.getSheet(i).getCell(k, j).getContents());
                            } else {
                                u.setNum("");
                            }
                        } else if (wb.getSheet(i).getCell(k, 0).getContents().equals("buyDate")) {
                            u.setBuyDate(new SimpleDateFormat().parse(wb.getSheet(i).getCell(k, j).getContents()));
                        } else if (wb.getSheet(i).getCell(k, 0).getContents().equals("price")) {
                            u.setPrice(Integer.parseInt(wb.getSheet(i).getCell(k, j).getContents()));
                        } else if (wb.getSheet(i).getCell(k, 0).getContents().equals("info")) {
                            u.setInfo(wb.getSheet(i).getCell(k, j).getContents());
                        }
                    }
                    list.add(u);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
