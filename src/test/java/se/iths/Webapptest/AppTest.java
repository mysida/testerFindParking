package se.iths.Webapptest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;



/**
 * Unit test for simple App.
 */
public class AppTest 
   
{
public WebDriver driver;
@Before
public void beforeTest(){
	System.setProperty("webdriver.chrome.driver", "C:/Users/mandoori/Downloads/chromedriver_win32/chromedriver.exe");
	 driver= new ChromeDriver();
	driver.navigate().to("localhost:4200");
 }


@Test
public void basicTest(){
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	WebElement address= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/quick-search/div/div[2]/div[1]/input"));
	for(char c: "odinsgatan".toCharArray())
		address.sendKeys(c + "");
address.sendKeys(Keys.ESCAPE);
driver.findElement(By.xpath("//button[text()='Find Parking']")).click();
WebElement title = driver.findElement(By.tagName("h4"));
title.findElement(By.className("btn")).click();
WebDriverWait waiter = new WebDriverWait(driver, 5000);
waiter.until(ExpectedConditions.textToBePresentInElementLocated(By.id("myModal"), "41 meter till din"));
Assert.assertTrue(driver.findElement(By.id("myModal")).getText().contains("41 meter till din destination från denna parkering."));
}

	

@Test

	public void testParkingNear(){
	
		((ChromeDriver) driver).executeScript("window.navigator.geolocation.getCurrentPosition = "
				+ "function(success){"
				+ "var position = {'coords' : {"
				+ "'latitude': '59',"
				+ "'longitude': '10'"
				+ "}"
				+ "};"
				+ "success(position);}");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement near= driver.findElement(By.id("showNearMe"));
		near.click();
	//	WebElement sida= driver.findElement(By.className(""));
		 try{
			 WebDriverWait waiter = new WebDriverWait(driver, 5000);
		    	driver.findElement(By.id("parkingMap"));
		    	
		    	
		    }catch (Exception e){
		    	Assert.fail(e.toString());
}
	}
	
@Test
public void testLoginMedGiltigParkingVärde(){
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement log= driver.findElement(By.linkText("Login"));
	log.click();
	WebElement email= driver.findElement(By.id("lg-useremail"));
	for(char c: "tanjabadi@yahoo.com".toCharArray())
		email.sendKeys(c + "");
	email.click();
	WebElement pass= driver.findElement(By.id("lg-password"));
	for(char c: "tanjabadi0324".toCharArray())
		pass.sendKeys(c + "");
	pass.click();
	
	
		WebElement login= driver.findElement(By.id("lg-confirm-btn-account"));
	login.click();
	
	WebElement address= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/quick-search/div/div[2]/div[1]/input"));
	//address.click();
	for(char c: "Flatåsskola".toCharArray())
		address.sendKeys(c + "");
address.sendKeys(Keys.ESCAPE);

WebElement find=driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/quick-search/div/div[2]/div[2]/button[1]"));
find.click();
WebElement title = driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/show-parkings/div/div[2]/div/div[1]/div[1]/h4"));
title.click();
WebElement map = driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/show-parkings/div/div[2]/div/div[1]/div[1]/h4/span/button"));
map.click();

WebDriverWait waiter = new WebDriverWait(driver, 5000);
waiter.until(ExpectedConditions.textToBePresentInElementLocated(By.id("myModal"), "111 meter till"));
Assert.assertEquals(driver.findElement(By.cssSelector("#myModal > div > div > div.modal-header > div > p:nth-child(2)")).getText(),"111 meter till din destination från denna parkering.");
}
@Test
// ska visa upp parkeringer som näre Göteborg centralen
public void testLoginMedOgiltigParkingVärde(){
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement log= driver.findElement(By.linkText("Login"));
	log.click();
	WebElement email= driver.findElement(By.id("lg-useremail"));
	for(char c: "tanjabadi@yahoo.com".toCharArray())
		email.sendKeys(c + "");
	email.click();
	WebElement pass= driver.findElement(By.id("lg-password"));
	for(char c: "tanjabadi0324".toCharArray())
		pass.sendKeys(c + "");
	pass.click();
	
	
		WebElement login= driver.findElement(By.id("lg-confirm-btn-account"));
	login.click();
	
	WebElement address= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/quick-search/div/div[2]/div[1]/input"));
	
	for(char c: "qqqq".toCharArray())
		address.sendKeys(c + "");
	address.click();
address.sendKeys(Keys.ESCAPE);

driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/quick-search/div/div[2]/div[2]/button[1]")).click();
WebElement title = driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/show-parkings/div/div[2]/div/div[1]/div[1]/h4"));
title.click();
WebElement map = driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/show-parkings/div/div[2]/div/div[1]/div[1]/h4/span/button"));
map.click();
WebDriverWait waiter = new WebDriverWait(driver, 5000);
waiter.until(ExpectedConditions.textToBePresentInElementLocated(By.id("myModal"), "111 meter till"));
Assert.assertEquals("111 meter till din destination från denna parkering.",driver.findElement(By.cssSelector("#myModal > div > div > div.modal-header > div > p:nth-child(2)")).getText());
}	
	@Test
	public void testNagativBytaPassword(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement log= driver.findElement(By.linkText("Login"));
		log.click();
		WebElement email= driver.findElement(By.id("lg-useremail"));
		for(char c: "tanjabadi@yahoo.com".toCharArray())
			email.sendKeys(c + "");
		email.click();
		WebElement pass= driver.findElement(By.id("lg-password"));
		for(char c: "tanjabadi0324".toCharArray())
			pass.sendKeys(c + "");
		pass.click();
		
		
			WebElement login= driver.findElement(By.id("lg-confirm-btn-account"));
		login.click();
		WebElement sinanSida= driver.findElement(By.linkText("tanjajuda"));
		sinanSida.click();
		WebElement setting= driver.findElement(By.linkText("Settings"));
		setting.click();
		WebElement oldpass= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/div/div[3]/div[4]/input"));
		for(char c: "tanjabadi0324".toCharArray())
			oldpass.sendKeys(c + "");
		oldpass.click();
		WebElement nypass= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/div/div[3]/div[5]/input"));
		for(char c: "skl".toCharArray())
			nypass.sendKeys(c + "");
		nypass.click();
		WebElement update= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/div/div[3]/div[6]/button"));
		update.click();
		WebDriverWait waiter = new WebDriverWait(driver, 5000);
		waiter.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("body > find-parking-goteborg-app > router-outlet:nth-child(3) > div > div:nth-child(3) > div:nth-child(7)"), "New password"));
		Assert.assertEquals("New password is too short.",driver.findElement(By.cssSelector("body > find-parking-goteborg-app > router-outlet:nth-child(3) > div > div:nth-child(3) > div:nth-child(7)")).getText());
}
@Test
	public void testbytMailNagativ(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement log= driver.findElement(By.linkText("Login"));
		log.click();
		WebElement email= driver.findElement(By.id("lg-useremail"));
		for(char c: "tanjabadi@yahoo.com".toCharArray())
			email.sendKeys(c + "");
		email.click();
		WebElement pass= driver.findElement(By.id("lg-password"));
		for(char c: "tanjabadi0324".toCharArray())
			pass.sendKeys(c + "");
		pass.click();
		
			WebElement login= driver.findElement(By.id("lg-confirm-btn-account"));
		login.click();
		WebElement tanjaSida= driver.findElement(By.linkText("tanjajuda"));
		tanjaSida.click();
		WebElement setting= driver.findElement(By.linkText("Settings"));
		setting.click();
		
		
		WebElement newmail= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/div/div[3]/div[10]/input"));
		newmail.click();
		for(char c: "tanja?yahoo.com".toCharArray())
			newmail.sendKeys(c + "");
			
		WebElement update= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/router-outlet[2]/div/div[3]/div[11]/button"));
		update.click();
		WebDriverWait waiter = new WebDriverWait(driver, 5000);
		waiter.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("body > find-parking-goteborg-app > router-outlet:nth-child(3) > div > div:nth-child(3) > div:nth-child(12) > account-feedback > span"), "Error: The specified email address is invalid."));
		Assert.assertEquals("Error: The specified email address is invalid.", driver.findElement(By.cssSelector("body > find-parking-goteborg-app > router-outlet:nth-child(3) > div > div:nth-child(3) > div:nth-child(12) > account-feedback > span")).getText());
	}
	
			@Test
			public void testLoggut(){
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement log= driver.findElement(By.linkText("Login"));
				log.click();
				WebElement email= driver.findElement(By.id("lg-useremail"));
				for(char c: "tanjabadi@yahoo.com".toCharArray())
					email.sendKeys(c + "");
				email.click();
				WebElement pass= driver.findElement(By.id("lg-password"));
				for(char c: "tanjabadi0324".toCharArray())
					pass.sendKeys(c + "");
				pass.click();
				
				
					WebElement login= driver.findElement(By.id("lg-confirm-btn-account"));
				login.click();
				WebElement tanjaSida= driver.findElement(By.linkText("tanjajuda"));
				tanjaSida.click();
			
			WebElement logut= driver.findElement(By.linkText("Logout"));
			logut.click();
			WebElement startsida= driver.findElement(By.id("meny-gbg-nav"));
			Assert.assertTrue(startsida.getText().contains("Search parking"));	
			}
			@Test
			public void testSkapTrip(){
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement log= driver.findElement(By.linkText("Login"));
				log.click();
				WebElement email= driver.findElement(By.id("lg-useremail"));
				for(char c: "tanjabadi@yahoo.com".toCharArray())
					email.sendKeys(c + "");
				email.click();
				WebElement pass= driver.findElement(By.id("lg-password"));
				for(char c: "tanjabadi0324".toCharArray())
					pass.sendKeys(c + "");
				pass.click();
				
				
					WebElement login= driver.findElement(By.id("lg-confirm-btn-account"));
				login.click();
				
				WebElement GreatTrip= driver.findElement(By.cssSelector("#meny-gbg-nav > ul:nth-child(1) > li:nth-child(2) > a"));
				GreatTrip.click();
				WebElement namn= driver.findElement(By.cssSelector("body > find-parking-goteborg-app > create > trip-creator > div.container > div.row.margin-top > div:nth-child(2) > input"));;
				for(char c: "sommer".toCharArray())
					namn.sendKeys(c + "");
				namn.click();
				
				WebElement distination= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/create/trip-creator/div[1]/div[3]/div[2]/input"));
				distination.click(); 
				WebElement save= driver.findElement(By.xpath("/html/body/find-parking-goteborg-app/create/trip-creator/div[1]/div[7]/button"));
				save.click();
			}
}

