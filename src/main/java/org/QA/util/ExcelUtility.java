package org.QA.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {


    public static Object[][] getExcelData() {

        String Path = "/Users/divee/IdeaProjects/SeleniumWithTestNG/TestData/TestData.xlsx";
        Object[][] arrayExcelData = null;

        try {

            List<Object[]> tempData = new ArrayList<>();

            FileInputStream fileInputStream = new FileInputStream(Path);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet("TestData");

            int totalNumberOfRows = sheet.getLastRowNum() + 1;
            int totalNumberOfCols = sheet.getRow(0).getPhysicalNumberOfCells();

            for (int i = 0; i < totalNumberOfRows; i++) {
                XSSFCell runStatusCell = sheet.getRow(i).getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if (runStatusCell.getStringCellValue().equalsIgnoreCase("Y")) {
                    Object[] rowdata = new Object[totalNumberOfCols];
                    for (int j = 0; j < totalNumberOfCols; j++) {
                        XSSFCell cell = sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                rowdata[j] = (int) cell.getNumericCellValue();


                            case STRING:
                                rowdata[j] = cell.getStringCellValue();


                            case BOOLEAN:
                                rowdata[j] = (boolean) cell.getBooleanCellValue();

                        }

                    }
                    tempData.add(rowdata);

                }


            }

            arrayExcelData = tempData.toArray(new Object[0][0]);

            return arrayExcelData;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
