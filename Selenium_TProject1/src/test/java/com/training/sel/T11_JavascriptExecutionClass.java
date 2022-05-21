package com.training.sel;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T11_JavascriptExecutionClass {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
		//JavaScriptExecutor for navigation
		driver.get("http://demo.automationtesting.in/Frames.html");
		JavascriptExecutor jsen = (JavascriptExecutor) driver;
		jsen.executeScript("window.location='http://google.co.in'");
		
		//JavaScriptExecutor for DOC elements.
		driver.get("http://fb.com");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String title = jse.executeScript("return document.title").toString();
		System.out.println("Page Title :"+title);
		System.out.println("Page URL :"+jse.executeScript("return document.URL").toString());
		String domain = jse.executeScript("return document.domain").toString();
		System.out.println("Page Domain :"+domain);
	}
}
