package generic;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.BaseClass;

public class Utility {
	WebDriver driver=BaseClass.driver;
/**
 * It is a generic method to check whether the webPage is containing the expected title value
 * @param expectedPartialTitle
 */
public void verifyTitle(String expectedPartialTitle) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	Boolean result = wait.until(ExpectedConditions.titleContains(expectedPartialTitle));
	Assert.assertTrue(result);
}
/**
 * It is a generic method to transfer the control to the child tab and close the parent tab
 */
public void switchToChild() {
String parentWindowId = driver.getWindowHandle();
Set<String> allWindowIds = driver.getWindowHandles();
for (String windowAddress : allWindowIds) {
	driver.switchTo().window(windowAddress);
	if(!windowAddress.equals(parentWindowId)) {
		break;
	}else {
		driver.close();
	}
}
}
}
