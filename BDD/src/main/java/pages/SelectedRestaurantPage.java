package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedRestaurantPage {
@FindBy(xpath = "//span[text()='Direction']")
private WebElement directionLink;

public SelectedRestaurantPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void setDirections() {
	directionLink.click();
}
}
