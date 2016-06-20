package se.iths.Webapptest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Steps {
	
	public WebDriver driver;
	@Before
	
		public void beforeTest(){
			System.setProperty("webdriver.chrome.driver", "C:/Users/mandoori/Downloads/chromedriver_win32/chromedriver.exe");
			 driver= new ChromeDriver();
			driver.navigate().to("http://192.168.1.252:4200");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Given("^user is on first page$")
	public void user_is_on_first_page() throws Throwable {

		driver.findElement(By.className("address-field"));
	  
	    
	}
	@When("^user searches for \"([^\"]*)\"$")
	public void user_searches_for(String place) throws Throwable {
       WebElement addressInput= driver.findElement(By.className("address-field"));
		for(char c: place.toCharArray())
			addressInput.sendKeys(c + "");
		addressInput.sendKeys(Keys.ESCAPE);
	driver.findElement(By.xpath("//button[text()='Find Parking']")).click();
	
	}

	@Then("^user sees a list of parking optiona near \"([^\"]*)\"$")
	public void user_sees_a_list_of_parking_optiona_near(String place) throws Throwable {
	    
	 List<WebElement> parking =driver.findElements(By.className("list-group-item"));
	 Assert.assertFalse(parking.isEmpty());
	 Assert.assertTrue(parking.stream().anyMatch((i) -> i.getText().contains(place)));
	}
	@Given("^that the user has search results$")
	//har betyder user står på results (lista för parkings)
	public void that_the_user_has_search_results() throws Throwable {
		user_searches_for("ordinsgatan");
	}

	@Then("^user can bring up map$")
	public void user_can_bring_up_map() throws Throwable {
	    driver.findElement(By.tagName("h4")).findElement(By.tagName("button")).click();
	    try{
	    	driver.findElement(By.tagName("iframe"));
	    	
	    	
	    }catch (Exception e){
	    	Assert.fail(e.toString());
	    	
	    }
	}
	@When("^user login$")
	public void user_login() throws Throwable {
	    driver.findElement(By.className("nav-meny-btn")).click();
	    
	    driver.findElement(By.id("lg-useremail")).click();
	    driver.findElement(By.id("lg-useremail")).click(); 
	    driver.findElement(By.id("lg-confirm-btn-accoun")).click();
	}
	
	@Then("^user sees his sida$")
	public void user_sees_his_sida() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
