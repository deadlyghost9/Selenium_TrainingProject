package com.training.sel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T12_ActionClass {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
		
		driver.get("http://demowebshop.tricentis.com/");
		//TO Mouse Over Menus and operation.
		WebElement Electronic = driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Electronic')]"));
		Actions act = new Actions(driver);
		act.moveToElement(Electronic).build().perform();
		Thread.sleep(3000);
		WebElement cellPhone = driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Cell phones')]"));
		act.moveToElement(cellPhone).click().perform();
		
		//Keyboard interaction using Action Class.
		//driver.get("http://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("manz@mass.com");
		Actions act1 = new Actions(driver);
		act1.sendKeys(Keys.TAB).perform();
		act1.sendKeys("mass123").perform();
		act1.sendKeys(Keys.TAB).perform();
		act1.sendKeys(Keys.TAB).perform();
		act1.sendKeys(Keys.TAB).perform();
		act1.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.linkText("Log out")).click();
		
		//Drag and drop Action Operation.
		String URL = "https://demoqa.com/droppable";    //"https://the-internet.herokuapp.com/drag_and_drop";
		driver.get(URL);
		//Actions class method to drag and drop 
		Actions builder = new Actions(driver);
		WebElement from = driver.findElement(By.id("draggable"));  //column-a
		WebElement to = driver.findElement(By.id("droppable")); //column-b
		
		//Perform drag and drop
		builder.dragAndDrop(from, to).perform();
		//verify text changed in to 'Drop here' box 
		String textTo = to.getText();
		if(textTo.equals("Dropped!")) {
		System.out.println("PASS: File is dropped to target as expected");
		}else {
		System.out.println("FAIL: File couldn't be dropped to target as expected");
		}
		driver.close();
	}
}

/*//WebElement on which drag and drop operation needs to be performed
WebElement fromElement = driver.findElement(By Locator of fromElement);

//WebElement to which the above object is dropped
WebElement toElement = driver.findElement(By Locator of toElement);

//Creating object of Actions class to build composite actions
Actions builder = new Actions(driver);

//Building a drag and drop action
Action dragAndDrop = builder.clickAndHold(fromElement)
.moveToElement(toElement)
.release(toElement)
.build();

//Performing the drag and drop action
dragAndDrop.perform();*/