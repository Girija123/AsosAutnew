
package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public static WebDriver driver;

    public SearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="q")
    public WebElement searchTxtFld;

    @FindBy(name="btnK")
    public WebElement searchBtn;

    public void enterSearchTerm(String searchTerm)
    {
        searchTxtFld.sendKeys(searchTerm);
    }

    public void clickSearchButton()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(searchBtn).click().build().perform();
    }
}
