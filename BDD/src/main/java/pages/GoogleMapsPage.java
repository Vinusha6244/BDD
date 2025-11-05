package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMapsPage {
	@FindBy(xpath = "//div[@id='section-directions-trip-0']/div[1]/div/div[1]/div[1]")
	private WebElement duration;
	@FindBy(xpath = "//div[@id='section-directions-trip-0']/div[1]/div/div[1]/div[2]/div")
	private WebElement distance;
	public GoogleMapsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String getDistance() {
		return distance.getText();
	}
	public String getDuration() {
		return duration.getText();
	}
}
