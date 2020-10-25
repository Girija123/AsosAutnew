package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedListsPage {

    public SavedListsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//h2[@class=\"noItemsPrompt_1TiQf\"]")
    public WebElement noSavedItemsText;

    public void validateNoSavedItems(String expectedText)
    {
        Assert.assertEquals(expectedText, noSavedItemsText.getText());
    }
}
