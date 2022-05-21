package com.training.sel;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T05_AlertsNPopups {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Alerts.html");

		//Alert handling
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		//Alert with TextBox
		driver.findElement(By.partialLinkText("Alert with Textbox")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();		
		Thread.sleep(2000);

		//Switch the focus or control to alert box.
		Alert alert1 = driver.switchTo().alert();
		alert1.sendKeys("GALACtas");
		alert1.accept();


		//PopUp Handling
		driver.get("http://demo.guru99.com/popup.php");
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		//Current Window store in String.
		String CurrentWindow=driver.getWindowHandle();

		//Multiple Windows
		Set<String> s1=driver.getWindowHandles();		
		Iterator<String> i1=s1.iterator();

		while (i1.hasNext()) {
			String Windows = (String) i1.next();
			if(!CurrentWindow.equalsIgnoreCase(Windows))			
			{    		

				// Switching to Child window
				driver.switchTo().window(Windows);	                                                                                                           
				driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");                			
				driver.findElement(By.name("btnLogin")).click();			
				System.out.println("Successfull Switched to Next Window");
				// Closing the Child Window.
				driver.close();		
				System.out.println("Closed the Current Window");
			}
		}
		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(CurrentWindow);
	}
}
