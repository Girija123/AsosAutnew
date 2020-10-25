package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "a")
    public List<WebElement> allLinks;

    public void validateLinks()
    {
        for(int i=1; i<=15; i++)
        {
            if(allLinks.get(i).getAttribute("href")!=null) {
                System.out.println(allLinks.get(i).getText() + allLinks.get(i).getAttribute("href"));
            }
            else
            {
                System.out.println(allLinks.get(i).getText());
            }
        }
    }
}
