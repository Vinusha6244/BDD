package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestaurantsPage {
@FindBy(xpath = "//input[contains(@placeholder,'Search for restaurant')]")
private WebElement searchBox;

@FindBy(xpath = "//img[@alt='Restaurant Image']/../../..")
private WebElement restaurantList;

@FindBy(xpath = "//img[@alt='Restaurant Image']")
private WebElement firstRestaurant;

public RestaurantsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void setSearchBox(String restaurantName) {
	searchBox.sendKeys(restaurantName);
	searchBox.click();
}

public boolean checkRestaurantList() {
	return restaurantList.isDisplayed();
}

public void setFirstOption() {
	firstRestaurant.click();
}
}
