package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    public WebDriver driver;

    public Header(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id=\"chrome-sticky-header\"]/div[1]/div/ul[2]/li[2]/a")
    public WebElement savedLists;

    public void clickSavedLists()
    {
/*        Actions actions = new Actions(driver);
        actions.moveToElement(savedLists).click().build().perform();*/

        savedLists.click();
    }
}
