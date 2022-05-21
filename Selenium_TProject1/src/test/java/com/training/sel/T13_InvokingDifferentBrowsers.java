package com.training.sel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T13_InvokingDifferentBrowsers {
	//Code for Cross Browsing selection.
	static WebDriver driver = null;
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
			//System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			//System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
		else if(browser.equalsIgnoreCase("Edge")){
			//set path to Edge.exe
			//System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
			WebDriverManager.edgedriver().setup();
			//create Edge instance
			driver = new EdgeDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
	}
	public static void main(String[] args) {
		T13_InvokingDifferentBrowsers obj = new T13_InvokingDifferentBrowsers();
		try {
			obj.setup("edge");
			driver.get("https://google.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
