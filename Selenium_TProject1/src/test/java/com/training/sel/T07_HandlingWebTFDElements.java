package com.training.sel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T07_HandlingWebTFDElements {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));

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

		//Frames
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.switchTo().frame("a077aa5e"); //switching the frame by ID
		System.out.println("********We are switch to the iframe*******");
		driver.findElement(By.xpath("html/body/a/img")).click();
		
		//Different Frames
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		List<WebElement> mframes = driver.findElements(By.tagName("iframe"));
		System.out.println("Total frames present inside a page is "+mframes.size());
		for (WebElement webElement : mframes) {
			System.out.println("Text present in Frames :"+webElement.getText());
		}
		
	}
}
