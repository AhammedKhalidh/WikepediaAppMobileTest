package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static lib.ui.SearchPageObject.SEARCH_INIT_ELEMENT;

public class WikipediaTests extends CoreTestCase {

    private WebDriverWait wait;

    @Test
    public void testTask1() throws InterruptedException {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        // Wait for an element that indicates the app has launched
        // In this case, we wait for the "Search Wikipedia" button to be visible
        SearchPageObject.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking init element");
        // Scroll down to the end of the page
        scrollToEnd();

        // Click on "My Lists" icon
        MobileElement myListsIcon = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='My lists']"));
        myListsIcon.click();
        //Thread.sleep(3000);
         wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Explicit wait for 3 seconds

        // Locate the "My Lists" icon element (adjust the selector as needed)
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='My Lists']")));
         assertTrue(myListsIcon.isDisplayed());

        // Click on "History" icon
        MobileElement historyIcon = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='History']"));
        historyIcon.click();
        Thread.sleep(3000);  // Wait for 3 seconds on this page
        assertTrue(historyIcon.isDisplayed());
        // Click on "Nearby" icon
        MobileElement nearbyIcon = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Nearby']"));
        nearbyIcon.click();
        Thread.sleep(3000);  // Wait for 3 seconds on this page
        assertTrue(nearbyIcon.isDisplayed());

        // Go back to home page by clicking the "Browse" icon
        MobileElement browseIcon = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Browse']"));
        browseIcon.click();
        Thread.sleep(3000);  // Wait for 3 seconds on the homepage
        assertTrue(browseIcon.isDisplayed());

        // Scroll up to the first topic of the app
        scrollToTop();
    }

    // Scroll to the end of the page
    public void scrollToEnd() {
        Dimension dimension = driver.manage().window().getSize();
        int startX = dimension.width / 2;
        int startY = (int) (dimension.height * 0.8); // Start from 80% of the screen height
        int endY = (int) (dimension.height * 0.2); // End at 20% of the screen height

        TouchAction action = new TouchAction(driver);
        action.press((WebElement) PointOption.point(startX, startY))
                .moveTo((WebElement) PointOption.point(startX, endY))
                .release()
                .perform();

    }

    public void scrollToTop() {
        Dimension dimension = driver.manage().window().getSize();
        int startX = dimension.width / 2;
        int startY = (int) (dimension.height * 0.2); // Start from 20% of the screen height
        int endY = (int) (dimension.height * 0.8); // End at 80% of the screen height

        TouchAction action = new TouchAction(driver);
        action.press((WebElement) PointOption.point(startX, startY))
                .moveTo((WebElement) PointOption.point(startX, endY))
                .release()
                .perform();
    }

}
