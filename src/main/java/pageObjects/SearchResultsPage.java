package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {

    public SearchResultsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class=\"yuRUbf\"]/a/h3/span")
    public List<WebElement> searchResults;


    public void validateSearchResults(String validationTerm)
    {
        for (int i=0;i<searchResults.size();i++)
        {
            Assert.assertTrue("search result validation failed at "+i+".", searchResults.get(i).getText().contains(validationTerm));
        }
    }
}
