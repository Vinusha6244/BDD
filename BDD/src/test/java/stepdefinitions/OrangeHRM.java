package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRM {
	WebDriver driver;
	@Given("User should be present in {string}")
	public void user_should_be_present_in(String url) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);	}
	@When("he enters the username as {string}")
	public void he_enters_the_username_as(String un) {
		driver.findElement(By.name("username")).sendKeys(un);
	}	@And("he enters the password as {string}")
	public void he_enters_the_password_as(String pwd) {
		driver.findElement(By.name("password")).sendKeys(pwd);
	}	@And("he clicks on login button")
	public void he_clicks_on_login_button() {
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}	@Then("Dashboard page should be displayed")
	public void dashboard_page_should_be_displayed() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		Boolean res = wait.until(ExpectedConditions.urlContains("dashboard"));
		Assert.assertTrue(res);
	}

}