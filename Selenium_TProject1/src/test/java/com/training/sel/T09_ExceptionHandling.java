package com.training.sel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T09_ExceptionHandling {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
		driver.get("https://google.com");
		//Exception Handling
		try {
			driver.findElement(By.name("q")).sendKeys("Search Something");
			driver.findElement(By.name("btn")).click();
		} catch (NoSuchElementException e) {
			System.out.println("Exception Caught");
			e.printStackTrace();
		}
	}
}
