package com.utilitpkg;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;


import java.io.File;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static com.basepkg.BaseClass.driver;
import static java.util.logging.LogManager.*;

public class Utilis {

    public static long PAGE_LOAD_TIMEOUT =20;
    public static long IMPLICIT_WAIT =10;

  //private static Logger log = LogManager.getLogger(Utilis.class);


    public static Object[][] getExcelData(String fileName, String sheetName) {

        Object[][] data = null;
        XSSFWorkbook wb = null;

        try {
            wb = new XSSFWorkbook("C:\\Users\\mpm26\\eclipse-workspace\\AutomationFramwrk1\\src\\test\\resources\\testdata.xlsx");
            XSSFSheet sheet = wb.getSheet(sheetName);
            int rowsIndex = sheet.getLastRowNum();  //return last row number ie, how many data sets we want to run-row index starts from 0, so last row no is 4
            data = new Object[rowsIndex][];
            for (int i = 1; i <= rowsIndex; i++) {
                XSSFRow row = sheet.getRow(i);
                int cols = row.getLastCellNum();
                Object[] colData = new Object[cols];
                for (int j = 0; j < cols; j++) {
                    colData[j] = row.getCell(j).toString();
                }
                data[i - 1] = colData;
            }

        } catch (IOException e) {

        } finally {
            try {
                wb.close();
            } catch (IOException e) {
            }
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   //take screenshot and store it in a file
        String currentDir = System.getProperty("user.dir");    //give the location where we have to save the screenshot taken
        FileHandler.copy(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));   //finally copy the screenshot taken to the location
    }
    }


