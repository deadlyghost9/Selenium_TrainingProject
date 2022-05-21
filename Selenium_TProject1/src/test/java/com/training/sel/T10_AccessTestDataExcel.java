package com.training.sel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T10_AccessTestDataExcel {
	public static void main(String[] args) {
		try {
			File filelo = new File("C:/Users/deves/OneDrive/Documents/Eclipse Files/Selenium_TProject1/src/test/resources/ExcelData/testLoginData.xlsx");
			FileInputStream fislo = new FileInputStream(filelo);
			XSSFWorkbook workbooklo = new XSSFWorkbook(fislo);
			XSSFSheet sheetlo = workbooklo.getSheet("Sheet1");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://demowebshop.tricentis.com/");
			driver.manage().window().maximize();
			for(int i=1;i<=sheetlo.getLastRowNum();i++)
			{
				String username = sheetlo.getRow(i).getCell(0).getStringCellValue();
				String password = sheetlo.getRow(i).getCell(1).getStringCellValue();
				driver.findElement(By.linkText("Log in")).click();
				driver.findElement(By.id("Email")).sendKeys(username);
				driver.findElement(By.id("Password")).sendKeys(password);
				driver.findElement(By.xpath("//input[@value='Log in']")).click();
				driver.findElement(By.linkText("Log out")).click();
				Thread.sleep(2000);
			}
			System.out.println("TEST SUCCESSFUL");
			workbooklo.close();
			driver.close();
			driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
