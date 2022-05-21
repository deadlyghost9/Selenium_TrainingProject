package com.training.sel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T03_DifferentTypesOfControl {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//h5[text()='Elements']")).click();

		//Checkbox
		System.out.println("Check Box Testing");
		driver.findElement(By.xpath("//span[text()='Check Box']")).click();
		driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/button")).click();
		System.out.println(driver.findElement(By.id("tree-node-documents")).isSelected());
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[1]")).click();
		System.out.println(driver.findElement(By.id("tree-node-documents")).isSelected());

		//Radio Button
		System.out.println("Radio Button Testing");
		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='yesRadio']")).isSelected());
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='yesRadio']")).isSelected());

		//Tables
		driver.get("http://demo.guru99.com/test/web-table-element.php"); 
		WebElement baseTable = driver.findElement(By.tagName("table"));
		
		//To find third row of table
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
		String rowtext = tableRow.getText();
		System.out.println("Third row of table : "+rowtext);

		//to get 3rd row's 2nd column data
		WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed); 
		
		//To find fourth row of table
		WebElement tableRow4 = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[4]"));
		String rowtext4 = tableRow4.getText();
		System.out.println("Fourth row of table : "+rowtext4);
		
		//to get 4th row's 4th column data
		WebElement cellIneed4 = tableRow4.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[4]/td[4]"));
		String valueIneed4 = cellIneed4.getText();
		System.out.println("Cell value is : " + valueIneed4); 	
	}
}
