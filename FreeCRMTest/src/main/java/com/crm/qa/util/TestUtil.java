package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 20;
	public static String TEST_EXCEL_PATH = "C:\\Users\\Jithin\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTest.xls"; 
	static Workbook book;
	static Sheet sheet;	

	public void switchToFrame() {
		driver.switchTo().frame("frame name"); //use it wherever required
		//now in corresponding test class, create an object for this -> TestUtil testutil;
		//in @BeforeTest -> testutil = new TestUtil();
		//in @Test -> testutil.switchToFrame();
	}
		
			public static Object[][] getTestData(String sheetname) {
			FileInputStream file = null;
			try {
				file = new FileInputStream(TEST_EXCEL_PATH);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch(InvalidFormatException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			sheet = book.getSheet(sheetname);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				}
			}
			return data;			
		}

			public static void takeScreenshotAtEndOfTest() {
				// TODO Auto-generated method stub
				
			}
}
