package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("New York");
        SearchPageObject.waitForSearchResult("Most populous city in the United States");
        CancelSearchByDoubleClick();
    }




    private void CancelSearchByDoubleClick()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.dblClickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
        WebElement homePageElement = driver.findElement(By.id("org.wikipedia:id/main_page_element"));
        assertTrue(homePageElement.isDisplayed());

    }




}
