package stepdefinitions;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Utility;
import hooks.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleMapsPage;
import pages.HomePage;
import pages.RestaurantsPage;
import pages.SelectedRestaurantPage;

public class Zomato {
	WebDriver driver=BaseClass.driver;
	Utility u=new Utility();
	RestaurantsPage r=new RestaurantsPage(driver);
	@Given("User should trigger {string} in browser")
	public void user_should_trigger_in_browser(String url) {
		driver.get(url);}
	@When("User clicks on zomato restaurant link")
	public void user_clicks_on_zomato_restaurant_link() {
		HomePage h=new HomePage(driver);
		WebElement restaurants = h.getRestaurantsLink();
//		WebElement restaurants = driver.findElement(By.xpath("//a[contains(@href,'restaurants')]"));
		Actions a=new Actions(driver);
		a.scrollToElement(restaurants).perform();
		restaurants.click();	}
	@Then("Zomato dashboard should be displayed")
	public void zomato_dashboard_should_be_displayed() {
		u.switchToChild();
//		Set<String> allWid = driver.getWindowHandles();
//		for (String wid : allWid) {
//			driver.switchTo().window(wid);
//		}	
		u.verifyTitle("Best Restaurants");
//		System.out.println(driver.getTitle());
	}
	@When("he searches for {string}")
	public void he_searches_for(String restaurantName) throws InterruptedException {
		Thread.sleep(2000);
		r.setSearchBox(restaurantName);
//		WebElement searchBox = driver.findElement
//			(By.xpath("//input[contains(@placeholder,'Search for restaurant')]"));
//		searchBox.sendKeys(restaurantName);
//		searchBox.click();
	}
	@Then("Restaurant list should be displayed")
	public void restaurant_list_should_be_displayed() {
	boolean res=r.checkRestaurantList();
//boolean res = driver.findElement(By.xpath("//img[@alt='Restaurant Image']/../../..")).isDisplayed();
	Assert.assertTrue(res);
	}
	@When("he selects the first option")
	public void he_selects_the_first_option() {
		r.setFirstOption();
//		driver.findElement(By.xpath("//img[@alt='Restaurant Image']")).click();
	}
	@Then("{string} should be displayed")
	public void should_be_displayed(String restaurantName) {
		u.verifyTitle(restaurantName);
//		System.out.println(driver.getTitle());
	}
	@When("he clicks on direction link")
	public void he_clicks_on_direction_link() {
		SelectedRestaurantPage s=new SelectedRestaurantPage(driver);
		s.setDirections();
//		driver.findElement(By.xpath("//span[text()='Direction']")).click();
	}
	@Then("It should be navigated to google maps")
	public void it_should_be_navigated_to_google_maps() {
		u.switchToChild();
//		Set<String> allWid = driver.getWindowHandles();
//		for (String wid : allWid) {
//			driver.switchTo().window(wid);
//		}
	}
	@Then("Duration and distance should be displayed")
	public void duration_and_distance_should_be_displayed() {
		GoogleMapsPage g=new GoogleMapsPage(driver);
		String distance = g.getDistance();
		String duration = g.getDuration();
//		String duration = driver.findElement(By.xpath
//		("//div[@id='section-directions-trip-0']/div[1]/div/div[1]/div[1]")).getText();
//		String distance = driver.findElement(By.xpath
//		("//div[@id='section-directions-trip-0']/div[1]/div/div[1]/div[2]/div")).getText();
		Reporter.log(duration,true);
		Reporter.log(distance,true);
	}
}
