package com.training.sel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T08_ImplicitNExplicitWaits {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("version number").setup();
		WebDriver driver = new ChromeDriver();
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://facebook.com/");
		
		//Fluent Wait
		Wait fwait = new FluentWait(driver).withTimeout(Duration.ofSeconds(2)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		
		driver.findElement(By.id("DS"));
		//Explicit Wait
		WebElement username = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
		/*
		WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
		alertIsPresent()
		elementSelectionStateToBe()
		elementToBeClickable()
		elementToBeSelected()
		frameToBeAvaliableAndSwitchToIt()
		invisibilityOfTheElementLocated()
		invisibilityOfElementWithText()
		presenceOfAllElementsLocatedBy()
		presenceOfElementLocated()
		textToBePresentInElement()
		textToBePresentInElementLocated()
		textToBePresentInElementValue()
		titleIs()
		titleContains()
		visibilityOf()
		visibilityOfAllElements()
		visibilityOfAllElementsLocatedBy()
		visibilityOfElementLocated()
		 */

	}
}
