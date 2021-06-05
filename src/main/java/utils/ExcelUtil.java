package utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelUtil {

    String filename="Product_data";

    public void writeIntoExcel(String sheetName, ArrayList<String> data) throws IOException {

        File file = new File(System.getProperty("user.dir")+File.separator+filename+".xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook productWorkbook = new XSSFWorkbook(inputStream);
        Sheet sheet = productWorkbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        Row row = sheet.getRow(0);
        Row newRow = sheet.createRow(rowCount+1);
        for(int j = 0; j < row.getLastCellNum(); j++){
            Cell cell = newRow.createCell(j);
            cell.setCellValue(data.get(j));
        }
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        productWorkbook.write(outputStream);
        outputStream.close();
    }
}
