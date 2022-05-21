package com.training.sel;
//Code is just to access the Excel files.
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;

public class T10_AccessExcelCode2Way {
	public static void main(String[] args) {
		try {
		//Excel Access using JXL which can only access .xls files.
		File file = new File("C:/Users/deves/OneDrive/Documents/Eclipse Files/Selenium_TProject1/src/test/resources/ExcelData/testData.xls");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sheet = wb.getSheet(0);
		String value=sheet.getCell(0,0).getContents();
		System.out.println(value);
		int rowCount = sheet.getRows();
		for (int i = 0; i < rowCount; i++) {
			System.out.println(sheet.getCell(0,i).getContents());
		}
		wb.close();

		//Excel Access using POI which can access XLSX and XLS files.
		//For XLSX file in POI
		File file1 = new File("C:/Users/deves/OneDrive/Documents/Eclipse Files/Selenium_TProject1/src/test/resources/ExcelData/testexcelxlsx.xlsx");
		FileInputStream fis1 = new FileInputStream(file1);
		XSSFWorkbook workbook1 = new XSSFWorkbook(fis1);
		XSSFSheet sheet1 = workbook1.getSheet("Sheet1");
		String data1 = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data:"+data1);
		for (int i = 1; i < sheet1.getLastRowNum(); i++) {
			System.out.println("Data:"+sheet1.getRow(i).getCell(0).getStringCellValue());
		}
		workbook1.close();

		//For XLS file in POI
		File filels = new File("C:/Users/deves/OneDrive/Documents/Eclipse Files/Selenium_TProject1/src/test/resources/ExcelData/testData.xls");
		FileInputStream fils = new FileInputStream(filels);
		HSSFWorkbook workbookls = new HSSFWorkbook(fils);
		HSSFSheet sheetls = workbookls.getSheet("Sheet1");
		String datals = sheetls.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data:"+datals);
		for (int i = 0; i <= sheetls.getLastRowNum(); i++) {
			System.out.println("Data:"+sheetls.getRow(i).getCell(0).getStringCellValue());
		}
		workbookls.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
