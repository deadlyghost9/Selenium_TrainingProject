package com.training.sel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T04_DropDownSelect {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
		driver.get("http://demowebshop.tricentis.com/");
		//To Mouse Over Menus and operation.
		WebElement Computer = driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]"));
		Actions act = new Actions(driver);
		act.moveToElement(Computer).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement NoteBook = driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Notebooks')]"));
		act.moveToElement(NoteBook).click().perform();
		WebElement sort = driver.findElement(By.id("products-orderby"));
		//Select Class to Handle Drop Downs
		Select sel = new Select(sort);
		List<WebElement> selSort = sel.getOptions();
		System.out.println("Value Stored at"+selSort.get(2).getText());
		System.out.println("Total elements present inside a list are:"+selSort.size());
		for (WebElement webElement : selSort) {
			System.out.println("Value present"+webElement.getText());
		}
	}
}
//To Handle Dynamic DropDown we will use findElements() and then in List if find Element we want to select we will press click() in for loop. 