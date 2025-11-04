package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {
public static WebDriver driver;
	@Before(order=0)
public void openBrowser() {
	Reporter.log("openBrowser",true);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
//	@Before(order=1)
//public void login() {
//	Reporter.log("login",true);
//}
//	@After(order=1)
//public void logout() {
//	Reporter.log("logout",true);
//}
	@After(order=0)
public void closeBrowser() {
	driver.quit();
	Reporter.log("closeBrowser",true);
}
}
