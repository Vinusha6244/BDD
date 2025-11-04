package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Flipkart {
	WebDriver driver;
	@Given("User should be present in flipkart home page")
	public void user_should_be_present_in_flipkart_home_page() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
	}	@When("User searches for a product")
	public void user_searches_for_a_product() {
	   driver.findElement(By.name("q")).sendKeys("Laptop"+Keys.ENTER);
	}	@Then("Product page should be displayed")
	public void product_page_should_be_displayed() {
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
