package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SauceDemo {
WebDriver driver;
@Given("the url is {string}")
public void the_url_is(String url) {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
}

@When("the username entered is {string}")
public void the_username_entered_is(String username) {
	driver.findElement(By.id("user-name")).sendKeys(username);
}

@And("the password entered is {string}")
public void the_password_entered_is(String password) {
    driver.findElement(By.id("password")).sendKeys(password);
}

}
