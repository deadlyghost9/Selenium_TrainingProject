package com.training.sel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T02_Locators {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		//Locators
		//Name Locator
		driver.findElement(By.name("q")).sendKeys("Modern Family");
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);
		//Locator Partial LinkText
		driver.findElement(By.partialLinkText("Modern Family - Wikipedia")).click();
		Thread.sleep(2000);
		//Locator LinkText
		driver.findElement(By.linkText("family sitcom")).click();
		//Locator Relatives Xpath
		driver.findElement(By.xpath("//a[@href = '#Politics']")).click();
		//Locator Absolutes Xpath
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/h2[3]/span[2]/a")).click();
		//Locators
	
		//driver.findElement(By.className(""));
		//driver.findElement(By.cssSelector(""));
		//driver.findElement(By.id(""));
		//driver.findElement(By.tagName(""));
	}
}
