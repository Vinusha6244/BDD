package basics;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zomato {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.zomato.com");
	
WebElement restaurants = driver.findElement(By.xpath("//a[contains(@href,'restaurants')]"));
	Actions a=new Actions(driver);
	a.scrollToElement(restaurants).perform();
	restaurants.click();
	Set<String> allWid = driver.getWindowHandles();
	for (String wid : allWid) {
		driver.switchTo().window(wid);
	}
	Thread.sleep(2000);
WebElement searchBox = driver.findElement
	(By.xpath("//input[contains(@placeholder,'Search for restaurant')]"));
searchBox.sendKeys("Meghana Foods");
searchBox.click();
Thread.sleep(5000);
	driver.findElement(By.xpath("//img[@alt='Restaurant Image']")).click();
	driver.findElement(By.xpath("//span[text()='Direction']")).click();
	allWid = driver.getWindowHandles();
	for (String wid : allWid) {
		driver.switchTo().window(wid);
	}
String duration = driver.findElement(By.xpath
("//div[@id='section-directions-trip-0']/div[1]/div/div[1]/div[1]")).getText();
String distance = driver.findElement(By.xpath
("//div[@id='section-directions-trip-0']/div[1]/div/div[1]/div[2]/div")).getText();
System.out.println(duration);
System.out.println(distance);
	
}
}
