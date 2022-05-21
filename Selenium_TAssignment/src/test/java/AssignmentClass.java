import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentClass {
/*
	Assignment 
	Automate End to End Buy Order functionality. 

	Steps to Automate: 
	1. Open link http://automationpractice.com/index.php 
	2. Login to the website. 
	3. Move your cursor over Women's link. 
	4. Click on sub menu 'T-shirts'. 
	5. Mouse hover on the second product displayed. 
	6. 'More' button will be displayed, click on 'More' button. 
	7. Increase quantity to 2. 
	8. Select size 'L' 
	9. Select colour. 
	10. Click 'Add to Cart' button. 
	11. Click 'Proceed to checkout' button. 
*/
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.manage().timeouts ().scriptTimeout (Duration.ofMinutes (2));
		driver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));

		String URL="http://automationpractice.com/index.php";
		driver.get(URL);

		driver.manage().window().maximize();
		//Click on Sign in
		driver.findElement(By.linkText("Sign in")).click();
		//Login
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("domroyal541@test.com");
		driver.findElement(By.id("passwd")).sendKeys("56DOMQW");
		driver.findElement(By.id("SubmitLogin")).click();

		//Hover Over Women
		WebElement womenHover = driver.findElement(By.linkText("WOMEN"));
		Actions wact = new Actions(driver);
		wact.moveToElement(womenHover).build().perform();

		//Clicked on Tshirt
		WebElement tshirtOption = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		wact.moveToElement(tshirtOption).click().perform();

		//Hover over Image and Clicked on more
		WebElement productImg=driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"));
		WebElement moreBtn=driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[2]"));
		Actions actions=new Actions(driver);
		actions.moveToElement(productImg).moveToElement(moreBtn).click().perform();

		//Change quantity by 2
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("2");

		//Select size as L
		WebElement tshirtSize=driver.findElement(By.xpath("//*[@id='group_1']"));
		Select oSelect=new Select(tshirtSize);
		oSelect.selectByVisibleText("L");

		//Select Color
		driver.findElement(By.id("color_14")).click();

		//Click on add to cart
		driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
		Thread.sleep(3000);

		//Click on proceed
		//driver.findElement(By.xpath("//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")));
		Thread.sleep(2000);

		//Checkout page Proceed
		driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")).click();
		driver.findElement(By.xpath("//*[@id='center_column']/form/p/button/span")).click();

		//Agree terms&Conditions
		driver.findElement(By.xpath("//*[@id='cgv']")).click();
		driver.findElement(By.xpath("//*[@id='form']/p/button/span")).click();

		//Click on Payby Check
		driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")).click();

		//Confirm the order
		driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span")).click();

		//Get Text
		String ConfirmationText=driver.findElement(By.xpath("//*[@id='center_column']/div/p/strong")).getText();

		// Verify that Product is ordered
		if(ConfirmationText.contains("complete")) {
			System.out.println("Order Completed: Test Case Passed");
		} else {
			System.out.println("Order Not Successfull: Test Case Failed");
		}
		driver.close();
		driver.quit();
	}
}
