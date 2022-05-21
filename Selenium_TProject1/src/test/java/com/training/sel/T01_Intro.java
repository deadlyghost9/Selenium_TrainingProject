package com.training.sel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T01_Intro {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		//Tab methods
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//System.out.println(driver.getPageSource());
		
		//Navigate Methods.
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		
		//Switching Window
		String originalWindow=driver.getWindowHandle();
		//driver.switchTo().window(originalWindow);

		//Create New window and Switch to new Window
		driver.switchTo().newWindow(WindowType.WINDOW);
		//Create New tab and Switch to new Window
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(2000);
		
		driver.switchTo().window(originalWindow); //Change the window.
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		//Close Window
		driver.close();
		//Close All windows
		driver.quit();
	}
}
