package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DisableOptionsTest extends CoreTestCase {

    @Test
    public void settingsTest()
    {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement settingsIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("org.wikipedia:id/menu_settings"))); 

            // Click on the settings icon
            settingsIcon.click();

            // Wait for settings options to load
            List<WebElement> settingOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.className("android.widget.Switch"))); 

            // Disable all options (uncheck or turn off the switches)
            for (WebElement settingOption : settingOptions) {
                if (settingOption.isSelected()) {
                    settingOption.click(); // Disable the option by clicking the switch
                }
            }

            // Navigate back to the home page
            WebElement backButton = driver.findElement(By.className("android.widget.ImageButton")); 
            backButton.click();

        WebElement homePageElement = driver.findElement(By.id("org.wikipedia:id/main_page_element")); 
        assertTrue(homePageElement.isDisplayed());


    }

}
